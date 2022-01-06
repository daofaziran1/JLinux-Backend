package cn.edu.zut.JLinux.dao;

import java.util.ArrayList;

public class MailBox {
    private int uid;
    private String userName;
    private ArrayList<Mail> mailList;
    public MailBox(int uid,String userName){
        this.uid = uid;
        this.userName = userName;
        mailList = new ArrayList<Mail>();
    }
    public int getUid(){
        return uid;
    }
    public String getUserName(){
        return userName;
    }
    public void addMail(Mail mail){
        mailList.add(mail);
    }
    public void removeMail(Mail mail){
        mailList.remove(mail);
    }
    public void removeMail(int index){
        mailList.remove(index);
    }
    public Mail getMail(int index){
        return mailList.get(index);
    }
    public int getMailSize(){
        return mailList.size();
    }
    public void print(){
        for(Mail mail:mailList){
            System.out.println(mail.getSender()+" "+mail.getReceiver()+" "+mail.getTitle()+" "+mail.getContent());
        }
    }
    
}
