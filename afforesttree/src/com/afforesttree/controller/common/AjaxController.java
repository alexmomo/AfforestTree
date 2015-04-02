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
	public ModelAndView goSearch(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException{
		try {
			PrintWriter out = response.getWriter();
			JSONArray json = new JSONArray();
			/*
			 * method start
			 */
			String method = getParameter(request, "method");
			//检测用户ID是否已存在
			if(method.equals("validateAccountIdExist")){
				String accountId = getParameter(request, "accountId");
				json.add(accountService.isExistAccount(JUtility.strToMD5(accountId)));
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
