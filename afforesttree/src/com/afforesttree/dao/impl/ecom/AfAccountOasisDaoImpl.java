package com.afforesttree.dao.impl.ecom;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.afforesttree.dao.ecom.AfAccountOasisDao;
import com.afforesttree.domain.ecom.AfAccountOasis;
import com.afforesttree.framework.hibernate.BaseHibernateDaoSupport;


@Repository("accountOasisDao")
public class AfAccountOasisDaoImpl  extends BaseHibernateDaoSupport implements AfAccountOasisDao{
	public AfAccountOasis getAccountOasisByAccountId(String accountId) {
		List list = null;
		String sql = " from AfAccountOasis where accountId=:accountId";
		Query query = getSession().createQuery(sql);
		query.setString("accountId", accountId);
		list = query.list();
		if(list != null && list.size() > 0)
		{
			return (AfAccountOasis)list.get(0);
		}
		return null;
	}

	public AfAccountOasis saveAccountOasis(AfAccountOasis accountOasis) {
		try {
			getSession().save(accountOasis);
			return accountOasis;
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void updateAccountOasis(AfAccountOasis accountOasis) {
		try {
			getSession().update(accountOasis);
		} catch (RuntimeException re) {
			throw re;
		}
	}
}
