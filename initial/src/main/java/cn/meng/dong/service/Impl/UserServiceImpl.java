package cn.meng.dong.service.Impl;

import cn.meng.dong.dao.UserMapper;
import cn.meng.dong.domain.User;
import cn.meng.dong.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @CopyRightBy zcy.qyg.cn
 * @Author DongQing
 * @Date 2019-05-29 15:24
 * @ClassName UserServiceImpl
 * @Description TODO
 **/
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Transactional
    @Override
    public void save(String name) {
        User user = new User();
        user.setAge(22);
        user.setName(name);
        user.setSex(0);

        int i = userMapper.insertSelective(user);
        User user1 = userMapper.selectByPrimaryKey(user.getId());
        System.out.println("user1 "+user1.toString());

        log.error("current name is {}",user1.getName());

        // 测试@Transactional 事物回滚操作
        if(true){
            throw new RuntimeException("save 抛异常了");
        }
    }

    @Override
    public int batchSave(List<User> user) {
        return userMapper.batchInsert(user);
    }

    @Override
    public List<User> batchSelect(List<Long> ids) {
        return userMapper.batchSelect(ids);
    }

    @Override
    public int batchDelete(List<Long> ids) {
        return userMapper.batchDelete(ids);
    }

    @Override
    public int batchUpdate(List<User> record) {
        return userMapper.batchUpdate(record);
    }
}
