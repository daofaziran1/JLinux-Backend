package cn.edu.zut.JLinux.dao;

public class Mail {
    private String sender;
    private String receiver;
    private String title;
    private String content;
    private long time;
    private int id;
    private int status;
    private int type;
    private int isRead;

    public Mail(String sender, String receiver, String title, String content, long time, int id, int status, int type,
            int isRead) {
        this.sender = sender;
        this.receiver = receiver;
        this.title = title;
        this.content = content;
        this.time = time;
        this.id = id;
        this.status = status;
        this.type = type;
        this.isRead = isRead;
    }

    public Mail(String sender, String receiver, String title, String content, long time, int id, int status, int type) {
        this.sender = sender;
        this.receiver = receiver;
        this.title = title;
        this.content = content;
        this.time = time;
        this.id = id;
        this.status = status;
        this.type = type;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean isRead() {
        return isRead == 1;
    }
}
