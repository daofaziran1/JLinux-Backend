package cn.edu.zut.JLinux.manager;

import java.util.HashMap;

public class UserManager {
    private HashMap<Integer,String> userMap;
    static UserManager instance = new UserManager();
    private UserManager(){
        userMap = new HashMap<Integer,String>();
    }
    public static UserManager getInstance(){
        return instance;
    }
    public void addUser(int uid,String userName){
        userMap.put(uid, userName);
    }
    public String getUserName(int uid){
        return userMap.get(uid);
    }
    public void removeUser(int uid){
        userMap.remove(uid);
    }
    public boolean isUserExist(int uid){
        return userMap.containsKey(uid);
    }
    public boolean isUserExist(String userName){
        return userMap.containsValue(userName);
    }
    public int getUid(String userName){
        for(Integer uid:userMap.keySet()){
            if(userMap.get(uid).equals(userName)){
                return uid;
            }
        }
        return -1;
    }
    public void clear(){
        userMap.clear();
    }
    public int getSize(){
        return userMap.size();
    }
    public boolean isEmpty(){
        return userMap.isEmpty();
    }
    public void print(){
        for(Integer uid:userMap.keySet()){
            System.out.println(uid+" "+userMap.get(uid));
        }
    }
    public void fromFile(String fileName){
        //TODO
    }
    public void toFile(String fileName){
        //TODO
    }
    public void freash(){
        //TODO
    }
}