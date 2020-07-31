package org.zerock.mail;

import org.zerock.fortune.FortuneTeller;

import java.util.Scanner;

public class MailSendUI {

    private Scanner scanner;
    private MailSender mailSender;
    private FortuneTeller fortuneTeller;

    public MailSendUI(){
     this.scanner = new Scanner(System.in);
     MailConfig mailConfig =
             new MailConfig("whddn528@gmail.com","vlrcqcnmviiehqzu");
     this.mailSender = new MailSender(mailConfig);
     this.fortuneTeller = new FortuneTeller();
    }

    private String printInput(String msg){
        System.out.println(msg);
        return this.scanner.nextLine();
    }

    public void input(){
        String email = printInput("Mail Address");
        String title = "너의 운세를 알려주마";
        String content = fortuneTeller.getFortune();

        MessageVO messageVO = new MessageVO(email, title, content);
        boolean sendResult = mailSender.sendMail(messageVO);

        if(sendResult){
            System.out.println("정상적으로 메일이 발송 되었습니다.");
        }else{
            System.out.println("관리자에게 문의하세요");
        }

    }
}
