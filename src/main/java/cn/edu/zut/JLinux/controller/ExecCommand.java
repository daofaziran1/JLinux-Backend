package cn.edu.zut.JLinux.controller;

import java.util.HashMap;

import com.alibaba.fastjson.JSON;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.edu.zut.JLinux.Utils.Commands;

@RestController
public class ExecCommand {
    @PostMapping("/exec")
    public String exec(@RequestBody HashMap<String, Object> reqmap) {
        var token = (String)reqmap.get("token");
        var command = (String)reqmap.get("command");
        var time=(Integer)reqmap.get("time");
        var cmd=Commands.getCommand(command, token, time);
        cmd.execute();
        return JSON.toJSONString(cmd.getResult());
    }
}
