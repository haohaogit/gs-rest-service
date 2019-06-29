package cn.meng.dong.controller;

import cn.meng.dong.domain.Task;
import cn.meng.dong.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @CopyRightBy zcy.qyg.cn
 * @Author DongQing
 * @Date 2019-05-29 20:33
 * @ClassName TaskController
 * @Description TODO
 **/
@RestController
public class TaskController {
    @Autowired
    private TaskService taskService;

    @RequestMapping("/task")
    public Task create(){
        Task task = new Task();
        task.setTaskName("跳水活动");
        task.setGrade(10);
        task.setType(2);
        return taskService.create(task);
    }
}
