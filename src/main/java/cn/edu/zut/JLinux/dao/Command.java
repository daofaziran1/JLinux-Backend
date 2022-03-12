package cn.edu.zut.JLinux.dao;

import java.util.ArrayList;
import java.util.HashMap;

public class Command {
    private HashMap<String,Object> result;
    private String error;
    private String status;
    private User user;
    private String token;
    private long time;
    private String type;
    private ArrayList<String> argArrayList;

    public Command() {
        argArrayList = new ArrayList<String>();
        result=new HashMap<String,Object>();
    }

    public Command(String type,User user, long time, ArrayList<String> argArrayList) {
        this.type = type;
        this.user = user;
        this.time = time;
        this.argArrayList = argArrayList;
        result=new HashMap<String,Object>();
    }

    public ArrayList<String> getArgArrayList() {
        return argArrayList;
    }

    public void setToken(String token){
        this.token = token;
    }

    public String getToken(){
        return token;
    }

    public void setArgArrayList(ArrayList<String> argArrayList) {
        this.argArrayList = argArrayList;
    }
    public void execute(){
        
    }

    public HashMap<String,Object> getResult() {
        return result;
    }

    public void setResult(HashMap<String,Object> result) {
        this.result = result;
    }

    public void addResult(String key,Object value){
        result.put(key, value);
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Command{" +
                "result='" + result + '\'' +
                ", error='" + error + '\'' +
                ", status='" + status + '\'' +
                ", user='" + user + '\'' +
                ", time=" + time +
                ", type='" + type + '\'' +
                ", argArrayList=" + argArrayList +
                '}';
    }

}
