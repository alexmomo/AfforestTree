package com.afforesttree.service.impl.common;


import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.afforesttree.dao.common.AfCityDao;
import com.afforesttree.domain.common.AfCity;
import com.afforesttree.service.common.AfCityService;

@Service("cityService")
public class AfCityServiceImpl implements AfCityService {
	@Resource
	private AfCityDao cityDao;
}
