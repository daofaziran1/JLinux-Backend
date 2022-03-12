package cn.edu.zut.JLinux.dao.cmds;

import cn.edu.zut.JLinux.controller.Login;
import cn.edu.zut.JLinux.dao.Command;


import java.util.ArrayList;
import java.util.Arrays;

import cn.edu.zut.JLinux.dao.User;


public class PwdCommand extends Command{
    
    public PwdCommand(User user, long time, String[] args) {
        super("pwd", user, time, new ArrayList<String>(Arrays.asList(args)));
    }

    @Override
    public void execute() {
        var path = Login.getPathByToken(getToken());
        addResult("status", true);
        addResult("msg", path.getAbsolutePath());
    }
}
