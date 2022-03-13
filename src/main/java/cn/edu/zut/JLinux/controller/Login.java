package cn.edu.zut.JLinux.controller;

import java.io.File;
import java.util.HashMap;
import java.util.UUID;

import com.alibaba.fastjson.JSON;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.edu.zut.JLinux.OperaSystem;
import cn.edu.zut.JLinux.Utils.Encode;
import cn.edu.zut.JLinux.dao.User;

@RestController
public class Login {
    public static HashMap<String, User> userMap = new HashMap<String, User>();
    public static HashMap<String, File> fMap = new HashMap<String, File>();

    @PostMapping("/login")
    public String login(@RequestBody HashMap<String, String> reqmap) {
        var username=reqmap.get("username");
        var password=reqmap.get("password");
        System.out.println("username:" + username + " password:" + password);
        if (OperaSystem.userManager.isUserExist(username)) {
            User user = OperaSystem.userManager.getUser(username);
            if (user.getPasswordHash().equals(Encode.Md5(password))) {
                String token = UUID.randomUUID().toString();
                addUser(token, user);
                HashMap<String, Object> map = new HashMap<String, Object>();
                map.put("token", token);
                map.put("status", true);
                map.put("path",getPathByToken(token));
                return JSON.toJSONString(map);
            }
        }
        return "{status:false}";
    }

    public static void changePath(String token, File newPath) {
        fMap.put(token, newPath);
    }

    public static User getUserByToken(String token) {
        return userMap.get(token);
    }

    public static File getPathByToken(String token) {
        return fMap.get(token);
    }

    public static void addUser(String token, User user) {
        userMap.put(token, user);
        fMap.put(token, new File(user.getHomeDirectory()));
    }

    public static void removeUser(String token) {
        userMap.remove(token);
        fMap.remove(token);
    }

    public static boolean isLogin(String token) {
        return userMap.containsKey(token);
    }

    public static boolean isLogin(String token, String userName) {
        return userMap.containsKey(token) && userMap.get(token).getUserName().equals(userName);
    }

    public static void logout(String token) {
        removeUser(token);
    }

    public static String getToken(String userName) {
        for (String token : userMap.keySet()) {
            if (userMap.get(token).getUserName().equals(userName)) {
                return token;
            }
        }
        return null;
    }
}
