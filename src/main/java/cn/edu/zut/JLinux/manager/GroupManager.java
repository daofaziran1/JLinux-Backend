package cn.edu.zut.JLinux.manager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.edu.zut.JLinux.dao.Group;
import cn.edu.zut.JLinux.dao.User;

public class GroupManager {
    public static String basePath = "vm\\etc\\groups";
    private HashMap<Integer, Group> groups = new HashMap<Integer, Group>();
    private Logger logger = LoggerFactory.getLogger("GroupLogger");
    static GroupManager instance = new GroupManager();

    public GroupManager() {
        groups = new HashMap<Integer, Group>();
        fromFile(basePath);
    }

    public Boolean isGroupExist(int gid) {
        return groups.containsKey(gid);
    }

    public static GroupManager getInstance() {
        var file=new File(basePath);
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }
    public Integer generateGroupId(){
        return groups.size() ;
    }
    public Boolean modifyGroup(Group group) {
        if (groups.containsKey(group.getGroupid())) {
            groups.put(group.getGroupid(), group);
            logger.info("modify group " + group.getGroupid() + " success");
            toFile(basePath);
            return true;
        }
        toFile(basePath);
        return false;
    }

    public Boolean removeGroup(Group group) {
        if (groups.containsKey(group.getGroupid())) {
            groups.remove(group.getGroupid());
            logger.info("remove group " + group.getGroupid() + " success");
            toFile(basePath);
            return true;
        }
        toFile(basePath);
        return false;
    }

    public Boolean removeUserFromGroup(User user, Group group) {
        if (groups.containsKey(group.getGroupid())) {
            Group group1 = groups.get(group.getGroupid());
            ArrayList<Integer> users = group1.getUserList();
            users.remove(user.getUid());
            group1.setUserList(users);
            groups.put(group.getGroupid(), group1);
            logger.info("remove user " + user.getUid() + " from group " + group.getGroupid() + " success");
            toFile(basePath);
            return true;
        }
        toFile(basePath);
        return false;
    }

    public Boolean removeUserFromGroup(User user) {
        for (Group group : groups.values()) {
            if (group.getUserList().contains(user.getUid())) {
                group.getUserList().remove(user.getUid());
                logger.info("remove user " + user.getUid() + " from group " + group.getGroupid() + " success");
                toFile(basePath);
                return true;
            }
        }
        toFile(basePath);
        return false;
    }

    public Boolean addUserToGroup(User user, Group group) {
        if (isGroupExist(group.getGroupid())) {
            Group group1 = groups.get(group.getGroupid());
            ArrayList<Integer> users = group1.getUserList();
            users.add(user.getUid());
            group1.setUserList(users);
            groups.put(group.getGroupid(), group1);
            if (group1.getUserList().contains(user.getUid())) {
                return false;
            } else {
                group1.getUserList().add(user.getUid());
                logger.info("add user " + user.getUid() + " to group " + group.getGroupid() + " success");
                toFile(basePath);
                return true;
            }
        } else {
            return false;
        }
    }

    public Boolean addGroup(int gid, Group group) {
        groups.put(gid, group);
        logger.info("add group " + gid + " success");
        toFile(basePath);
        return true;
    }

    public Boolean addGroup(Group group) {
        groups.put(group.getGroupid(), group);
        logger.info("add group " + group.getGroupid() + " success");
        toFile(basePath);
        return true;
    }

    public Group addGroup(String groupname) {
        var group=new Group(groupname,generateGroupId(),"",new ArrayList<Integer>());
        groups.put(group.getGroupid(), group);
        logger.info("add group " + group.getGroupid() + " success");
        toFile(basePath);
        return group;
    }

    public void fromFile(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            // groupname : password :id : groupdesc : userList
            while (br.ready()) {
                String line = br.readLine();
                if(line.equals("")){
                    continue;
                }
                String[] fields = line.split(":");
                var userList=new ArrayList<Integer>();
                if(fields.length>4){
                    userList = Arrays.asList(fields[4].split(",")).stream().map(i -> {
                        return Integer.parseInt(i);
                    }).collect(ArrayList<Integer>::new, ArrayList::add, ArrayList::addAll);
                }
                Group group = new Group(fields[0], Integer.parseInt(fields[2]), fields[3], userList);
                groups.put(group.getGroupid(), group);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void toFile(String fileName) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            groups.forEach((integer, group) -> {
                try {
                    bw.write(group.toString());
                    bw.newLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
