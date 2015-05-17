package com.afforesttree.dao.impl.ecom;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.afforesttree.dao.ecom.AfOasisDao;
import com.afforesttree.dao.ecom.AfOasisTypeDao;
import com.afforesttree.domain.ecom.AfOasis;
import com.afforesttree.domain.ecom.AfOasisType;
import com.afforesttree.framework.hibernate.BaseHibernateDaoSupport;


@Repository("oasisDao")
public class AfOasisDaoImpl  extends BaseHibernateDaoSupport implements AfOasisDao{
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

	public void deleteOasis(int id) {
		try {
			String queryString = "delete from AfOasis where id = "+ id;
			Query queryObject = getSession().createQuery(queryString);
			queryObject.executeUpdate();
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public List<AfOasis> getAllOasisList() {
		String sql = " from AfOasis where 1=1";
		Query query = getSession().createQuery(sql);
		List list = query.list();
		return list;
	}

	public AfOasis getOasis(int id) {
		List list = null;
		String sql = " from AfOasis where id=:id";
		Query query = getSession().createQuery(sql);
		query.setInteger("id", id);
		list = query.list();
		if(list != null && list.size() > 0)
		{
			return (AfOasis)list.get(0);
		}
		return null;
	}

	public List<AfOasis> getOasisListByType(int oasisType) {
		List list = null;
		String sql = " from AfOasis where oasisType=:oasisType";
		Query query = getSession().createQuery(sql);
		query.setInteger("oasisType", oasisType);
		list = query.list();
		return list;
	}

	public AfOasis saveOasis(AfOasis oasis) {
		try {
			getSession().save(oasis);
			return oasis;
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void updateOasis(AfOasis oasis) {
		try {
			getSession().update(oasis);
		} catch (RuntimeException re) {
			throw re;
		}
	}
}
