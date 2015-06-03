package com.afforesttree.domain.ecom;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.afforesttree.bean.ecom.JAccountOasisInfo;


@Entity
@Table(name="af_account_oasis")
public class AfAccountOasis implements java.io.Serializable{
	@Id
	@GenericGenerator(name = "generator", strategy = "native")
	@GeneratedValue(generator = "generator")
	private Integer id;	
	@Column(name = "account_id")
	private String accountId;
	@Column(name = "account_oasis_info")
	private String accountOasisInfo;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getAccountOasisInfo() {
		return accountOasisInfo;
	}
	public void setAccountOasisInfo(String accountOasisInfo) {
		this.accountOasisInfo = accountOasisInfo;
	}
	
	public AfAccountOasis(){}
	
	public AfAccountOasis(String accountId){
		this.accountId = accountId;
		JAccountOasisInfo jAccountOasisInfo = new JAccountOasisInfo();
		this.accountOasisInfo = jAccountOasisInfo.objectToXml();
	}
}
