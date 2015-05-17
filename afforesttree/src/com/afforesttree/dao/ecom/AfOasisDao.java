package com.afforesttree.dao.ecom;

import java.util.List;

import com.afforesttree.domain.ecom.AfOasis;

public interface AfOasisDao {
	public AfOasis getOasis(int id);
	public AfOasis saveOasis(AfOasis oasis);
	public void updateOasis(AfOasis oasis);
	public void deleteOasis(int id);
	public List<AfOasis> getOasisListByType(int oasisType);
	public List<AfOasis> getAllOasisList();
}
