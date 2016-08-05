package com.virtusa.placement.controller;



import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.virtusa.placement.model.SeekerDatas;


public class SeekerData extends ActionSupport{


private static final long serialVersionUID = 1L;


private String username;
private String password;
private String pass2;
private String type;
private String first_name; 
private String last_name; 
private String email; 
 private String dob; 
private String gender; 
private String contact_address; 
private String zip; 
private String landline; 
private String mobile;

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


public String getUsername() {


return username;


}


public void setUsername(String username) {


this.username = username;


}


public String getPassword() {


return password;


}


public void setPassword(String password) {


this.password = password;


}


public String getType() {


return type;


}


public void setType(String type) {


this.type = type;


}

public String execute() throws Exception


{
try {
	/*if(getPassword()!=getPass2())
	{
	return "invalid";	
	}
	else
	{*/
	Map session=ActionContext.getContext().getSession();
	session.put("mobile", getMobile());
	session.put("userName",getUsername().toLowerCase());
SeekerDatas obj= new SeekerDatas();


obj.seekerinsert(getUsername(),getPassword(),getType(),getFirst_name(),getLast_name(),getEmail(),getDob(),getGender(),getContact_address(),getZip(),getLandline(),getMobile());
	//}
}
catch(Exception e)
{
e.printStackTrace();
}

return SUCCESS;
}
public String getEmail() {
return email;
}
public void setEmail(String email) {
this.email = email;

}

public String getPass2() {
	return pass2;
}

public void setPass2(String pass2) {
	this.pass2 = pass2;
}
}













 

 

