package com.afforesttree.service.impl.ecom;



import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.afforesttree.dao.common.AfAccountDao;
import com.afforesttree.dao.ecom.AfAccountApplyDao;
import com.afforesttree.dao.ecom.AfAccountMissionDao;
import com.afforesttree.dao.ecom.AfApplyDao;
import com.afforesttree.dao.ecom.AfMissionApplyDao;
import com.afforesttree.dao.ecom.AfMissionDao;
import com.afforesttree.domain.ecom.AfAccountMission;
import com.afforesttree.domain.ecom.AfAccountOasis;
import com.afforesttree.domain.ecom.AfMission;
import com.afforesttree.domain.ecom.AfOasis;
import com.afforesttree.domain.ecom.AfOasisType;
import com.afforesttree.service.ecom.AfMissionService;
import com.afforesttree.service.ecom.AfOasisService;

@Service("oasisService")
public class AfOasisServiceImpl implements AfOasisService {
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

	public AfAccountOasis createAccountOasis(AfAccountOasis accountOasis) {
		// TODO Auto-generated method stub
		return null;
	}

	public AfAccountOasis getAccountOasisById(String accountId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<AfOasis> getAllOasisList() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<AfOasisType> getAllOasisTypeList() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<AfOasis> getOasisListByType(int oasisType) {
		// TODO Auto-generated method stub
		return null;
	}

	public AfAccountOasis updateAccountOasis(AfAccountOasis accountOasis) {
		// TODO Auto-generated method stub
		return null;
	}
}
