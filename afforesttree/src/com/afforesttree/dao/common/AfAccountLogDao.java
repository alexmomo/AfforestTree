package com.afforesttree.dao.common;

import java.util.Date;
import java.util.List;

import com.afforesttree.domain.common.AfAccountLog;

public interface AfAccountLogDao {
	public List<AfAccountLog> getAccountLogList(String accountId, Date startTime, Date endTime, int length);
	
	public AfAccountLog saveAccountLog(String accountId, String actionIp, int type);
}
