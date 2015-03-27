package com.afforesttree.dao.impl.ecom;


import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.afforesttree.dao.ecom.AfAccountApplyDao;
import com.afforesttree.domain.ecom.AfAccountApply;
import com.afforesttree.framework.hibernate.BaseHibernateDaoSupport;


@Repository("accountApplyDao")
public class AfAccountApplyDaoImpl  extends BaseHibernateDaoSupport implements AfAccountApplyDao{
	public void deleteAccountApply(int id) {
		try {
			String queryString = "delete from AfAccountApply where id = " + id;
			Query queryObject = getSession().createQuery(queryString);
			queryObject.executeUpdate();
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public AfAccountApply saveAccountApply(AfAccountApply accountApply) {
		try {
			getSession().save(accountApply);
			return accountApply;
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void updateAccountApply(AfAccountApply accountApply) {
		try {
			getSession().update(accountApply);
		} catch (RuntimeException re) {
			throw re;
		}
	}
}
