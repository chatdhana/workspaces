package com.pm.controller;

import com.opensymphony.xwork2.ActionSupport;
import com.pm.model.LoginBiz;

public class Login extends ActionSupport {
	private String usrName;
	private String pwd;

	public String execute() throws Exception {

		if (LoginBiz.userVerification(this))
			return "SUCCESS";
		else
			return "error";

	}

	public String getUsrName() {
		return usrName;
	}

	public void setUsrName(String usrName) {
		this.usrName = usrName;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}
