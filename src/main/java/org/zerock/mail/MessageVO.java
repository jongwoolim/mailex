package org.zerock.mail;

public class MessageVO {

    private String targetEmail;
    private String title;
    private String content;

    public MessageVO(String targetEmail, String title, String content) {
        this.targetEmail = targetEmail;
        this.title = title;
        this.content = content;
    }

    public String getTargetEmail() {
        return targetEmail;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "MessageVO{" +
                "targetEmail='" + targetEmail + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
