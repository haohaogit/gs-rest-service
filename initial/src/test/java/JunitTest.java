import lombok.extern.slf4j.Slf4j;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @CopyRight By zcy.qyg.cn
 * @ClassName JunitTest
 * @Description TODO
 * @Author DongQing
 * @Date 2018-12-22 20:38
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = JunitTest.class)
@Slf4j
public class JunitTest {
    private final Logger logger = LoggerFactory.getLogger(JunitTest.class);

    /**
     *
     * 功能描述: junit test
     *
     * @param:
     * @return:
     * @auther: dongQing
     * @date: 2018-12-22 20:57
     */
    @Test
    public void junitTest() {
        logger.debug("debug test");
        logger.error("error test");
        logger.info("info y=test");
    }

    /**
     *
     * 功能描述: slf4j test
     *
     * @param:
     * @return:
     * @auther: dongQing
     * @date: 2018-12-22 20:57
     */
    @Test
    public void slf4jTest() {
        log.info("log info test");
        log.debug("log debug test");
        log.error("log error test");
    }

    /**
     *
     * 功能描述: git branch second test
     *
     * @param:
     * @return:
     * @auther: dongQing
     * @date: 2018-12-22 21:02
     */
}
