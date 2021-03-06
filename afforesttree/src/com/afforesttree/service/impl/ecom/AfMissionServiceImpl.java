package com.afforesttree.service.impl.ecom;



import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.afforesttree.dao.common.AfAccountDao;
import com.afforesttree.dao.ecom.AfAccountApplyDao;
import com.afforesttree.dao.ecom.AfAccountMissionDao;
import com.afforesttree.dao.ecom.AfApplyDao;
import com.afforesttree.dao.ecom.AfMissionApplyDao;
import com.afforesttree.dao.ecom.AfMissionDao;
import com.afforesttree.domain.ecom.AfAccountMission;
import com.afforesttree.domain.ecom.AfMission;
import com.afforesttree.service.ecom.AfMissionService;

@Service("missionService")
public class AfMissionServiceImpl implements AfMissionService {
	@Resource
	private AfAccountDao accountDao;
	
	@Resource
	private AfMissionDao missionDao;
	
	@Resource
	private AfAccountMissionDao accountMissionDao;
	
	@Resource
	private AfApplyDao applyDao;
	
	@Resource
	private AfAccountApplyDao accountApplyDao;
	
	@Resource
	private AfMissionApplyDao missionApplyDao;

	public void applyMission(String accountId, int missionId, String describe) {
		// TODO Auto-generated method stub
		
	}

	public void issueMission(String accountId, String title, int type,
			int needCount, String endDate, String subId, String content, String files) {
		Date endTime = new Date();
		AfMission mission = new AfMission(accountId, title, type, needCount, endTime, subId, content, files);
		missionDao.saveMission(mission);
		AfAccountMission accountMission = new AfAccountMission(accountId, mission.getId());
		accountMissionDao.saveAccountMission(accountMission);
	}
}
