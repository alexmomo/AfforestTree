package com.afforesttree.controller;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import com.afforesttree.mav.BaseModelAndView;
import com.afforesttree.util.CookieUtils;
import com.afforesttree.util.JUtility;
import com.afforesttree.util.StringUtils;
import com.afforesttree.util.UrlUtils;


public class BaseController {
	private BaseModelAndView mv;
	
	public BaseModelAndView getMv() {
		return mv;
	}

	public void setMv(BaseModelAndView mv) {
		this.mv = mv;
	}

	public BaseModelAndView baseModelAndView(String name)
	{
		mv = new BaseModelAndView(name);
		this.setMv(mv);
		this.responseTourSiteTop();
		this.handleError();
		return mv;
	}
	
	public String getParameter(HttpServletRequest request, String parameter)
	{
		return request.getParameter(parameter)==null ? "": request.getParameter(parameter);
	}
	
	public void handleError(){
		String errorCode = request().getParameter("ec");
		if(StringUtils.checkEmpty(errorCode)){
			if(errorCode.equals("10001")){
				this.mv.addObject("errorMsg", "µÇÂ¼³¬Ê±£¬ÇëÖØÐÂµÇÂ¼");
			}
		}
	}
	
	public void responseTourSiteTop(){
	}
	
	public HttpServletRequest request(){
		return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
	}
	
	public String getClientHostIp(){
		return JUtility.getRemoteHost(request());
	}
	
	public BaseModelAndView login(HttpServletResponse response,Map<String,String> codeMap){
		CookieUtils.removeLoginCookie(response);
		try {
			response.sendRedirect(UrlUtils.redirectUrl("login",codeMap));
		} catch (IOException e) {
			e.printStackTrace();
		}
		BaseModelAndView mv = null;
		mv = this.baseModelAndView("login");
		mv.setMetaTitle("Login");
		return mv;
	}
	
	public Map<String,String> makeCodeMap(int type){
		Map<String,String> codeMap = new HashMap<String, String>();
		if(type == 1){
			codeMap.put("ec", "10001");
		}else{
			
		}
		return codeMap;
	}
}
	
