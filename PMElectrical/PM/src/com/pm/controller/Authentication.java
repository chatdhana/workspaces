package com.pm.controller;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.pm.common.SessionMgr;
import com.pm.model.AuthenticationBiz;

public class Authentication extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;
	// From Form
	private String userName;
	private String pwd;

	private Map session;
	private String userType;

	@SuppressWarnings("unchecked")
	public String login() {
		if (getSession().get("loggedIn") != null)
			if (!getSession().get("loggedIn").equals("true")) {
				this.addActionMessage("Session Expired.");
				return "expire";
			}

		if (SessionMgr.isLoggedIn(getUserName())) {
			System.out.println("isLoggedIn()");
			int waitTime = SessionMgr.relLoginLock(getUserName());
			System.out.println("waitTime:" + waitTime);
			if (waitTime > 0) {
				this.addActionMessage("Login Failed.");
				this
						.addActionError("Already logged into this system! Try after "
								+ waitTime + " minute(s).");
				return "failure";
			}
		}

		userType = new AuthenticationBiz().userAuthentication(this);
		if (userType.length() > 0) {
			if (userType.equals("A")) {
				this.initSession();
				return "successAdmin";
			} else if (userType.equals("N") || userType.equals("R")) {
				this.initSession();
				return "successUser";
			} else {
				this.addActionMessage("Login Failed.");
				this.addActionError("Invalid User ID or Password.");
				return "failure";

			}

		} else {
			this.addActionMessage("Internal Server Error");
			this
					.addActionError("Error occured in an application or Database is down. Please contact your admin team.");

			return "error";
		}
	}

	private void initSession() {

		String sessionId = Double.toString(Math.random());
		getSession().put("userName", getUserName());
		getSession().put("sessionId", sessionId);
		getSession().put("loggedIn", "true");
		getSession().put("userType", userType);

		Map<String, String> sesnMap = new HashMap<String, String>();
		sesnMap = SessionMgr.getSession(getUserName());
		sesnMap.put("loggedIn", "true");
		sesnMap.put("sessionId", sessionId);
		sesnMap.put("lastAccessTime", Calendar.getInstance().getTime()
				.toString());
		SessionMgr.updateSession(getUserName(), sesnMap);

	}

	@SuppressWarnings("unchecked")
	public String logout() {
		if (getSession().get("userName") == null) {
			this
					.addActionMessage("You have already logged out of the system! Please do login again to use this application.");
			// SessionMgr.relSession(getSession().get("userName").toString());
		} else {
			if (SessionMgr.relSession(getSession().get("userName").toString())) {
				this.addActionMessage("You are logged out successfully!");
			} else {
				this
						.addActionMessage("You have already logged out of the system! Please do login again to use this application.");
			}
			getSession().remove("userName");
			getSession().put("loggedIn", "false");
		}
		return "logout";
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPwd() {
		return pwd;
	}

	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}
