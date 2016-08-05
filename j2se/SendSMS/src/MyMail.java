import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;
import javax.mail.Address;

public class SendMail {



    private static final String SMTP_HOST_NAME = "smtp.gmail.com";

    private static final int SMTP_HOST_PORT = 465;

    private static final String SMTP_AUTH_USER = "hacktorock@gmail.com";

    private static final String SMTP_AUTH_PWD  = "hacktorock0987&";



    public static void main(String[] args) {

try{


       new SendMail().test();
}
catch(Exception e)
{
//e.printStackTrace();
System.out.println(e);
}

    }



   public void test() throws Exception{

        Properties props = new Properties();



        props.put("mail.transport.protocol", "smtps");

        props.put("mail.smtps.host", SMTP_HOST_NAME);

        props.put("mail.smtps.auth", "true");

        props.put("mail.smtps.quitwait", "false");



        Session mailSession = Session.getDefaultInstance(props);

        mailSession.setDebug(true);

        Transport transport = mailSession.getTransport();



        MimeMessage message = new MimeMessage(mailSession);

        message.setSubject("Testing SMTP-SSL");

        message.setContent("This is a test", "text/plain");



        message.addRecipient(Message.RecipientType.TO,

             new InternetAddress("chatdhana@gmail.com"));



        transport.connect
        (SMTP_HOST_NAME, SMTP_HOST_PORT, SMTP_AUTH_USER, SMTP_AUTH_PWD);



        transport.sendMessage(message,

            message.getRecipients(Message.RecipientType.TO));

        transport.close();

    }

}
