package cn.meng.dong.service;

import cn.meng.dong.domain.User;
import cn.meng.dong.service.UserService;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @CopyRightBy zcy.qyg.cn
 * @Author DongQing
 * @Date 2019-06-29 08:58
 * @ClassName UserServiceTest
 * @Description TODO
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void batchInsertTest(){
        final String sname = "haohao";
        final Integer age = 12;
        final String email = "wwww.163.com";

        List<User> users = new ArrayList<>();
        for (int i=0; i<4;i++){
            User user = new User();
            user.setSex(i%2 == 1 ? 0 : 1 );
            user.setAge(age + i);
            user.setName(sname + i);
            user.setEmail(email);
            users.add(user);
        }
        users.stream().forEach(x -> {
            System.out.println(x.toString());
        });
        userService.batchSave(users);
    }

    @Test
    public void batchDelete(){

    }
    @Test
    public void batchSelect(){
        List<Long> ids = Lists.newArrayList();
        for(int i = 11;i < 15 ;i++){
            ids.add((long)i);
        }
        List<User> users = userService.batchSelect(ids);
        users.stream().forEach(x->{
            System.out.println(x.toString());
        });
    }
    @Test
    public void batchUpdate(){
        List<Long> ids = Lists.newArrayList();
        for(int i = 11;i < 15 ;i++){
            ids.add((long)i);
        }
        List<User> record = userService.batchSelect(ids);
        for (User u :record) {
            u.setAge(u.getAge()+10);
        }
        userService.batchUpdate(record);
    }
}
