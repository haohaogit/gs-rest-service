package cn.meng.dong;

import cn.meng.dong.dao.UserDAO;
import cn.meng.dong.service.RedisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @CopyRightBy zcy.qyg.cn
 * @Author DongQing
 * @Date 2019-01-06 11:01
 * @ClassName dong.UserDAORedisTest
 * @Description TODO
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {UserDAORedisTest.class})     // 表示将某些类加入到测试环境的容器中
@ComponentScan(basePackages = {
        "dong",      // 自定义扫描 dong 目录下的所有 的@Service、@Controller、@Repository、@Component 的注解 并加入到Spring容器；
})
public class UserDAORedisTest {
    @Autowired
    private RedisService redisService;

    @Autowired
    private UserDAO userDAO;

    @Test
    public void testString() {
        userDAO.setName("haohao");
        userDAO.setAddress("henan-xincai");
        userDAO.setAge(25);

        redisService.setString("name", userDAO.toString());
        System.out.println(redisService.getString("name"));
    }
}
