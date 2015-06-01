package com.afforesttree.controller.ecom;



import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.afforesttree.bean.ecom.JSettingProfile;
import com.afforesttree.controller.BaseController;
import com.afforesttree.domain.common.AfAccount;
import com.afforesttree.domain.ecom.AfAccountOasis;
import com.afforesttree.domain.ecom.AfOasisType;
import com.afforesttree.framework.annotation.LoginCookieValid;
import com.afforesttree.mav.BaseModelAndView;
import com.afforesttree.service.common.AfAccountService;
import com.afforesttree.service.ecom.AfOasisService;
import com.afforesttree.util.CookieUtils;
import com.afforesttree.util.UrlUtils;


@Controller
public class AfSettingController extends BaseController {
	@Resource
	private AfAccountService accountService;
	
	@Resource
	private AfOasisService oasisService;
	
	@RequestMapping("setting.shtml")
	public ModelAndView settingPageRequest(HttpServletRequest request,HttpServletResponse response) throws Exception {
		response.sendRedirect(UrlUtils.redirectUrl("setting/profile.shtml"));
		return null;
	}
	
	@LoginCookieValid
	@RequestMapping("setting/profile.shtml")
	public ModelAndView settingProfilePageRequest(HttpServletRequest request,HttpServletResponse response) throws Exception {
		AfAccount account = accountService.getAccount(CookieUtils.getAccountId());
		JSettingProfile jSettingProfile = new JSettingProfile(account);
		BaseModelAndView mv = baseModelAndView("setting/profile");
		mv.setMetaTitle("profile");
		mv.addObject("profile", jSettingProfile);
		return mv;
	}
	
	@LoginCookieValid
	@RequestMapping("setting/profile.do")
	public ModelAndView settingProfileRequest(HttpServletRequest request,HttpServletResponse response,JSettingProfile jSettingProfile) throws Exception {
		AfAccount account = accountService.settingProfile(jSettingProfile);
		CookieUtils.makeLoginCookie(account, response);
		response.sendRedirect(UrlUtils.redirectUrl("setting/profile.shtml"));
		return null;
	}
	
	@LoginCookieValid
	@RequestMapping("setting/myOasis.shtml")
	public ModelAndView settingMyOasisPageRequest(HttpServletRequest request,HttpServletResponse response) throws Exception {
		AfAccountOasis accountOasis = oasisService.getAccountOasisById(CookieUtils.getAccountId());
		AfAccount account = accountService.getAccount(CookieUtils.getAccountId());
		JSettingProfile jSettingProfile = new JSettingProfile(account);
		BaseModelAndView mv = baseModelAndView("setting/my_oasis");
		mv.setMetaTitle("MyOasis");
		mv.addObject("profile", jSettingProfile);
		List<AfOasisType> oasisTypeList = oasisService.getAllOasisTypeList();
		mv.addObject("oasisTypes", oasisTypeList);
		return mv;
	}
}
