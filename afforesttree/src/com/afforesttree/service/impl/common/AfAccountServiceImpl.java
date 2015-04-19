package com.afforesttree.service.impl.common;


import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.afforesttree.bean.ecom.JUser;
import com.afforesttree.dao.common.AfAccountDao;
import com.afforesttree.domain.common.AfAccount;
import com.afforesttree.service.common.AfAccountService;
import com.afforesttree.util.CacheManager;
import com.afforesttree.util.CookieUtils;
import com.afforesttree.util.JUtility;
import com.afforesttree.util.UrlUtils;

@Service("accountService")
public class AfAccountServiceImpl implements AfAccountService {
	@Resource
	private AfAccountDao accountDao;
	
	public AfAccount login(JUser jUser, String ip) {
		if(checkAccountPassword(jUser.getEmail(), jUser.getPassword())){
			String accountId = JUtility.strToMD5(jUser.getEmail());
			AfAccount account = getAccount(accountId);
			if(account.getLoginCookie() != null){
				CacheManager.getInstance().removeAccountLoginCookieCache(account.getLoginCookie());
			}
			account.setLoginCookie(UUID.randomUUID().toString());
			CacheManager.getInstance().putAccountLoginCookieCache(account.getLoginCookie(), accountId);
			account.setLastActiveTime(new Date());
			account.setLastActiveIp(ip);
			return account;
		}
		return null;
	}

	public AfAccount register(JUser jUser, String ip) {
		String accountId = JUtility.strToMD5(jUser.getEmail());
		if(getAccount(accountId) != null){
			return null;
		}
		AfAccount account = new AfAccount(jUser.getEmail(), jUser.getUsername(), jUser.getPassword());
		account.setLastActiveIp(ip);
		account = accountDao.saveAccount(account);
		CacheManager.getInstance().putAccountCache(accountId, account);
		return account;
	}

	public AfAccount getAccount(String accountId) {
		if(CacheManager.getInstance().getAccountCache(accountId)==null){
			AfAccount account = accountDao.getAccount(accountId);
			CacheManager.getInstance().putAccountCache(accountId, account);
		}
		return CacheManager.getInstance().getAccountCache(accountId);
	}
	

	public boolean loginByLoginCookie(String ip, HttpServletResponse response) {
		String loginCookie = (String) UrlUtils.request().getSession().getAttribute("loginCookie");
		if(loginCookie == null){
			loginCookie = CookieUtils.getCookieValue("Af_loginCookie");
		}
		if(loginCookie != null){
			String accountId = CacheManager.getInstance().getAccountLoginCookieCache(loginCookie);
			if(accountId != null){
				AfAccount account = CacheManager.getInstance().getAccountCache(accountId);
				if(account != null){
					if(ip.equals(account.getLastActiveIp()) && (new Date().getTime() - account.getLastActiveTime().getTime()) < 3600000){
						account.setLastActiveTime(new Date());
						String accountIdCookie = CookieUtils.getCookieValue("Af_accountId");
						String usernameCookie = CookieUtils.getCookieValue("Af_username");
						if(accountIdCookie == null || !accountIdCookie.equals(account.getAccountId()) || usernameCookie== null || !usernameCookie.equals(account.getUsername())){
							CookieUtils.makeLoginCookie(account, response);
						}
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public boolean checkAccountPassword(String accountId,String password){
		accountId = JUtility.strToMD5(accountId);
		password = JUtility.strToMD5(password);
		AfAccount account = getAccount(accountId);
		if(account != null && account.getPassword() != null && account.getPassword().equals(password)){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean isExistAccount(String accountId){
		return accountDao.getAccount(accountId)!=null;
	}

	public void updatePassword(String accountId, String password) {
		getAccount(accountId).setPassword(JUtility.strToMD5(password));
		accountDao.updateAccount(getAccount(accountId));
	}
}
