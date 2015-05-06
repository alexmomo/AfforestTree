package com.afforesttree.controller.system;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.afforesttree.service.common.AfCityService;
import com.afforesttree.service.system.AppInitService;


@Controller
public class AppInitController {
	@Resource
	private AppInitService appInitService;
	
	@Resource
	private AfCityService cityService;
	
	@PostConstruct
	protected void initialize() {
		appInitService.putBasePropertiesList();
		cityService.getCityCache();
	}
}
