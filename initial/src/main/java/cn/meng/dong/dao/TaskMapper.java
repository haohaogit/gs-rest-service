package cn.meng.dong.dao;

import cn.meng.dong.domain.Task;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Task record);

    int insertSelective(Task record);

    Task selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Task record);

    int updateByPrimaryKey(Task record);
}
