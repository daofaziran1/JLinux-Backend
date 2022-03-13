package cn.edu.zut.JLinux;


import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import cn.edu.zut.JLinux.manager.GroupManager;



@SpringBootApplication
public class JLinuxApplication {

    public static void main(String[] args) {
        SpringApplication.run(JLinuxApplication.class, args);
        OperaSystem.groupManager.fromFile(GroupManager.basePath);
    }

}
