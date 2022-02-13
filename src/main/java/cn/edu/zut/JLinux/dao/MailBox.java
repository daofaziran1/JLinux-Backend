package cn.edu.zut.JLinux.dao;

import java.util.HashMap;

public class MailBox {
    private int uid;
    private String userName;
    private int newMailCount = 0;
    private HashMap<Integer, Mail> mailMap;

    public MailBox(int uid, String userName) {
        this.uid = uid;
        this.userName = userName;
        mailMap = new HashMap<Integer, Mail>();
    }

    public int getUid() {
        return uid;
    }

    public String getUserName() {
        return userName;
    }

    public void addMail(Mail mail) {
        newMailCount++;
        mail.setMid(newMailCount);
        mailMap.put(newMailCount, mail);
    }

    public void deleteMail(int mid) {
        mailMap.remove(mid);
    }

    public void deleteMail(Mail mail) {
        mailMap.remove(mail.getMid());
    }

    public void deleteMail(int mid, Mail mail) {
        mailMap.remove(mid);
    }

    public void removeMail(Mail mail) {
        mailMap.remove(mail.getMid());
    }

    public void removeMail(int index) {
        mailMap.remove(index);
    }

    public Mail getMail(int index) {
        return mailMap.get(index);
    }

    public int getMailSize() {
        return mailMap.size();
    }

    public boolean isMailExist(int mid) {
        return mailMap.containsKey(mid);
    }

    public boolean isMailExist(Mail mail) {
        return mailMap.containsValue(mail);
    }

    public boolean isMailExist(int mid, Mail mail) {
        return mailMap.containsValue(mail);
    }

    public boolean isMailExist(int mid, int index) {
        return mailMap.containsKey(index);
    }

    public boolean clearMail() {
        mailMap.clear();
        newMailCount = 0;
        return true;
    }

    public boolean clearMailBox() {
        mailMap.clear();
        newMailCount = 0;
        return true;
    }

    public int getMailCount() {
        return mailMap.size();
    }

}
