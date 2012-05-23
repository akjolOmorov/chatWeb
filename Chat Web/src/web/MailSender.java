package web;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/****
 * 
 * @author dolphin
 *
 */

public class MailSender {
	
	public static boolean send(String content, String email) {
		
		try {
			  Properties props = new Properties();
		      props.put("mail.smtps.auth", "true");

		      Session mailSession = Session.getDefaultInstance(props, null);
		      Transport transport = mailSession.getTransport("smtps");

		      MimeMessage message = new MimeMessage(mailSession);
		      message.setSubject("\u041f\u043e\u0440\u0442\u0430\u043b \u0413\u043e\u0441\u0443\u0434\u0430\u0440\u0441\u0442\u0432\u0435\u043d\u043d\u044b\u0435 \u0437\u0430\u043a\u0443\u043f\u043a\u0438 \u041a\u044b\u0440\u0433\u044b\u0437\u0441\u043a\u043e\u0439 \u0420\u0435\u0441\u043f\u0443\u0431\u043b\u0438\u043a\u0438.");
		      message.setContent(content, "text/html; charset=UTF-8"); // html text
		      
		      message.addRecipient(Message.RecipientType.TO,
		           new InternetAddress(email));
		      message.addFrom(new InternetAddress[]{new InternetAddress("zakupki@okmot.kg")});
		      
		      message.setSender(new InternetAddress("zakupki@okmot.kg"));
		      
		      transport.connect("mail.okmot.kg", "zakupki@okmot.kg", "QwE123456");
		      transport.sendMessage(message,
		      message.getRecipients(Message.RecipientType.TO));
		      transport.close();
		      System.out.println("Message is Sent to :"+email);
		      return true;
		      
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}