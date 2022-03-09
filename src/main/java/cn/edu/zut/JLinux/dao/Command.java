package cn.edu.zut.JLinux.dao;

import java.util.ArrayList;

public class Command {
    private String command;
    private String result;
    private String error;
    private String status;
    private String user;
    private long time;
    private String type;
    private ArrayList<String> argArrayList;

    public Command() {
        argArrayList = new ArrayList<String>();
    }

    public Command(String type, String command, String user, long time, ArrayList<String> argArrayList) {
        this.type = type;
        this.command = command;
        this.user = user;
        this.time = time;
        this.argArrayList = argArrayList;
    }

    public void execute(){
        
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
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

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
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
                "command='" + command + '\'' +
                ", result='" + result + '\'' +
                ", error='" + error + '\'' +
                ", status='" + status + '\'' +
                ", user='" + user + '\'' +
                ", time='" + time + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

}
