package org.zerock.mail;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailSender {

    private Session session;
    private MailConfig mailConfig;

    public MailSender(final MailConfig mailConfig){

        this.mailConfig = mailConfig;
        session =
                Session.getDefaultInstance(mailConfig.getPorps(),
                        new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(mailConfig.getMailAddress(),
                                mailConfig.getMailPassword());
                    }
                });

    }

    public boolean sendMail(MessageVO messageVO){

        boolean result = false;
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(mailConfig.getMailAddress()));

            //수신자메일주소
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(messageVO.getTargetEmail()));

            // Subject
            message.setSubject(messageVO.getTitle()); //메일 제목을 입력

            // Text
            message.setText(messageVO.getContent());    //메일 내용을 입력

            // send the message
            Transport.send(message); ////전송
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }

        return result;
    }
}
