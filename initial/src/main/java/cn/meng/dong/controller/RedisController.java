package cn.meng.dong.controller;

import cn.meng.dong.dao.RedisDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @CopyRightBy zcy.qyg.cn
 * @ClassName RedisController
 * @Description TODO
 * @Author DongQing
 * @Date 2019-01-05 21:13
 **/
@RestController
public class RedisController {
    @Autowired
    private RedisDAO redisDao;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping("/set")
    public String set(String key,String value){
        redisDao.setKey(key, value);
        return "success";
    }
    @RequestMapping("/get")
    public String get(String key){
        return redisDao.getValue(key);
    }

    @RequestMapping("/setName")
    public String setName(String name){
        redisDao.setName(name);
        return "success";
    }
    @RequestMapping("/getName")
    public String getName() {
        return redisDao.getName();
    }
}
