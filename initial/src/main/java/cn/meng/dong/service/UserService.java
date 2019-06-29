package cn.meng.dong.service;


import cn.meng.dong.domain.User;

import java.util.List;

/**
 * @CopyRightBy zcy.qyg.cn
 * @InterfaceName UserService
 * @Description TODO
 * @Author DongQing
 * @Date 2019-05-29 15:23
 **/

public interface UserService {
    void save(String name);

    int batchSave(List<User> user);

    List<User> batchSelect(List<Long> ids);

    int batchDelete(List<Long> ids);

    int batchUpdate(List<User> record);

    List<User> getDetailInfo(Integer age);
}
