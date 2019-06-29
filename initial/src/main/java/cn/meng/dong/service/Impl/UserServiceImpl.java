package cn.meng.dong.service.Impl;

import cn.meng.dong.dao.UserMapper;
import cn.meng.dong.domain.User;
import cn.meng.dong.dto.UserDTO;
import cn.meng.dong.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.assertj.core.util.Lists;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;


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

    @Override
    public List<User> getDetailInfo(Integer age) {
        List<User> users = userMapper.selectByAge(Math.toIntExact(age));
        if(CollectionUtils.isEmpty(users)){
            log.error("该年龄 没有用户");
            return Lists.newArrayList();
        }
        return convert2UserDTOList(users);
    }

    private List<User> convert2UserDTOList(List<User> users){
        return users.stream().map(u->{
            UserDTO userDTO = convert2UserDTO(u);
            return userDTO;
        }).collect(Collectors.toList());
//        List<UserDTO> userDTOS = Lists.newArrayList();
//        users.stream().forEach(x->{
//            userDTOS.add(convert2UserDTO(x));
//        });
//        return userDTOS.stream().collect(Collectors.toList());

    }
    public UserDTO convert2UserDTO(User user){
        if (user == null) return new UserDTO();
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user,userDTO);
        if (user.getSex().equals(1)) {
            userDTO.setHasGirl(false);
        } else {
            userDTO.setHasGirl(true);
            userDTO.setGirlName("qiuling");
            userDTO.setGirlAge(21);
        }
        return userDTO;
    }
}
