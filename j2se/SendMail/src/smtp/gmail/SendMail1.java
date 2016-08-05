package smtp.gmail;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail1 {

	// Default values for smtp.
	private static String SMTP_HOST_NAME = "smtp.gmail.com";
	private static int SMTP_HOST_PORT = 465;
	private static String SMTP_AUTH_USER = "chatdhana@gmail.com";
	private static String SMTP_AUTH_PWD = "password";

	public static void main(String[] inParam) {

		int inParamLen = inParam.length;

		String SMTPHost = null;
		int SMTPPort = 0;
		String SMTPUserName = null;
		String toAddressFilePath = null;
		String subject = null;
		String messageBodyFilePath = null;
		if (inParamLen > 0) {

			for (int i = 0; i < inParamLen; i++) {
				if (inParam[i].equalsIgnoreCase("-h")) {
					SMTPHost = inParam[++i];
					if (SMTPHost.startsWith("-")) {
						i--;
						SMTPHost = null;
					} else
						System.out.println("SMTPHost:" + SMTPHost);
				} else if (inParam[i].equalsIgnoreCase("-p")) {
					SMTPPort = new Integer(inParam[++i]);
					if (Integer.toString(SMTPPort).startsWith("-")) {
						i--;
						SMTPPort = 0;
					} else
						System.out.println("SMTPPort:" + SMTPPort);
				} else if (inParam[i].equalsIgnoreCase("-u")) {
					SMTPUserName = inParam[++i];
					if (SMTPUserName.startsWith("-")) {
						i--;
						SMTPUserName = null;
					} else
						System.out.println("SMTPUserName:" + SMTPUserName);
				} else if (inParam[i].equalsIgnoreCase("-t")) {
					toAddressFilePath = inParam[++i];
					if (toAddressFilePath.startsWith("-")) {
						i--;
						toAddressFilePath = null;
					} else
						System.out.println("toAddressFilePath:"
								+ toAddressFilePath);
				} else if (inParam[i].equalsIgnoreCase("-s")) {
					subject = inParam[++i];
					if (subject.startsWith("-")) {
						i--;
						subject = null;
					} else
						System.out.println("Subject:" + subject);
				} else if (inParam[i].equalsIgnoreCase("-b")) {
					messageBodyFilePath = inParam[++i];
					if (messageBodyFilePath.startsWith("-")) {
						i--;
						messageBodyFilePath = null;
					} else
						System.out.println("messageBodyFilePath:"
								+ messageBodyFilePath);
				} else if (inParam[i].equalsIgnoreCase("-help")) {
					System.out.println("Help message....");
					System.exit(0);
				}
			}
		} else {
			System.out
					.println("Usage:\t SendSms {[-h SMTPHost][-p SMTPPort] -u SMTPUserName -t ToAddressFilePath -s Subject -b MessageBodyFilePath} \n\t SendSms {-help}");
		}
		
		if(SMTPUserName==null) {
		}
		

		try {
			// new SendMail1().test();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void propertyInit() {
		SMTP_HOST_NAME = "smtp.gmail.com";
		SMTP_HOST_PORT = 465;
		SMTP_AUTH_USER = "chatdhana@gmail.com";
		SMTP_AUTH_PWD = "  ` vg\\";
	}

	public void test() throws IOException {
		// InternetAddress[] iAddd=new InternetAddress[100];
		// String[] mailIds = {
		// "amala.raaj@gmail.com","arunrocks24@gmail.com","ashokchinna.c@gmail.com","babu.inbox@gmail.com","balakumar004@gmail.com","balaigrow@gmail.com","enggstud2006@gmail.com","brkarthikeyan@gmail.com","smgbbk@gmail.com","charmingdhana@gmail.com","chomaskandar@gmail.com","daviskoshy02@gmail.com","chatdhana@gmail.com","audaz.deen@gmail.com","dines.vl@gmail.com","dsureshkumar4u@gmail.com","vgsraj@gmail.com","eselvaprakash@gmail.com","ganesh.31185@gmail.com","m.g.reddy12@gmail.com","hacktorock@gmail.com","harikumar.prf@gmail.com","hariharanmm@gmail.com","hyrullah@gmail.com","itsmesathesh@gmail.com","itzmeganesh@yahoo.co.in","csejawahar@gmail.com","jassimejoy@gmail.com","jcholanj@gmail.com","kannadasan.l@gmail.com","karvir26@gmail.com","dskarthickraj@gmail.com","karthik2invite@gmail.com","karthikeyan.prf@gmail.com","karthikeyan.p02@mphasis.com","karthikeyanleo@yahoo.com","karun82@gmail.com","launchpad15.materials@gmail.com","madhan2meetu@gmail.com","mafiakorn@gmail.com","mana.yours@gmail.com","gm.kandan1986@gmail.com","manikandan.thangam@gmail.com","maniwithsmile@gmail.com","manojdpi@gmail.com","mgreddy_cse@yahoo.co.in","muthu_gangster@yahoo.co.in","muthu23phoenix@yahoo.co.in","nadast_2007@yahoo.com.sg","narendrareddy14@gmail.com","nepoleonjoseph@gmail.com","nirmalkumar2007@gmail.com","obuliprakash@gmail.com","ponvino@gmail.com","prabu1508@gmail.com","pradeepmec52@gmail.com","pradeep.mks@gmail.com","premsanthosh1987@gmail.com","prs2cu@gmail.com","cuddaloreraghu@gmail.com","raj2cu@gmail.com","dandamudiraja@gmail.com","rajanbabu100@gmail.com","rakesh635@gmail.com","ram_chemengg@yahoo.co.in","rambtechit@gmail.com","sakthimaharai@gmail.com","sanzeeus@gmail.com","sarath_nic@yahoo.co.in","sarath.nic@gmail.com","saravanan_adt@yahoo.co.in","sathishkumar2cu@gmail.com","sathishsubramani.k@gmail.com","bajisangepu@gmail.com","selva2cu@gmail.com","senthilarasi.senthil@gmail.com","seneceirtt@gmail.com","shaam.2226@gmail.com","shamfires@gmail.com","shandoshkutty@gmail.com","silverstarashok@gmail.com","jkm.siva@gmail.com","sivarajak@gmail.com","spkarthikeyan86@gmail.com","seenu2cu@gmail.com","jsrini87@gmail.com","ghbhavesh@gmail.com","subashchandraboset@gmail.com","subbuthemostcute@gmail.com","sunil2getu@gmail.com","swaroopkumar.swami@gmail.com","funguy.cse@gmail.com","tsreekaanth@gmail.com","vbasky@gmail.com","vigneshatsalem@gmail.com","vignesh.chandramohan@gmail.com","vinochat@gmail.com","vinodh.iyr@gmail.com","vinto.otniv@gmail.com","vinothkumarvediyappan@yahoo.com","vivek.k.gen@gmail.com","vvinoth3107@gmail.com","yesyeskaysadhanai@gmail.com"
		// };// ,
		// String[] mailIds =
		// {"9566054155@160by2.com","9600001975@160by2.com","9600016063@160by2.com","9688152649@160by2.com","9940903363@160by2.com","9488886251@160by2.com","9486869805@160by2.com","9791231969@160by2.com","9944930902@160by2.com","9894929566@160by2.com","9952619314@160by2.com","9790480648@160by2.com","9944904496@160by2.com","9443804441@160by2.com","9176691986@160by2.com","9677690079@160by2.com","9047961794@160by2.com","9842330618@160by2.com","9790415060@160by2.com","9790426280@160by2.com","9486078320@160by2.com","9840717527@160by2.com","9940010808@160by2.com","9486947343@160by2.com","9751346801@160by2.com","9443259891@160by2.com","9943131449@160by2.com","9443939662@160by2.com","9986952331@160by2.com","9994783317@160by2.com","9843744341@160by2.com","9944351023@160by2.com","9986952646@160by2.com","9773300000@160by2.com","9943040408@160by2.com","9751501806@160by2.com","9787511047@160by2.com","9487014396@160by2.com","9241717943@160by2.com","9843469224@160by2.com","9865406894@160by2.com","9486281659@160by2.com","9094013400@160by2.com","9710905198@160by2.com","9962501812@160by2.com","9994472520@160by2.com","9003583764@160by2.com","9442550761@160by2.com","9867137975@160by2.com","9952488940@160by2.com","9942322292@160by2.com","9600884840@160by2.com","9994955047@160by2.com","9566569546@160by2.com","9011066726@160by2.com","9842785844@160by2.com","9942079500@160by2.com","9884458818@160by2.com","9843824090@160by2.com","9715548300@160by2.com","9790571454@160by2.com","9786989626@160by2.com","9894524739@160by2.com","9488390899@160by2.com","9676937190@160by2.com","9994976657@160by2.com","9500052468@160by2.com","9442169451@160by2.com","9842379609@160by2.com","9788044826@160by2.com","9566142499@160by2.com","9994791212@160by2.com","9787509900@160by2.com","9952150146@160by2.com","9791231902@160by2.com","9952252723@160by2.com","9994288303@160by2.com","9042509069@160by2.com","9600321124@160by2.com","9841405447@160by2.com","9445258557@160by2.com","9043577829@160by2.com","9884265875@160by2.com","9787689086@160by2.com","9952795086@160by2.com","9366121611@160by2.com","9344624877@160by2.com","9986050607@160by2.com","9751117032@160by2.com","9840744557@160by2.com","9160027343@160by2.com","9600007496@160by2.com","9962146046@160by2.com","9843283468@160by2.com","9940863757@160by2.com","9791646683@160by2.com","9940110494@160by2.com","9486136635@160by2.com","9894708068@160by2.com","9994525033@160by2.com","9952150961@160by2.com","9952378702@160by2.com","9942419820@160by2.com","9952150145@160by2.com","9788886910@160by2.com","9362614541@160by2.com","9442953211@160by2.com","9976272167@160by2.com","9790267697@160by2.com","9791889921@160by2.com","9976215099@160by2.com","9842077370@160by2.com","9790466869@160by2.com","9566862149@160by2.com","9976887980@160by2.com","9367468150@160by2.com","9787365792@160by2.com","9367797747@160by2.com","9345867747@160by2.com","9787722516@160by2.com","9965887648@160by2.com","9790266916@160by2.com","4142314313@160by2.com","9797443755@160by2.com","9345660626@160by2.com","9787000671@160by2.com","9486788608@160by2.com","9750027371@160by2.com","9095919797@160by2.com","9894828886@160by2.com","9442691213@160by2.com","9176601812@160by2.com","9952150853@160by2.com","9942221972@160by2.com","9994790583@160by2.com","9942529143@160by2.com","9944650331@160by2.com","9786103004@160by2.com","9841875780@160by2.com","9842585844@160by2.com","9944203023@160by2.com","9894692754@160by2.com","9952150915@160by2.com","4424230000@160by2.com","9600082726@160by2.com","9751571557@160by2.com","9787503010@160by2.com","9790617294@160by2.com","9791541631@160by2.com","9600655740@160by2.com","9787974050@160by2.com","9894663233@160by2.com","9486440267@160by2.com","9952075702@160by2.com","9940916572@160by2.com","9994217663@160by2.com","9942483438@160by2.com","9894257211@160by2.com","9994594953@160by2.com","9894441276@160by2.com","9952653079@160by2.com","9003377374@160by2.com","9841229823@160by2.com","9940028873@160by2.com","9751011427@160by2.com","9486134954@160by2.com","9940106072@160by2.com","9894354639@160by2.com","9787671355@160by2.com","9884729971@160by2.com","9043255271@160by2.com","9940284757@160by2.com","9791504204@160by2.com","9952653285@160by2.com","9787974080@160by2.com","9894331185@160by2.com","9047536601@160by2.com","9884581806@160by2.com","9789850934@160by2.com","9843456832@160by2.com","9500358639@160by2.com","9790988951@160by2.com","9094457727@160by2.com","9788735772@160by2.com","9962542020@160by2.com","9944379533@160by2.com","9894921603@160by2.com","9894763361@160by2.com","9840492931@160by2.com","9894988244@160by2.com","9444822790@160by2.com","9943663952@160by2.com","9841368042@160by2.com","9994897900@160by2.com","9994656917@160by2.com","9840140418@160by2.com","9790623123@160by2.com","9940585554@160by2.com","9791064767@160by2.com","9884711431@160by2.com","9790925575@160by2.com","9600012916@160by2.com","9789954511@160by2.com","9600114886@160by2.com","9543114564@160by2.com","9790795217@160by2.com","9791497888@160by2.com","9940200495@160by2.com","9940029298@160by2.com","9840466209@160by2.com","9994237758@160by2.com","9894348468@160by2.com","9884003699@160by2.com","9894240287@160by2.com","9843019916@160by2.com","9994516596@160by2.com","9677118191@160by2.com","9944522087@160by2.com","9176658580@160by2.com","9976142388@160by2.com","9486082830@160by2.com","9952564859@160by2.com","9940542006@160by2.com","9894774316@160by2.com","9751165711@160by2.com","9715264870@160by2.com","9843888676@160by2.com","9789385200@160by2.com","9789951954@160by2.com","9994428964@160by2.com","9786356618@160by2.com","9790919328@160by2.com","9952856235@160by2.com","9894076034@160by2.com","9884623243@160by2.com","9994360118@160by2.com","9944269392@160by2.com","9962573373@160by2.com","9985086363@160by2.com","9790050188@160by2.com","9842258597@160by2.com","9600097000@160by2.com","9994780765@160by2.com","9870807070@160by2.com","9952749703@160by2.com","9894191213@160by2.com","9751461369@160by2.com","9994303881@160by2.com","9789226889@160by2.com","9486075426@160by2.com","9035871239@160by2.com","9952194943@160by2.com"};
		String[] mailIds = { "chatdhana@gmail.com" };
		String[] name = { "", "Dhana" };
		// };
		Properties props = new Properties();
		props.put("mail.transport.protocol", "smtps");
		props.put("mail.smtps.host", SMTP_HOST_NAME);
		props.put("mail.smtps.auth", "true");
		props.put("mail.smtps.quitwait", "false");
		Session mailSession = Session.getDefaultInstance(props);
		StringBuilder mailBody = new StringBuilder();
		FileInputStream in = new FileInputStream(new File(
				"C:/Documents and Settings/dgovindan/Desktop/mailbody.txt"));
		int c;
		while ((c = in.read()) != -1) {
			mailBody.append((char) c);
		}
		// mailSession.setDebug(true);
		Transport transport;
		try {
			transport = mailSession.getTransport();
			transport.connect(SMTP_HOST_NAME, SMTP_HOST_PORT, SMTP_AUTH_USER,
					SMTP_AUTH_PWD);
			System.out.println("Mail Sent To: ");
			for (int i = 0; i < mailIds.length; i++) {
				MimeMessage message = new MimeMessage(mailSession);

				message.setSubject("chatdhana");
				message.setContent(mailBody.toString(), "text/plain");

				/*
				 * message .setContent("Hi
				 * "+(name[i]!=""?name[i]:"Dear")+",\n"+mailBody.toString(),
				 * "text/plain");
				 */

				message.addRecipient(Message.RecipientType.TO,
						new InternetAddress(mailIds[i]));
				transport.sendMessage(message, message
						.getRecipients(Message.RecipientType.TO));
				System.out.println(mailIds[i]);

			}
			transport.close();
		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}

}