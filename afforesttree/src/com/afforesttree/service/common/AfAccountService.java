package com.afforesttree.service.common;

import javax.servlet.http.HttpServletResponse;

import com.afforesttree.domain.common.AfAccount;


public interface AfAccountService {
	
	public AfAccount login(String accountId, String password, String ip);
	
	public AfAccount register(String accountId, int registerType, String password, String ip);
	
	public AfAccount getAccount(String accountId);
	
	public boolean loginByLoginCookie(String ip, HttpServletResponse response);
	
	public boolean checkAccountPassword(String accountId,String password);
	
	public boolean isExistAccount(String accountId);
	
	public void updatePassword(String accountId, String password);
}
