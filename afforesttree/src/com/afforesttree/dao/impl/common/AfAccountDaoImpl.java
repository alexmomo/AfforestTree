package com.afforesttree.dao.impl.common;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.afforesttree.dao.common.AfAccountDao;
import com.afforesttree.domain.common.AfAccount;
import com.afforesttree.framework.hibernate.BaseHibernateDaoSupport;


@Repository("accountDao")
public class AfAccountDaoImpl  extends BaseHibernateDaoSupport implements AfAccountDao{
	
	public AfAccount getAccount(String accountId)
	{
		List list = null;
		String sql = " from AfAccount where accountId=:accountId";
		Query query = getSession().createQuery(sql);
		query.setString("accountId", accountId);
		list = query.list();
		if(list != null && list.size() > 0)
		{
			return (AfAccount)list.get(0);
		}
		return null;
	}

	public AfAccount saveAccount(AfAccount account) {
		try {
			getSession().save(account);
			return account;
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void deleteAccount(String accountId) {
		try {
			String queryString = "delete from AfAccount where accountId = "+accountId;
			Query queryObject = getSession().createQuery(queryString);
			queryObject.executeUpdate();
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void updateAccount(AfAccount account) {
		try {
			getSession().update(account);
		} catch (RuntimeException re) {
			throw re;
		}
	}
}
