package com.afforesttree.controller.common;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.afforesttree.controller.BaseController;
import com.afforesttree.service.common.AfAccountService;
import com.afforesttree.util.JUtility;


@Controller
public class AjaxController extends BaseController{
	@Resource
	private AfAccountService accountService;	
	
	@RequestMapping("ajax.do")
	public ModelAndView ajaxRequest(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException{
		try {
			PrintWriter out = response.getWriter();
			JSONArray json = new JSONArray();
			/*
			 * method start
			 */
			String method = getParameter(request, "method");
			//check accountId exist
			if(method.equals("emailValidateExist")){
				String email = getParameter(request, "email");
				json.add(accountService.isExistEmail(email));
			}else if(method.equals("usernameValidateExist")){
				String username = getParameter(request, "username");
				json.add(accountService.isExistUsername(username));
			}
			/*
			 * method end
			 */
//			response.getWriter().write(json.toString());
			out.print(json.toString());
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return null;
	}
}
