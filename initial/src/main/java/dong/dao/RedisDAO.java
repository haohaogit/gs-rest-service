package dong.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

/**
 * @CopyRightBy zcy.qyg.cn
 * @ClassName RedisDao
 * @Description TODO
 * @Author DongQing
 * @Date 2019-01-05 21:14
 **/
@Repository
public class RedisDAO {
    @Autowired
    private StringRedisTemplate template;

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    public void setName(String name) {
        redisTemplate.boundValueOps("name").set(name);
    }

    public String getName() {
        return redisTemplate.boundValueOps("name").get();
    }


    public  void setKey(String key,String value){
        ValueOperations<String, String> ops = template.opsForValue();
        ops.set(key,value);
    }

    public String getValue(String key){
        ValueOperations<String, String> ops = this.template.opsForValue();
        return ops.get(key);
    }
}
