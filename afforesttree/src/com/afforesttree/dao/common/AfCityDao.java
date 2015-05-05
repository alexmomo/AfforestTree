package com.afforesttree.dao.common;

import java.util.List;

import com.afforesttree.domain.common.AfCity;

public interface AfCityDao {
	
	public AfCity getCity(String cityId);
	public AfCity saveCity(AfCity city);
	public List<AfCity> getAllCityList();
}
