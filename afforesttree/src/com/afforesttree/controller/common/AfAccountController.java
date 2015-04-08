package com.afforesttree.controller.common;



import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.afforesttree.controller.BaseController;
import com.afforesttree.domain.common.AfAccount;
import com.afforesttree.domain.common.AfForgotPassword;
import com.afforesttree.framework.token.Token;
import com.afforesttree.framework.token.TokenValid;
import com.afforesttree.mav.BaseModelAndView;
import com.afforesttree.service.common.AfAccountService;
import com.afforesttree.service.common.AfForgotPasswordService;
import com.afforesttree.util.CookieUtils;
import com.afforesttree.util.JUtility;
import com.afforesttree.util.StringUtils;


@Controller
public class AfAccountController extends BaseController {
	@Resource
	private AfAccountService accountService;
	
	@Resource
	private AfForgotPasswordService forgotPasswordService;
	
	@Token
	@RequestMapping("login.shtml")
	public ModelAndView loginPageRequest(HttpServletRequest request,HttpServletResponse response) throws Exception {
		BaseModelAndView mv = baseModelAndView("login");
		mv.setMetaTitle("login");
		return mv;
	}
	
	@TokenValid
	@RequestMapping("login.do")
	public ModelAndView loginRequest(HttpServletRequest request,HttpServletResponse response,AfAccount afAccount) throws Exception {
		BaseModelAndView mv = null;
		if(StringUtils.checkEmpty(afAccount.getAccountId()) && StringUtils.checkPassword(afAccount.getPassword())){
			AfAccount account = accountService.login(afAccount.getAccountId(), afAccount.getPassword(), getClientHostIp());
			if(account != null){
				CookieUtils.makeLoginCookie(account, response);
				response.sendRedirect("index.shtml");
				mv = baseModelAndView("index");
				mv.setMetaTitle("AfforestTree");
				return mv;
			}
		}
		return loginPageRequest(request, response);
	}
	
	@RequestMapping("logout.do")
	public ModelAndView logoutRequest(HttpServletRequest request,HttpServletResponse response,AfAccount afAccount) throws Exception {
		return login(response, null);
	}
	
	@Token
	@RequestMapping("register.shtml")
	public ModelAndView registerPageRequest(HttpServletRequest request,HttpServletResponse response) throws Exception {
		BaseModelAndView mv = baseModelAndView("register");
		mv.setMetaTitle("register");
		return mv;
	}
	
	@TokenValid
	@RequestMapping("register.do")
	public ModelAndView registerRequest(HttpServletRequest request,HttpServletResponse response,AfAccount afAccount) throws Exception {
		BaseModelAndView mv = null;
		if(StringUtils.checkPassword(afAccount.getPassword())){
			int registerType = 0;
			if(StringUtils.checkEmail(afAccount.getAccountId())){
				registerType = 1;
			}else if(StringUtils.checkMobile(afAccount.getAccountId())){
				registerType = 2;
			}
			if(registerType != 0){
				String ip = getClientHostIp();
				AfAccount account =  accountService.register(afAccount.getAccountId(), registerType, afAccount.getPassword(), ip);
				if(account != null){
					mv = (BaseModelAndView) loginRequest(request, response, afAccount);
				}
			}
		}
		if(mv == null){
			mv = (BaseModelAndView) registerPageRequest(request, response);
		}
		return mv;
	}
	
	@RequestMapping("forgot_password.shtml")
	public ModelAndView forgotPasswordPageRequest(HttpServletRequest request,HttpServletResponse response) throws Exception {
		BaseModelAndView mv = baseModelAndView("forgot_password");
		mv.setMetaTitle("forgot_password");
		return mv;
	}
	
	@RequestMapping("forgot_password.do")
	public ModelAndView forgotPasswordRequest(HttpServletRequest request,HttpServletResponse response,AfForgotPassword forgotPassword) throws Exception {
		BaseModelAndView mv = null;
		if((StringUtils.checkEmail(forgotPassword.getAccountId()) || StringUtils.checkMobile(forgotPassword.getAccountId())) && StringUtils.checkEmpty(forgotPassword.getContent())){
			if(!StringUtils.checkEmpty(forgotPassword.getNewAccountId())){
				forgotPassword.setNewAccountId(forgotPassword.getAccountId());
			}
			if(StringUtils.checkEmail(forgotPassword.getNewAccountId()) || StringUtils.checkMobile(forgotPassword.getNewAccountId())){
				if(accountService.isExistAccount(JUtility.strToMD5(forgotPassword.getAccountId()))){
					forgotPasswordService.forgotPassword(forgotPassword.getAccountId(), forgotPassword.getNewAccountId(), forgotPassword.getContent());
					mv = baseModelAndView("index");
					mv.setMetaTitle("main");
					return mv;
				}
			}
		}
		return forgotPasswordPageRequest(request, response);
	}
	
	@RequestMapping("update_password.shtml")
	public ModelAndView updatePasswordPageRequest(HttpServletRequest request,HttpServletResponse response) throws Exception {
		BaseModelAndView mv = baseModelAndView("reset_password");
		mv.setMetaTitle("reset_password");
		return mv;
	}
	
	@RequestMapping("update_password.do")
	public ModelAndView updatePasswordRequest(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String accountId = request.getParameter("accountId");
		String old_password = request.getParameter("old_password");
		String password = request.getParameter("password");
		if((StringUtils.checkEmail(accountId) || StringUtils.checkMobile(accountId)) && StringUtils.checkPassword(old_password) && StringUtils.checkPassword(password)){
			if(accountService.checkAccountPassword(accountId, old_password)){
				accountService.updatePassword(accountId, password);
				return loginPageRequest(request, response);
			}
		}
		return updatePasswordPageRequest(request, response);
	}
	
	@RequestMapping("reset_password.do")
	public ModelAndView resetPasswordRequest(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String uuid = request.getParameter("uuid");
		if(StringUtils.isNumber(id) && StringUtils.checkEmpty(uuid)){
			int forgotPasswordId = Integer.valueOf(id);
			if(forgotPasswordService.resetPassword(forgotPasswordId, uuid)){
				return updatePasswordPageRequest(request, response);
			}
		}
		return null;
	}
	
	
}
