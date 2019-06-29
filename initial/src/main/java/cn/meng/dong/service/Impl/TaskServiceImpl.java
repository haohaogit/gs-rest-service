package cn.meng.dong.service.Impl;

import cn.meng.dong.dao.TaskMapper;
import cn.meng.dong.domain.Task;
import cn.meng.dong.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @CopyRightBy zcy.qyg.cn
 * @Author DongQing
 * @Date 2019-05-29 20:31
 * @ClassName TaskServiceImpl
 * @Description TODO
 **/
@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskMapper taskMapper;

    @Override
    public Task create(Task task) {

        int i = taskMapper.insertSelective(task);
        System.out.println("create task id is "+ task.getId());
        return taskMapper.selectByPrimaryKey(task.getId());
    }
}
