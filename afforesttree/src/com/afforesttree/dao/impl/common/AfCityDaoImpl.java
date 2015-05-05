package com.afforesttree.dao.impl.common;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.afforesttree.dao.common.AfCityDao;
import com.afforesttree.domain.common.AfCity;
import com.afforesttree.framework.hibernate.BaseHibernateDaoSupport;


@Repository("cityDao")
public class AfCityDaoImpl  extends BaseHibernateDaoSupport implements AfCityDao{

	public AfCity getCity(String cityId) {
		List list = null;
		String sql = " from AfCity where id=:cityId";
		Query query = getSession().createQuery(sql);
		query.setString("cityId", cityId);
		list = query.list();
		if(list != null && list.size() > 0)
		{
			return (AfCity)list.get(0);
		}
		return null;
	}

	public AfCity saveCity(AfCity city) {
		try {
			getSession().save(city);
			return city;
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public List<AfCity> getAllCityList() {
		String sql = " from AfCity where 1=1";
		Query query = getSession().createQuery(sql);
		List list = query.list();
		return list;
	}
	
}
