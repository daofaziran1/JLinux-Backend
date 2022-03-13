package cn.edu.zut.JLinux.dao.cmds;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import cn.edu.zut.JLinux.controller.Login;
import cn.edu.zut.JLinux.dao.Command;
import cn.edu.zut.JLinux.dao.User;

public class LsCommand extends Command {
    public LsCommand(User user, long time, String[] args) {
        super("ls", user, time, new ArrayList<String>(Arrays.asList(args)));
    }

    @Override
    public void execute() {
        var path = Login.getPathByToken(getToken());
        path.listFiles();
        addResult("status", true);
        addResult("files",
                new ArrayList<File>(Arrays.asList(path.listFiles()))
                        .stream()
                        .map(File::getAbsolutePath)
                        .map(file -> file.toString().replaceAll("C:", ""))
                        .toArray());
        addResult("msg", "文件已列出");
    }
}
