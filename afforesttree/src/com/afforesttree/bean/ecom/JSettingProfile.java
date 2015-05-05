package com.afforesttree.bean.ecom;

import com.afforesttree.domain.common.AfAccount;
import com.afforesttree.util.StringUtils;

public class JSettingProfile {
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public AfAccount updateAccount(AfAccount account){
		if(StringUtils.checkEmpty(this.username)){
			account.setUsername(username);
		}
		return account;
	}
	
	public JSettingProfile(){}
	
	public JSettingProfile(AfAccount account){
		this.username = account.getUsername();
	}
}
