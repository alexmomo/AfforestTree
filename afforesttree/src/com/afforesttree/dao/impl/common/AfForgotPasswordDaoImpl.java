package com.afforesttree.dao.impl.common;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.afforesttree.dao.common.AfForgotPasswordDao;
import com.afforesttree.domain.common.AfForgotPassword;
import com.afforesttree.framework.hibernate.BaseHibernateDaoSupport;
import com.afforesttree.util.StringUtils;


@Repository("forgotPasswordDao")
public class AfForgotPasswordDaoImpl  extends BaseHibernateDaoSupport implements AfForgotPasswordDao{

	public void deleteForgotPassword(int id) {
		try {
			String queryString = "delete from AfForgotPassword where id = " + id;
			Query queryObject = getSession().createQuery(queryString);
			queryObject.executeUpdate();
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public AfForgotPassword getForgotPassword(int id) {
		List list = null;
		String sql = " from AfForgotPassword where id=:id";
		Query query = getSession().createQuery(sql);
		query.setInteger("id", id);
		list = query.list();
		if(list != null && list.size() > 0)
		{
			return (AfForgotPassword)list.get(0);
		}
		return null;
	}

	public List<AfForgotPassword> getForgotPasswordList(String accountId,
			int status, Date startTime, Date endTime) {
		List list = null;
		StringBuffer sqlBuffer = new StringBuffer(" from AfForgotPassword where 1=1 ");
		if(StringUtils.checkEmpty(accountId)){
			sqlBuffer.append("and accountId=:accountId");
		}
		if(status != 0){
			sqlBuffer.append("and status=:status");
		}
		if(startTime != null){
			sqlBuffer.append("and createTime>=:startTime");
		}
		if(endTime != null){
			sqlBuffer.append("and createTime<=:endTime");
		}
		String sql = " from AfForgotPassword where accountId=:accountId";
		Query query = getSession().createQuery(sql);
		if(StringUtils.checkEmpty(accountId)){
			query.setString("accountId", accountId);
		}
		if(status != 0){
			query.setInteger("status", status);
		}
		if(startTime != null){
			query.setDate("startTime", startTime);
		}
		if(endTime != null){
			query.setDate("endTime", endTime);
		}
		list = query.list();
		if(list != null && list.size() > 0)
		{
			return (List<AfForgotPassword>)list;
		}
		return null;
	}

	public AfForgotPassword saveForgotPassword(AfForgotPassword forgotPassword) {
		try {
			getSession().save(forgotPassword);
			return forgotPassword;
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void updateForgotPassword(AfForgotPassword forgotPassword) {
		try {
			getSession().update(forgotPassword);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	
}
