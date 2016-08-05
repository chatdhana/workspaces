package com.pm.controller;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.pm.common.SessionMgr;

public class Home extends ActionSupport implements SessionAware {
	private Map session;

	public String execute() {
		Map tempSesn = validateSession(getSession());
		if (tempSesn != null) {
			setSession(tempSesn);
		} else {
			return "EXPIRED";
		}

		String userType = getSession().get("userType").toString();

		if (userType.length() == 1) {
			return userType;
		}
		return "EXPIRED";
	}

	public Map validateSession(Map session) {

		if (session.get("loggedIn") != null)
			if (session.get("loggedIn").equals("true")) {
				String userName = session.get("userName").toString();
				if (SessionMgr.isLoggedIn(userName)) {
					if (SessionMgr.getValue(session.get("userName").toString(),
							"sessionId").equals(
							session.get("sessionId").toString())) {
						String sessionId = Double.toString(Math.random());
						SessionMgr.putValue(userName, "sessionId", sessionId);
						session.put("sessionId", sessionId);
						return session;
					}
				}
			}

		return null;
	}

	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
	}
}
