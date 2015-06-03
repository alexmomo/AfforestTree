package com.afforesttree.bean.ecom;

import java.util.List;

import com.afforesttree.domain.ecom.AfOasisType;

public class JSettingOasis {
	private List<AfOasisType> oasisTypes;
	
	private JAccountOasisInfo accountOasisInfo;

	public List<AfOasisType> getOasisTypes() {
		return oasisTypes;
	}

	public void setOasisTypes(List<AfOasisType> oasisTypes) {
		this.oasisTypes = oasisTypes;
	}

	public JAccountOasisInfo getAccountOasisInfo() {
		return accountOasisInfo;
	}

	public void setAccountOasisInfo(JAccountOasisInfo accountOasisInfo) {
		this.accountOasisInfo = accountOasisInfo;
	}
	
	public JSettingOasis(){
		
	}
	
	public JSettingOasis(List<AfOasisType> oasisTypes, String accountOasisInfo){
		this.oasisTypes = oasisTypes;
		JAccountOasisInfo jAccountOasisInfo = new JAccountOasisInfo();
		jAccountOasisInfo = (JAccountOasisInfo)jAccountOasisInfo.xmlToObject(accountOasisInfo);
		this.accountOasisInfo = jAccountOasisInfo;
		for(JOasisInfo oasisInfo : getAccountOasisInfo().getOasisInfos()){
			for(AfOasisType oasisType : oasisTypes){
				if(oasisInfo.getOasisTypeId() == oasisType.getId()){
					oasisInfo.setOasisType(oasisType);
					break;
				}
			}
		}
	}
}
