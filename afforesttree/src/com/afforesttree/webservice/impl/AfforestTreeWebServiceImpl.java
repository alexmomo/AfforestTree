package com.afforesttree.webservice.impl;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.afforesttree.webservice.AfforestTreeWebService;


@WebService(endpointInterface="com.afforesttree.webservice.AfforestTreeWebService",targetNamespace="afWS")
public class AfforestTreeWebServiceImpl implements AfforestTreeWebService {
	
//	@SuppressWarnings("unchecked")
//	@WebMethod(action="ProductUpdateByPid",operationName="ProductUpdateByPid")
//	public String productUpdateByPid(String pid) {
//		try{
//			ConfigParam.getUpdateTaskList().add(pid);
//		}catch(Exception e){
//			return "failed";
//		}
//		return "success";
//	}
}
