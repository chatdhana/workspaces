
	package com.virtusa.placement.controller;

	import java.io.File;
import java.util.Map;
	//import org.apache.commons.io.FileUtils;
import com.opensymphony.xwork2.ActionContext;
	import com.opensymphony.xwork2.ActionSupport;
import com.virtusa.placement.model.SeekerProfileDatas;
import com.virtusa.placement.sms.SmsClient;
	public class SeekerProfileData  extends ActionSupport{

	 private static final long serialVersionUID = 1L;
	
	 private String experience;
	 private String minsal;
	 private String maxsal;
	 private String farea;
	 private String industry;
	 private String keyskill1;
	 private String keyskill2;
	 private String keyskill3;
	 private String res_obj;
	 private String twelfth;
	 private String tenth;
	 private String ug;
	 private String ug_stream;
	 private String pg;
	 private String pg_stream;
	 private String doctorate;
	 private String field_phd;
	 private String university;
	 private File upload_resume;//The actual file
	 //   private String uploadContentType; //The content type of the file
	  //  private String uploadFileName; //The uploaded file name
	// private String upload_resume;
	 //private String paste_resume;
	 
	  
	 public String execute() throws Exception
	 {
	  
	 try 
	 {
		 Map session=ActionContext.getContext().getSession();
		 String userName=session.get("userName").toString();
		 System.out.println( getUpload_resume().toString());
	 SeekerProfileDatas obj= new SeekerProfileDatas();
	 obj.seekerprofile(userName,getExperience(),getMinsal(),getMaxsal(),getFarea(),getIndustry(),getKeyskill1(),getKeyskill2(),getKeyskill3(),getRes_obj(),getTwelfth(),getTenth(),getUg(),getUg_stream(),getPg(),getPg_stream(),getDoctorate(),getField_phd(),getUniversity(),getUpload_resume());
	 
	 
	  SmsClient.sendsms(session.get("mobile").toString(), "Hi "+userName+", Ur Account is Successfully Created in JobsCorp.com");

	 }
catch(Exception e)
{
	e.printStackTrace();
}
return SUCCESS;
	 }
	 
	 public String getExperience() {
	  return experience;
	 }
	 public void setExperience(String experience) {
	  this.experience = experience;
	 }
	 public String getMinsal() {
	  return minsal;
	 }
	 public void setMinsal(String minsal) {
	  this.minsal = minsal;
	 }
	 public String getMaxsal() {
	  return maxsal;
	 }
	 public void setMaxsal(String maxsal) {
	  this.maxsal = maxsal;
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
	 public String getTwelfth() {
	  return twelfth;
	 }
	 public void setTwelfth(String twelfth) {
	  this.twelfth = twelfth;
	 }
	 public String getTenth() {
	  return tenth;
	 }
	 public void setTenth(String tenth) {
	  this.tenth = tenth;
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
	public File getUpload_resume() {
		return upload_resume;
	}
	public void setUpload_resume(File upload_resume) {
		this.upload_resume = upload_resume;
	}
	
		  /*	  public String getUploadContentType() {
		    return uploadContentType;
		  }
		  public void setUploadContentType(String uploadContentType) {
		    this.uploadContentType = uploadContentType;
		  }
		  public String getUploadFileName() {
		    return uploadFileName;
		  }
		  public void setUploadFileName(String uploadFileName) {
		    this.uploadFileName = uploadFileName;
		  }

	 public String getUpload_resume() {
	  return upload_resume;
	 }
	 public void setUpload_resume(String upload_resume) {
	  this.upload_resume = upload_resume;
	 }
	  public String getPaste_resume() {
	  return paste_resume;
	 }
	 public void setPaste_resume(String paste_resume) {
	  this.paste_resume = paste_resume;
	 }
	  */
	}


