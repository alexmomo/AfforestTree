package com.afforesttree.util;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class UrlUtils {
	
	public static String redirectUrl(String name, Map<String,String> codeMap)
	{
		String url = null;
		StringBuilder stringBuilder=new StringBuilder(request().getContextPath()+"/"+name+".shtml");
		if(codeMap!= null && !codeMap.isEmpty()){
			stringBuilder.append("?");
			for(String o:codeMap.keySet()){
				stringBuilder.append(o);
				stringBuilder.append("=");
				stringBuilder.append(codeMap.get(o));
				stringBuilder.append("&");
			} 
		}
		url = stringBuilder.toString();
		if(codeMap!= null && !codeMap.isEmpty()){
			url = url.substring(0, url.length() - 1);
		}
		return url;
	}
	
	public static HttpServletRequest request()
	{
		return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest(); 
	}
}
