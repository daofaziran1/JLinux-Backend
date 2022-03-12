package cn.edu.zut.JLinux.dao.cmds;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import cn.edu.zut.JLinux.controller.Login;
import cn.edu.zut.JLinux.dao.Command;
import cn.edu.zut.JLinux.dao.User;

public class CdCommand extends Command {
    public CdCommand(User user, long time, String[] args) {
        super("cd", user, time, new ArrayList<String>(Arrays.asList(args)));
    }

    @Override
    public void execute() {
        var path = Login.getPathByToken(getToken());
        var newPath=new File(path.getAbsolutePath()+"\\"+getArgArrayList().get(0));
        if(newPath.exists()){
            if(newPath.isDirectory()){
                Login.changePath(getToken(), newPath);
                addResult("status", true);
                addResult("msg", "切换成功");
            }else{
                addResult("status", false);
                addResult("msg", "不是文件夹");
            }
        }else{
            addResult("status", false);
            addResult("msg", "文件夹不存在");
        }
    }
}
