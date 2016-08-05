package com.pm.controller;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class IterationTest extends ActionSupport {
	private static final long serialVersionUID = 1L;
	List<String> list1 = new ArrayList<String>();
	List<String> list2 = new ArrayList<String>();

	public String execute() throws Exception {

		list1.add("str11");
		list1.add("str12");
		list1.add("str13");
		list1.add("str14");
		list1.add("str15");
		

		list2.add("str21");
		list2.add("str22");
		list2.add("str23");
		list2.add("str24");
		list2.add("str11");

		this.setList1(list1);
		this.setList2(list2);
		return "SUCCESS";
	}

	public void setList1(List<String> list1) {
		this.list1 = list1;
	}

	public void setList2(List<String> list2) {
		this.list2 = list2;
	}

	public List<String> getList1() {
		return list1;
	}

	public List<String> getList2() {
		return list2;
	}

}
