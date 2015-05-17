package com.afforesttree.dao.ecom;

import com.afforesttree.domain.ecom.AfAccountOasis;

public interface AfAccountOasisDao {
	public AfAccountOasis getAccountOasisByAccountId(String accountId);
	public AfAccountOasis saveAccountOasis(AfAccountOasis accountOasis);
	public void updateAccountOasis(AfAccountOasis accountOasis);
}
