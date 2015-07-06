package com.afforesttree.dao.impl.ecom;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.afforesttree.dao.ecom.AfOasisTypeDao;
import com.afforesttree.domain.ecom.AfOasisType;
import com.afforesttree.framework.hibernate.BaseHibernateDaoSupport;


@Repository("oasisTypeDao")
public class AfOasisTypeDaoImpl  extends BaseHibernateDaoSupport implements AfOasisTypeDao{
	public void deleteOasisType(int id) {
		try {
			String queryString = "delete from AfOasisType where id = "+ id;
			Query queryObject = getSession().createQuery(queryString);
			queryObject.executeUpdate();
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public List<AfOasisType> getAllOasisTypeList() {
		String sql = " from AfOasisType where 1=1";
		Query query = getSession().createQuery(sql);
		List list = query.list();
		return list;
	}

	public AfOasisType getOasisType(int id) {
		List list = null;
		String sql = " from AfOasisType where id=:id";
		Query query = getSession().createQuery(sql);
		query.setInteger("id", id);
		list = query.list();
		if(list != null && list.size() > 0)
		{
			return (AfOasisType)list.get(0);
		}
		return null;
	}

	public AfOasisType saveOasisType(AfOasisType oasisType) {
		try {
			getSession().save(oasisType);
			return oasisType;
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void updateOasisType(AfOasisType oasisType) {
		try {
			getSession().update(oasisType);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public AfOasisType getOasisType(String oasisTypeId) {
		List list = null;
		String sql = " from AfOasisType where oasisTypeId=:oasisTypeId";
		Query query = getSession().createQuery(sql);
		query.setString("oasisTypeId", oasisTypeId);
		list = query.list();
		if(list != null && list.size() > 0)
		{
			return (AfOasisType)list.get(0);
		}
		return null;
	}
}
