package com.pm.controller;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class Initializer extends ActionSupport implements SessionAware {

	private Map session;	
	
	@Override
	public String execute() throws Exception {
		
		getSession().clear();
//		getSession().remove("userName");
//		getSession().remove("sessionId");
//		getSession().remove("loggedIn");
	
		return SUCCESS;
	}
	
	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;

	}

}
