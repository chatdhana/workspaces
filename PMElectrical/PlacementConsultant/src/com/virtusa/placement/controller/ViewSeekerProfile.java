

	package com.virtusa.placement.controller;

import java.util.Iterator;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
	import org.hibernate.SessionFactory;

	import org.hibernate.cfg.Configuration;

import com.opensymphony.xwork2.ActionContext;
	import com.opensymphony.xwork2.ActionSupport;

import com.virtusa.placement.model.UpdateSeekerPersonalData;
import com.virtusa.placement.model.ViewSeekerBiz;
import com.virtusa.placement.model.ViewSeekerProfileBiz;
import com.virtusa.placement.pojo.SeekerProfilePojo; 

	public class ViewSeekerProfile extends ActionSupport{

		private static final long serialVersionUID = 1L;
		private String username;
		private String first_name;
		private String last_name;
		private String email;
		private String dob;
		private String gender;
		private String contact_address;
		private String zip;
		private String landline;
		private String mobile;
		
		private long experience;
		private long minsal;
		private long maxsal;
		private String farea;
		private String industry;
		private String keyskill1;
		private String keyskill2;
		private String keyskill3;
		private String res_obj;
		private long twelfth;
		private long tenth;
		private String ug;
		private String ug_stream;
		private String pg;
		private String pg_stream;
		private String doctorate;		
		private String field_phd;
		private String university;
		private String retVal;
		private String errorReport;
		//private String upload_resume;

//		private String paste_resume;

	public String getRetVal() {
			return retVal;
		}

		public void setRetVal(String retVal) {
			this.retVal = retVal;
		}

		public String getErrorReport() {
			return errorReport;
		}

		public void setErrorReport(String errorReport) {
			this.errorReport = errorReport;
		}

	public String execute() throws Exception{
	//	System.out.println("entered");
	//	Session session = null;
		//try {
		Map session=ActionContext.getContext().getSession();
		
		session.put("mobile", getMobile());
			UpdateSeekerPersonalData obj= new UpdateSeekerPersonalData();
			obj.seekerpersonalupdate(session.get("userName").toString(),getFirst_name(),getLast_name(),getEmail(),getDob(),getGender(),getContact_address(),getZip(),getLandline(),getMobile());
			
			ViewSeekerProfile vsp=new ViewSeekerProfile();
			vsp.setUsername(session.get("userName").toString());
			vsp.experience=experience;
			vsp.minsal=minsal;
			vsp.maxsal=maxsal;
			vsp.farea=farea;
			vsp.industry=industry;
			vsp.keyskill1=keyskill1;
			vsp.keyskill2=keyskill2;
			vsp.keyskill3=keyskill3;
			vsp.res_obj=res_obj;
			vsp.tenth=tenth;
			vsp.twelfth=twelfth;
			vsp.ug=ug;
			vsp.ug_stream=ug_stream;
			vsp.pg=pg;
			vsp.pg_stream=pg_stream;
			vsp.doctorate=doctorate;
			vsp.field_phd=field_phd;
			vsp.university=university;
			ViewSeekerProfileBiz vspb=new ViewSeekerProfileBiz();
			vsp=vspb.viewSeekerProfileMethod(vsp);
			experience=vsp.experience;
			System.out.println(experience);
			minsal=vsp.minsal;
			maxsal=vsp.maxsal;
			farea=vsp.farea;
			industry=vsp.industry;
			keyskill1=vsp.keyskill1;
			keyskill2=vsp.keyskill2;
			keyskill3=vsp.keyskill3;
			res_obj=vsp.res_obj;
			twelfth=vsp.twelfth;
			tenth=vsp.tenth;
			ug=vsp.ug;
			ug_stream=vsp.ug_stream;
			pg=vsp.pg;
			pg_stream=vsp.pg_stream;
			doctorate=vsp.doctorate;
			field_phd=vsp.field_phd;
			university=vsp.university;
			
				
			return vsp.getRetVal();
			
		
		}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getContact_address() {
		return contact_address;
	}

	public void setContact_address(String contact_address) {
		this.contact_address = contact_address;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getLandline() {
		return landline;
	}

	public void setLandline(String landline) {
		this.landline = landline;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	
	public long getExperience() {
		return experience;
	}

	public void setExperience(long experience) {
		this.experience = experience;
	}

	public long getMinsal() {
		return minsal;
	}

	public void setMinsal(long minsal) {
		this.minsal = minsal;
	}

	public long getMaxsal() {
		return maxsal;
	}

	public void setMaxsal(long maxsal) {
		this.maxsal = maxsal;
	}

	public long getTwelfth() {
		return twelfth;
	}

	public void setTwelfth(long twelfth) {
		this.twelfth = twelfth;
	}

	public long getTenth() {
		return tenth;
	}

	public void setTenth(long tenth) {
		this.tenth = tenth;
	}

	public String getFarea() {
		return farea;
	}

	public void setFarea(String farea) {
		this.farea = farea;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getKeyskill1() {
		return keyskill1;
	}

	public void setKeyskill1(String keyskill1) {
		this.keyskill1 = keyskill1;
	}

	public String getKeyskill2() {
		return keyskill2;
	}

	public void setKeyskill2(String keyskill2) {
		this.keyskill2 = keyskill2;
	}

	public String getKeyskill3() {
		return keyskill3;
	}

	public void setKeyskill3(String keyskill3) {
		this.keyskill3 = keyskill3;
	}

	public String getRes_obj() {
		return res_obj;
	}

	public void setRes_obj(String res_obj) {
		this.res_obj = res_obj;
	}

	
	public String getUg() {
		return ug;
	}

	public void setUg(String ug) {
		this.ug = ug;
	}

	public String getUg_stream() {
		return ug_stream;
	}

	public void setUg_stream(String ug_stream) {
		this.ug_stream = ug_stream;
	}

	public String getPg() {
		return pg;
	}

	public void setPg(String pg) {
		this.pg = pg;
	}

	public String getPg_stream() {
		return pg_stream;
	}

	public void setPg_stream(String pg_stream) {
		this.pg_stream = pg_stream;
	}

	public String getDoctorate() {
		return doctorate;
	}

	public void setDoctorate(String doctorate) {
		this.doctorate = doctorate;
	}

	public String getField_phd() {
		return field_phd;
	}

	public void setField_phd(String field_phd) {
		this.field_phd = field_phd;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}	
	
	
	


}
