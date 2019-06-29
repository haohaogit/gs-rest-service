package cn.meng.dong.dao;

import cn.meng.dong.domain.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int batchInsert(@Param("record") List<User> record);

    int batchDelete(@Param("ids") List<Long> ids);

    int batchUpdate(@Param("records") List<User> records);

    List<User> batchSelect(@Param("ids") List<Long> ids);
}
