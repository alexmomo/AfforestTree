package com.afforesttree.service.ecom;

import java.util.List;

import com.afforesttree.domain.common.AfAccount;
import com.afforesttree.domain.ecom.AfAccountOasis;
import com.afforesttree.domain.ecom.AfOasis;
import com.afforesttree.domain.ecom.AfOasisType;


public interface AfOasisService {
	
	public List<AfOasisType> getAllOasisTypeList();
	
	public List<AfOasis> getAllOasisList();
	
	public List<AfOasis> getOasisListByType(int oasisType);
	
	public AfAccountOasis getAccountOasisById(String accountId);
	
	public AfAccountOasis updateAccountOasis(AfAccountOasis accountOasis);
	
	public AfAccountOasis createAccountOasis(AfAccountOasis accountOasis);
	
	public void focusOasisType(String accountId, String oasisTypeId);
	
	public void unfocusOasisType(String accountId, String oasisTypeId);
}
