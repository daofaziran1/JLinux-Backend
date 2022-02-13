package cn.edu.zut.JLinux;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JLinuxApplicationTests {

    @Test
    void contextLoads() {
        Logger logger= LoggerFactory.getLogger("UserLogger");
        logger.debug("msg");
    }

}
