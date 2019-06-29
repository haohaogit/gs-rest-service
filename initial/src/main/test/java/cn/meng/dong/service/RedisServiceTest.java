package cn.meng.dong.service;

import cn.meng.dong.dao.UserDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith( SpringJUnit4ClassRunner.class )
@SpringBootTest
public class RedisServiceTest {
    @Autowired
    private RedisService redisService;

    @Autowired
    private UserDAO userDAO;

    @Test
    public void testString1() {
        userDAO.setName("haohao");
        userDAO.setAddress("henan-xincai");
        userDAO.setAge(25);

        redisService.setString("name", userDAO.toString());
        System.out.println(redisService.getString("name"));
    }

}
