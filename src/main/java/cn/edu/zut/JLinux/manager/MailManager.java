package cn.edu.zut.JLinux.manager;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.edu.zut.JLinux.dao.Mail;
import cn.edu.zut.JLinux.dao.MailBox;
import cn.edu.zut.JLinux.dao.User;

public class MailManager {

    private HashMap<Integer, MailBox> mailBoxMap = new HashMap<Integer, MailBox>();
    private Logger logger = LoggerFactory.getLogger("MailLogger");
    static MailManager instance = new MailManager();

    public static MailManager getInstance() {
        return instance;
    }
    public boolean sendMail(Integer from, Integer to, String subject, Mail content) {
        MailBox fromBox = mailBoxMap.get(from);
        MailBox toBox = mailBoxMap.get(to);
        if (fromBox == null || toBox == null) {
            return false;
        }
        toBox.addMail(content);
        fromBox.addMail(content);
        logger.info("send mail from " + from + " to " + to + " success");
        return true;
    }

    public boolean sendMail(User from, User to, String subject, Mail content) {
        MailBox fromBox = mailBoxMap.get(from.getUid());
        MailBox toBox = mailBoxMap.get(to.getUid());
        if (fromBox == null || toBox == null) {
            return false;
        }
        toBox.addMail(content);
        fromBox.addMail(content);
        logger.info("send mail from " + from.getUid() + " to " + to.getUid() + " success");
        return true;
    }

    public boolean receiveMail(Integer uid, Mail content) {
        MailBox box = mailBoxMap.get(uid);
        if (box == null) {
            return false;
        }
        box.addMail(content);
        logger.info("receive mail from " + uid + " success");
        return true;
    }

    public boolean receiveMail(User user, Mail content) {
        MailBox box = mailBoxMap.get(user.getUid());
        if (box == null) {
            return false;
        }
        box.addMail(content);
        logger.info("receive mail from " + user.getUid() + " success");
        return true;
    }

    public boolean deleteMail(Integer uid, Integer mid) {
        MailBox box = mailBoxMap.get(uid);
        if (box == null) {
            return false;
        }
        box.deleteMail(mid);
        logger.info("delete mail " + mid + " from " + uid + " success");
        return true;
    }

    public boolean deleteMail(User user, Integer mid) {
        MailBox box = mailBoxMap.get(user.getUid());
        if (box == null) {
            logger.info("not found user " + user.getUid());
            return false;
        }
        box.deleteMail(mid);
        logger.info("delete mail " + mid + " from " + user.getUid() + " success");
        return true;
    }

    public boolean deleteMail(Integer uid, Mail mail) {
        MailBox box = mailBoxMap.get(uid);
        if (box == null) {
            logger.info("not found user " + uid);
            return false;
        }
        box.deleteMail(mail);
        logger.info("delete mail " + mail.getMid() + " from " + uid + " success");
        return true;
    }

    public boolean deleteMail(User user, Mail mail) {
        MailBox box = mailBoxMap.get(user.getUid());
        if (box == null) {
            logger.info("not found user " + user.getUid());
            return false;
        }
        box.deleteMail(mail);
        logger.info("delete mail " + mail.getMid() + " from " + user.getUid() + " success");
        return true;
    }

    public Mail getMail(Integer uid, Integer mid) {
        MailBox box = mailBoxMap.get(uid);
        if (box == null) {
            logger.info("not found user " + uid);
            return null;
        }
        return box.getMail(mid);
    }

    public Mail getMail(User user, Integer mid) {
        MailBox box = mailBoxMap.get(user.getUid());
        if (box == null) {
            logger.info("not found user " + user.getUid());
            return null;
        }
        return box.getMail(mid);
    }

    public MailBox getMailBox(Integer uid) {
        return mailBoxMap.get(uid);
    }

    public MailBox getMailBox(User user) {
        return mailBoxMap.get(user.getUid());
    }

    public boolean addMailBox(Integer uid, MailBox box) {
        mailBoxMap.put(uid, box);
        return true;
    }

    public boolean addMailBox(User user, MailBox box) {
        mailBoxMap.put(user.getUid(), box);
        return true;
    }

    public boolean removeMailBox(Integer uid) {
        mailBoxMap.remove(uid);
        return true;
    }

    public boolean removeMailBox(User user) {
        mailBoxMap.remove(user.getUid());
        return true;
    }

    public boolean removeMailBox(MailBox box) {
        mailBoxMap.remove(box.getUid());
        return true;
    }

    public boolean removeMailBox(Integer uid, MailBox box) {
        mailBoxMap.remove(uid, box);
        return true;
    }

    public boolean removeMailBox(User user, MailBox box) {
        mailBoxMap.remove(user.getUid(), box);
        return true;
    }

    public boolean removeMailBox(Integer uid, Integer mid) {
        MailBox box = mailBoxMap.get(uid);
        if (box == null) {
            return false;
        }
        box.deleteMail(mid);
        return true;
    }

    public boolean removeMailBox(User user, Integer mid) {
        MailBox box = mailBoxMap.get(user.getUid());
        if (box == null) {
            return false;
        }
        box.deleteMail(mid);
        return true;
    }

    public boolean removeMailBox(Integer uid, Mail mail) {
        MailBox box = mailBoxMap.get(uid);
        if (box == null) {
            return false;
        }
        box.deleteMail(mail);
        return true;
    }

    public boolean removeMailBox(User user, Mail mail) {
        MailBox box = mailBoxMap.get(user.getUid());
        if (box == null) {
            return false;
        }
        box.deleteMail(mail);
        return true;
    }

    public boolean removeMailBox(Integer uid, Integer mid, Mail mail) {
        MailBox box = mailBoxMap.get(uid);
        if (box == null) {
            return false;
        }
        box.deleteMail(mid, mail);
        return true;
    }

    public boolean removeMailBox(User user, Integer mid, Mail mail) {
        MailBox box = mailBoxMap.get(user.getUid());
        if (box == null) {
            return false;
        }
        box.deleteMail(mid, mail);
        return true;
    }

    public Boolean isMailBoxExist(Integer uid) {
        return mailBoxMap.containsKey(uid);
    }

    public Boolean isMailBoxExist(User user) {
        return mailBoxMap.containsKey(user.getUid());
    }

    public Boolean isMailBoxExist(MailBox box) {
        return mailBoxMap.containsValue(box);
    }

    public Boolean clearMailBox(Integer uid) {
        MailBox box = mailBoxMap.get(uid);
        if (box == null) {
            return false;
        }
        box.clearMailBox();
        return true;
    }

    public Boolean clearMailBox(User user) {
        MailBox box = mailBoxMap.get(user.getUid());
        if (box == null) {
            return false;
        }
        box.clearMailBox();
        return true;
    }

    public Boolean clearAllMail(Integer uid) {
        MailBox box = mailBoxMap.get(uid);
        if (box == null) {
            return false;
        }
        box.clearMailBox();
        return true;
    }

    public Boolean clearAllMail(User user) {
        MailBox box = mailBoxMap.get(user.getUid());
        if (box == null) {
            return false;
        }
        box.clearMailBox();
        return true;
    }

    public Boolean clearAllMailBox(){
        for (MailBox box : mailBoxMap.values()) {
            box.clearMailBox();
        }
        return true;
    }
}
