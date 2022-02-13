package cn.edu.zut.JLinux;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JLinuxApplication {

    public static void main(String[] args) {
        SpringApplication.run(JLinuxApplication.class, args);
        Logger logger= LoggerFactory.getLogger("UserLogger");
        logger.debug("msg");
        logger.error("msg");
    }

}
