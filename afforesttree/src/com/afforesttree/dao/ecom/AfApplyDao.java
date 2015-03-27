package com.afforesttree.dao.ecom;

import java.util.List;

import com.afforesttree.domain.ecom.AfApply;

public interface AfApplyDao {
	public AfApply getApply(int id);
	public AfApply saveApply(AfApply apply);
	public void updateApply(AfApply apply);
	public void deleteApply(int id);
	public List<AfApply> getApplyList(String missionId, String accountId, int page);
}
