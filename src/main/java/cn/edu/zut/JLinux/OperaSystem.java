package cn.edu.zut.JLinux;

import cn.edu.zut.JLinux.dao.Group;
import cn.edu.zut.JLinux.dao.Mail;
import cn.edu.zut.JLinux.dao.User;
import cn.edu.zut.JLinux.manager.GroupManager;
import cn.edu.zut.JLinux.manager.MailManager;
import cn.edu.zut.JLinux.manager.UserManager;

public class OperaSystem {
    public static GroupManager groupManager = GroupManager.getInstance();
    public static UserManager userManager = UserManager.getInstance();
    public static MailManager mailManager = MailManager.getInstance();

    public static Boolean addUser(User callUser, String addUser) {
        if (callUser==null||callUser.getUid() == 0) {
            var group=addGroup(callUser, addUser);
            return userManager.addUser(addUser,group);
        } else {
            return false;
        }
    }

    public static Boolean addUser(User callUser, User addUser) {
        if (callUser.getUid() == 0) {
            return userManager.addUser(addUser);
        } else {
            return false;
        }
    }
    public static Group addGroup(User callUser, String addGroup) {
        if (callUser==null || callUser.getUid() == 0) {
            return groupManager.addGroup(addGroup);
        } else {
            return null;
        }
    }

    public static Boolean addGroup(User callUser, Group addGroup) {
        if (callUser.getUid() == 0) {
            return groupManager.addGroup(addGroup);
        } else {
            return false;
        }
    }

    public static Boolean addUserToGroup(User callUser, User addUser, Group addGroup) {
        if (callUser.getUid() == 0) {
            return groupManager.addUserToGroup(addUser, addGroup);
        } else {
            return false;
        }
    }

    public static Boolean removeUser(User callUser, User removeUser) {
        if (callUser.getUid() == 0) {
            groupManager.removeUserFromGroup(removeUser);
            return userManager.removeUser(removeUser);
        } else {
            return false;
        }
    }

    public static Boolean removeGroup(User callUser, Group removeGroup) {
        if (callUser.getUid() == 0) {
            return groupManager.removeGroup(removeGroup);
        } else {
            return false;
        }
    }

    public static Boolean removeUserFromGroup(User callUser, User removeUser, Group removeGroup) {
        if (callUser.getUid() == 0) {
            return groupManager.removeUserFromGroup(removeUser, removeGroup);
        } else {
            return false;
        }
    }

    public static Boolean modifyUser(User callUser, User modifyUser) {
        if (callUser.getUid() == 0) {
            return userManager.modifyUser(modifyUser);
        } else {
            return false;
        }
    }

    public static Boolean modifyGroup(User callUser, Group modifyGroup) {
        if (callUser.getUid() == 0) {
            return groupManager.modifyGroup(modifyGroup);
        } else {
            return false;
        }
    }

    public static Boolean sendMail(User callUser, User sendUser, String subject, Mail content) {
        if (callUser.getUid() == 0) {
            return mailManager.sendMail(callUser, sendUser, subject, content);
        } else {
            return false;
        }
    }

    public static Boolean receiveMail(User callUser, User receiveUser, Mail content) {
        if (callUser.getUid() == 0) {
            return mailManager.receiveMail(receiveUser, content);
        } else {
            return false;
        }
    }

    public static Boolean deleteMail(User callUser, User deleteUser, Mail content) {
        if (callUser.getUid() == 0) {
            return mailManager.deleteMail(deleteUser, content);
        } else {
            return false;
        }
    }

    public static Boolean clearMailBox(User callUser, User clearUser) {
        if (callUser.getUid() == 0) {
            return mailManager.clearMailBox(clearUser);
        } else {
            return false;
        }
    }

    public static Boolean clearAllMailBox(User callUser) {
        if (callUser.getUid() == 0) {
            return mailManager.clearAllMailBox();
        } else {
            return false;
        }
    }

}
