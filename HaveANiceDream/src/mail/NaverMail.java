package utill;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import dto.ReservationDTO;

public class NaverMail  {
	ReservationDTO reser;



	public NaverMail(ReservationDTO reser) throws AddressException, MessagingException {
		super();
		this.reser = reser;
		sendMail();
	}
	public void sendMail() throws AddressException, MessagingException{
		
        String host = "smtp.gmail.com";
        final String username = "eatdanoreplay@gmail.com";
        final String password = "eatdanoreplay!";

        // ���� ����
        String recipient = "leesuj28@gmail.com";
        String subject = reser.getReserName()+"�� ����ȳ� ���� �Դϴ�.";
        String body = "eatda�� �̿����ּż� �����մϴ�.";
        
        //properties ����
        Properties props = new Properties();

        props.put("mail.smtps.auth", "true");
        // ���� ����

        Session session = Session.getDefaultInstance(props);
        MimeMessage msg = new MimeMessage(session);

        // ���� ����

        msg.setSubject(subject);

        msg.setText(body);

        msg.setFrom(new InternetAddress(username));

        msg.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));

 

        // �߼� ó��

        Transport transport = session.getTransport("smtps");

        transport.connect(host, username, password);

        transport.sendMessage(msg, msg.getAllRecipients());

        transport.close();       


	}
}
