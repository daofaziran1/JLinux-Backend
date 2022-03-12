package cn.edu.zut.JLinux.Utils;

import java.util.ArrayList;
import java.util.Arrays;

import cn.edu.zut.JLinux.controller.Login;
import cn.edu.zut.JLinux.dao.Command;
import cn.edu.zut.JLinux.dao.User;
import cn.edu.zut.JLinux.dao.cmds.CdCommand;
import cn.edu.zut.JLinux.dao.cmds.LsCommand;
import cn.edu.zut.JLinux.dao.cmds.MkdirCommand;
import cn.edu.zut.JLinux.dao.cmds.PwdCommand;
import cn.edu.zut.JLinux.dao.cmds.UseraddCommand;

public class Commands {
    public static Command getCommand(String command, String token ,long time){
        String[] commandArray = command.split(" ");
        String type=commandArray[0];
        String[] args=new String[commandArray.length-1];
        for(int i=1;i<commandArray.length;i++){
            args[i-1]=commandArray[i];
        }
        User user= Login.getUserByToken(token);//从token获取
        Command cmd;
        //根据type获取command
        switch (type) {
            case "mkdir":
                cmd= new MkdirCommand(user,time,args);
                break;
            
            case "useradd":
                cmd= new UseraddCommand(user,time,args);
                break;
            case "ls":
                cmd= new LsCommand(user,time,args);
                break;
            case "cd":
                cmd= new CdCommand(user,time,args);
                break;
            case "pwd":
                cmd= new PwdCommand(user,time,args);
                break;
            default:
                cmd=null;
                break;
        }
        cmd.setToken(token);
        return cmd;
    }
}
