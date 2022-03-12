package cn.edu.zut.JLinux.dao.cmds;

import java.util.ArrayList;
import java.util.Arrays;

import cn.edu.zut.JLinux.OperaSystem;
import cn.edu.zut.JLinux.controller.Login;
import cn.edu.zut.JLinux.dao.Command;
import cn.edu.zut.JLinux.dao.User;

public class UseraddCommand extends Command {
    public UseraddCommand(User user, long time, String[] args) {
        super("useradd", user, time, new ArrayList<String>(Arrays.asList(args)));
    }

    @Override
    public void execute() {
        if (OperaSystem.userManager.isUserExist(getArgArrayList().get(0))) {
            addResult("status", false);
            addResult("msg", "用户已存在");
        } else {
            OperaSystem.addUser(Login.getUserByToken(getToken()), (String) getArgArrayList().get(0));
            System.out.println(getArgArrayList().get(0));
            if(OperaSystem.userManager.isUserExist((String) getArgArrayList().get(0))){
                addResult("status", true);
                addResult("msg", "用户创建成功");
            }else{
                addResult("status", false);
                addResult("msg", "用户创建失败");
            }
        }
    }
}
