import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.*;
import java.util.Date;
import java.util.Properties;

public class Email {

    public static void main(String[] args) throws MessagingException {

        String userFrom = "tanyushazaja@mail.ru";
        String userPassword = "2m74yin0hLk5fJ369btP";
        String userTo =  "borzenkova.tatiana@gmail.com";

        Properties props = new Properties();
        props.put("mail.transport.protocol", "smtps");
        props.put("mail.smtps.ssl.trust", "smtp.mail.ru");
        props.put("mail.smtps.auth", "true");
        //props.put("mail.smtps.host", "smtp.mail.ru");
        //props.put("mail.smtps.user", userFrom);
        props.put("mail.smtps.starttls.enable", "true");

        Session session = Session.getDefaultInstance(props);

        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(userFrom));
        message.setSubject("тема письма - with Intellij IDEA Community Edition");
        message.setText("текст письма");
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(userTo));
        message.setSentDate(new Date());

        Transport transport = session.getTransport();
        transport.connect("smtp.mail.ru", 465, userFrom, userPassword);
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }
}
