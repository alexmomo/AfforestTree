package com.afforesttree.controller.ecom;



import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.afforesttree.bean.ecom.JSettingProfile;
import com.afforesttree.controller.BaseController;
import com.afforesttree.domain.common.AfAccount;
import com.afforesttree.framework.annotation.LoginCookieValid;
import com.afforesttree.mav.BaseModelAndView;
import com.afforesttree.service.common.AfAccountService;
import com.afforesttree.util.CookieUtils;
import com.afforesttree.util.UrlUtils;


@Controller
public class AfSettingController extends BaseController {
	@Resource
	private AfAccountService accountService;
	
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
//		user.setUserId(new String(user.getUserId().getBytes("ISO-8859-1"),0,user.getUserId().getBytes("ISO-8859-1").length,"GBK"));
		System.out.println(new String(jSettingProfile.getRealName().getBytes("ISO-8859-1"),"UTF-8"));
		AfAccount account = accountService.settingProfile(jSettingProfile);
		CookieUtils.makeLoginCookie(account, response);
		response.sendRedirect(UrlUtils.redirectUrl("setting/profile.shtml"));
		return null;
	}
}
