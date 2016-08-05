package sms;


public class SMSClient
{
  public static void main(String[] args)
    throws Exception
  {
    System.out.println(new SMSClient().sms("9994783317", "dhanav", "9994783317", "hi"));
  }

  public String sms(String uid, String pwd, String mobile, String msg)
    throws Exception
  {
    SendSMSPortType obj = new SendSMSLocator().getSendSMSPort();
    
    return obj.sendSMSToMany(uid, pwd, mobile, msg);
  }
}