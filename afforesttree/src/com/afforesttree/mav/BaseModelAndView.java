package com.afforesttree.mav;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.afforesttree.config.AppInitConstants;



public class BaseModelAndView extends ModelAndView {
	
	
	Integer pageWidth = 960;	
	String metaTitle;
	String metaKeywords;
	String metaDescription;
	@SuppressWarnings("unchecked")
	List jsList;
	@SuppressWarnings("unchecked")
	List cssList;
	boolean checkMobileRedirect = false;
	public boolean isCheckMobileRedirect() {
		return checkMobileRedirect;
	}
	public void setCheckMobileRedirect(boolean checkMobileRedirect) {
		this.checkMobileRedirect = checkMobileRedirect;
		this.addObject("checkMobileRedirect", checkMobileRedirect);
	}
	@SuppressWarnings("unchecked")
	public List getCssList() {
		if(this.cssList == null)
		{
			cssList = new ArrayList<String>();
//			cssList.add(AppInitConstants.getStyleFileName());
			this.setCssList(cssList);
		}
		return cssList;
	}
	@SuppressWarnings("unchecked")
	public void setCssList(List cssList) {
		this.cssList = cssList;
		this.addObject("cssList", cssList);
	}
	@SuppressWarnings("unchecked")
	public List getJsList() {
		if(this.jsList == null)
		{
			jsList = new ArrayList<String>();
			jsList.add(AppInitConstants.getPropertiesValue("jqueryCoreandUIJS"));
			jsList.add(AppInitConstants.getPropertiesValue("initJS"));
			jsList.add(AppInitConstants.getPropertiesValue("jqueryTools"));
			this.setJsList(jsList);
		}		
		return jsList;
	}
	@SuppressWarnings("unchecked")
	public void setJsList(List jsList) {
		this.jsList = jsList;
		this.addObject("jsList", jsList);
	}
	public String getMetaTitle() {
		if(metaTitle == null)
		{
			this.setMetaTitle(AppInitConstants.getI18nValue("website_name"));
		}
		return metaTitle;
	}
	public void setMetaTitle(String metaTitle) {
		this.metaTitle = metaTitle;
		this.addObject("title", metaTitle);
	}
	public String getMetaKeywords() {
		if(metaKeywords == null)
		{
			this.setMetaKeywords(AppInitConstants.getI18nValue("metaKeywords"));
		}
		return metaKeywords;
	}
	public void setMetaKeywords(String metaKeywords) {
		this.metaKeywords = metaKeywords;
		this.addObject("keywords", metaKeywords);
	}
	public String getMetaDescription() {
		if(metaDescription == null)
		{
			this.setMetaDescription(AppInitConstants.getI18nValue("website_name"));
		}
		return metaDescription;
	}
	public void setMetaDescription(String metaDescription) {
		this.metaDescription = metaDescription;
		this.addObject("description", metaDescription);
	}
	
	public Integer getPageWidth() {
		return pageWidth;
	}
	public void setPageWidth(Integer pageWidth) {
		this.pageWidth = pageWidth;
		this.addObject("pageWidth", pageWidth);
	}

	public BaseModelAndView(String name){
		super(name); 
		baseData();
		Map<Object,Object> map = this.request().getParameterMap();
		Set keSet=map.entrySet();
		Map<String, String> requestMap = new HashMap<String, String>();		
		for(Iterator itr=keSet.iterator();itr.hasNext();){
			Map.Entry me = (Map.Entry)itr.next();
			Object ok = me.getKey(); 
		    Object ov = me.getValue(); 
		    requestMap.put(ok.toString(), ov.toString());
		   
	    }
		this.addObject("reqestParametersMap", requestMap);
	}
	
	public void baseData()
	{
		this.addObject("ico", AppInitConstants.ico());
		this.addObject("cssList", this.getCssList());
		this.addObject("version", AppInitConstants.getJsVersion());	
		this.addObject("charset", AppInitConstants.getEncoding());
		this.addObject("domain", AppInitConstants.domain());
		this.addObject("secureDomain", AppInitConstants.secureDomain());
		this.addObject("controlDomain", AppInitConstants.secureDomain() + this.request().getContextPath());
		this.addObject("proxyDomain", AppInitConstants.proxyDomain());
		this.addObject("language", AppInitConstants.getLanguage());
		this.addObject("websiteFilterKey", AppInitConstants.website_filter_key());
		this.addObject("jsList", this.getJsList());
		this.addObject("pageWidth", this.getPageWidth());
		this.addObject("basePath", this.request().getContextPath()+"/");
		this.getMetaTitle();
		this.getMetaKeywords();
		this.getMetaDescription();
	}
	
	public HttpServletRequest request()
	{
		return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest(); 
	}
	
	
	
}
