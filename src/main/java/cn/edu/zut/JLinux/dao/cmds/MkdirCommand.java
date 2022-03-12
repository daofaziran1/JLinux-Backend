package cn.edu.zut.JLinux.dao.cmds;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import cn.edu.zut.JLinux.controller.Login;
import cn.edu.zut.JLinux.dao.Command;
import cn.edu.zut.JLinux.dao.User;

public class MkdirCommand extends Command {
    public MkdirCommand(User user, long time, String[] args) {
        super("mkdir" , user, time, new ArrayList<String>(Arrays.asList(args)));
    }

    @Override
    public void execute() {
        var path=Login.getPathByToken(getToken());
        if(!path.exists()){
            path.mkdirs();
        }
        var newFile=new File(path.getAbsolutePath()+"\\"+getArgArrayList().get(0));
        System.out.println(newFile.getAbsolutePath());
        var flag=newFile.mkdir();
        if(flag){
            addResult("status", true);
            addResult("msg", "文件夹创建成功");
        }else{
            addResult("status", false);
            addResult("msg", "文件夹创建失败");
        }
    }
    
}
