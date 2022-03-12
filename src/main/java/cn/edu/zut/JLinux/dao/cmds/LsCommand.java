package cn.edu.zut.JLinux.dao.cmds;

import java.util.ArrayList;
import java.util.Arrays;

import cn.edu.zut.JLinux.controller.Login;
import cn.edu.zut.JLinux.dao.Command;
import cn.edu.zut.JLinux.dao.User;

public class LsCommand extends Command{
    public LsCommand(User user, long time, String[] args) {
        super("ls", user, time, new ArrayList<String>(Arrays.asList(args)));
    }

    @Override
    public void execute() {
        var path = Login.getPathByToken(getToken());
        path.listFiles();
        addResult("status", true);
        addResult("files", path.listFiles());
        addResult("msg", "文件已列出");
    }
}
