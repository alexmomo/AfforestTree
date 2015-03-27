package com.afforesttree.dao.impl.ecom;


import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.afforesttree.dao.ecom.AfAccountMissionDao;
import com.afforesttree.domain.ecom.AfAccountMission;
import com.afforesttree.framework.hibernate.BaseHibernateDaoSupport;


@Repository("accountMissionDao")
public class AfAccountMissionDaoImpl  extends BaseHibernateDaoSupport implements AfAccountMissionDao{
	public void deleteAccountMission(int id) {
		try {
			String queryString = "delete from AfAccountMission where id = " + id;
			Query queryObject = getSession().createQuery(queryString);
			queryObject.executeUpdate();
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public AfAccountMission saveAccountMission(AfAccountMission accountMission) {
		try {
			getSession().save(accountMission);
			return accountMission;
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void updateAccountMission(AfAccountMission accountMission) {
		try {
			getSession().update(accountMission);
		} catch (RuntimeException re) {
			throw re;
		}
	}
}
