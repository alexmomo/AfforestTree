package com.afforesttree.bean.ecom;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.afforesttree.bean.common.JObject;

@XmlRootElement(name="accountOasisInfo")
@XmlAccessorType(XmlAccessType.FIELD)
public class JAccountOasisInfo extends JObject {
	@XmlElementWrapper(name = "oasisInfos")  
	@XmlElement(name="oasisInfo")
	private List<JOasisInfo> oasisInfos;

	public List<JOasisInfo> getOasisInfos() {
		return oasisInfos;
	}

	public void setOasisInfos(List<JOasisInfo> oasisInfos) {
		this.oasisInfos = oasisInfos;
	}
}
