package com.afforesttree.dao.ecom;

import com.afforesttree.domain.ecom.AfAccountApply;

public interface AfAccountApplyDao {
	public AfAccountApply saveAccountApply(AfAccountApply accountApply);
	public void updateAccountApply(AfAccountApply accountApply);
	public void deleteAccountApply(int id);
}
