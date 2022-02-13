package cn.edu.zut.JLinux.dao;

import java.util.ArrayList;

public class Group {
    private String groupname;
    private Integer groupid;
    private String groupdesc;
    private ArrayList<Integer> userList;

    public Group(String groupname, Integer groupid, String groupdesc, ArrayList<Integer> userList) {
        this.groupname = groupname;
        this.groupid = groupid;
        this.groupdesc = groupdesc;
        this.userList = userList;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public Integer getGroupid() {
        return groupid;
    }

    public void setGroupid(Integer groupid) {
        this.groupid = groupid;
    }

    public String getGroupdesc() {
        return groupdesc;
    }

    public void setGroupdesc(String groupdesc) {
        this.groupdesc = groupdesc;
    }

    public ArrayList<Integer> getUserList() {
        return userList;
    }

    public void setUserList(ArrayList<Integer> userList) {
        this.userList = userList;
    }


    public String getUserString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < userList.size(); i++) {
            sb.append(userList.get(i));
            if (i != userList.size() - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return groupname + ":x:" + groupid + ":" + groupdesc + ":" + getUserString();
    }

}
