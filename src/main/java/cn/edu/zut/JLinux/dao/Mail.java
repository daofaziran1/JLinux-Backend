package cn.edu.zut.JLinux.dao;

import java.io.File;
import java.util.Date;

public class Mail {
    private int mid;
    private String subject;// 主题
    private String from;// 发件人地址
    private String to;// 收件人地址
    private Date date;// 发送时间
    private String content;// 邮件内容
    private boolean isRead;// 是否已读
    private File file;// 附件

    public Mail(String subject, String from, String to, Date date, String content, boolean isRead, File file) {
        this.subject = subject;
        this.from = from;
        this.to = to;
        this.date = date;
        this.content = content;
        this.isRead = isRead;
        this.file = file;
    }
    public Mail(int mid, String subject, String from, String to, Date date, String content, boolean isRead, File file) {
        this.mid = mid;
        this.subject = subject;
        this.from = from;
        this.to = to;
        this.date = date;
        this.content = content;
        this.isRead = isRead;
        this.file = file;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }
    public String getSubject() {
        return subject;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public Date getDate() {
        return date;
    }

    public String getContent() {
        return content;
    }

    public boolean isRead() {
        return isRead;
    }

    public File getFile() {
        return file;
    }

    public boolean changeRead() {
        // 如果已读，则变为未读，否则变为已读
        return isRead = !isRead;
    }

}
