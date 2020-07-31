package org.zerock.mail;

import java.util.Properties;

public class MailConfig {

    private String mailAddress;
    private String mailPassword;

    public MailConfig(String mailAddress, String mailPassword) {
        this.mailAddress = mailAddress;
        this.mailPassword = mailPassword;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public String getMailPassword() {
        return mailPassword;
    }

    public Properties getPorps(){
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", 465);
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.ssl.enable", "true");
        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        return prop;
    }
}
