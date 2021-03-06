package com.afforesttree.dao.impl.ecom;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.afforesttree.dao.ecom.AfApplyDao;
import com.afforesttree.domain.ecom.AfApply;
import com.afforesttree.framework.hibernate.BaseHibernateDaoSupport;
import com.afforesttree.util.PageUtils;
import com.afforesttree.util.StringUtils;


@Repository("applyDao")
public class AfApplyDaoImpl  extends BaseHibernateDaoSupport implements AfApplyDao{
	public void deleteApply(int id) {
		try {
			String queryString = "delete from AfApply where id = "+id;
			Query queryObject = getSession().createQuery(queryString);
			queryObject.executeUpdate();
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public AfApply getApply(int id) {
		List list = null;
		String sql = " from AfApply where id=:id";
		Query query = getSession().createQuery(sql);
		query.setInteger("id", id);
		list = query.list();
		if(list != null && list.size() > 0)
		{
			return (AfApply)list.get(0);
		}
		return null;
	}

	public List<AfApply> getApplyList(String missionId, String accountId,
			int page) {
		List list = null;
		StringBuffer sqlBuffer = new StringBuffer(" from AfApply where 1 = 1");
		if(StringUtils.checkEmpty(accountId)){
			sqlBuffer.append(" and accountId=:accountId");
		}
		if(StringUtils.checkEmpty(missionId)){
			sqlBuffer.append(" and missionId=:missionId");
		}
		sqlBuffer.append(" order by createTime");
		Query query = getSession().createQuery(sqlBuffer.toString());
		if(StringUtils.checkEmpty(accountId)){
			query.setString("accountId", accountId);
		}
		if(StringUtils.checkEmpty(missionId)){
			query.setString("missionId", missionId);
		}
		list = query.list();
		if(list != null && list.size() > 0)
		{
			return (List<AfApply>)PageUtils.getListPage(list, page);
		}
		return null;
	}

	public AfApply saveApply(AfApply apply) {
		try {
			getSession().save(apply);
			return apply;
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void updateApply(AfApply apply) {
		try {
			getSession().update(apply);
		} catch (RuntimeException re) {
			throw re;
		}
	}
}
