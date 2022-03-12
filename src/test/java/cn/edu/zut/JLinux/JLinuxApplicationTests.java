package cn.edu.zut.JLinux;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.edu.zut.JLinux.Utils.Encode;

class JLinuxApplicationTests {

    @Test
    void contextLoads() {
        Logger logger= LoggerFactory.getLogger("UserLogger");
        logger.debug("msg");
    }
    @Test
    void test() {
        System.out.println(Encode.Md5("123456"));
    }
}
