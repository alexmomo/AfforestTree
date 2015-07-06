package com.afforesttree.dao.ecom;

import java.util.List;

import com.afforesttree.domain.ecom.AfOasisType;

public interface AfOasisTypeDao {
	public AfOasisType getOasisType(int id);
	public AfOasisType getOasisType(String oasisTypeId);
	public AfOasisType saveOasisType(AfOasisType oasisType);
	public void updateOasisType(AfOasisType oasisType);
	public void deleteOasisType(int id);
	public List<AfOasisType> getAllOasisTypeList();
}
