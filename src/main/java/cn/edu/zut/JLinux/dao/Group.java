package cn.edu.zut.JLinux.dao;

import java.util.ArrayList;

public class Group {
    private String groupname;
    private String groupid;
    private String groupdesc;
    private ArrayList<User> users;
    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }
    public String getGroupname() {
        return groupname;
    }
    public void setGroupid(String groupid) {
        this.groupid = groupid;
    }
    public String getGroupid() {
        return groupid;
    }
    public void setGroupdesc(String groupdesc) {
        this.groupdesc = groupdesc;
    }
    public String getGroupdesc() {
        return groupdesc;
    }
    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }
    public ArrayList<User> getUsers() {
        return users;
    }
    

}
