package com.afforesttree.controller.common;



import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.afforesttree.controller.BaseController;
import com.afforesttree.mav.BaseModelAndView;
import com.afforesttree.service.common.AfAccountService;


@Controller
public class SystemController extends BaseController {
	@Resource
	private AfAccountService accountService;

	@RequestMapping("index.shtml")
	public ModelAndView indexPageRequest(HttpServletRequest request,HttpServletResponse response) throws Exception {
		BaseModelAndView mv = null;
		if(!accountService.loginByLoginCookie(getClientHostIp(), response)){
//			if(request.getParameter("fr") == null){
//				return login(response, makeCodeMap(1));
//			}else{
//				return login(response, null);
//			}
			response.sendRedirect("index.html");
		}
		mv = baseModelAndView("index");
		mv.setMetaTitle("ÂÌ»¯Ê÷");
		return mv;
	}
	
	@RequestMapping("re_submit.shtml")
	public ModelAndView reSubmitPageRequest(HttpServletRequest request,HttpServletResponse response) throws Exception {
		BaseModelAndView mv = null;
		mv = baseModelAndView("re_submit");
		mv.setMetaTitle("ÂÌ»¯Ê÷");
		return mv;
	}
	
	@RequestMapping("error.shtml")
	public ModelAndView errorPageRequest(HttpServletRequest request,HttpServletResponse response) throws Exception {
		BaseModelAndView mv = null;
		mv = baseModelAndView("error");
		mv.setMetaTitle("ÂÌ»¯Ê÷");
		return mv;
	}
}
