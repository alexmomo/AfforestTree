package com.afforesttree.service.common;

import javax.servlet.http.HttpServletResponse;

import com.afforesttree.bean.ecom.JUser;
import com.afforesttree.domain.common.AfAccount;


public interface AfAccountService {
	
	public AfAccount login(JUser jUser, String ip);
	
	public AfAccount register(JUser jUser, String ip);
	
	public AfAccount getAccount(String accountId);
	
	public boolean loginByLoginCookie(String ip, HttpServletResponse response);
	
	public boolean checkAccountPassword(String accountId,String password);
	
	public boolean isExistAccount(String accountId);
	
	public void updatePassword(String accountId, String password);
	
	public boolean isExistEmail(String email);
	
	public boolean isExistUsername(String username);
}
