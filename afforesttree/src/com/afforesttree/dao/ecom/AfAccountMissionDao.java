package com.afforesttree.dao.ecom;

import com.afforesttree.domain.ecom.AfAccountMission;

public interface AfAccountMissionDao {
	public AfAccountMission saveAccountMission(AfAccountMission accountMission);
	public void updateAccountMission(AfAccountMission accountMission);
	public void deleteAccountMission(int id);
}
