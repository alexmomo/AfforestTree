package com.afforesttree.dao.impl.ecom;


import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.afforesttree.dao.ecom.AfMissionApplyDao;
import com.afforesttree.domain.ecom.AfMissionApply;
import com.afforesttree.framework.hibernate.BaseHibernateDaoSupport;


@Repository("missionApplyDao")
public class AfMissionApplyDaoImpl  extends BaseHibernateDaoSupport implements AfMissionApplyDao{
	public void deleteMissionApply(int id) {
		try {
			String queryString = "delete from AfMissionApply where id = " + id;
			Query queryObject = getSession().createQuery(queryString);
			queryObject.executeUpdate();
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public AfMissionApply saveMissionApply(AfMissionApply missionApply) {
		try {
			getSession().save(missionApply);
			return missionApply;
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void updateMissionApply(AfMissionApply missionApply) {
		try {
			getSession().update(missionApply);
		} catch (RuntimeException re) {
			throw re;
		}
	}
}
