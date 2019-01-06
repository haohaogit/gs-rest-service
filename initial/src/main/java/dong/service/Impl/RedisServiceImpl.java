package dong.service.Impl;

import dong.dao.UserDAO;
import dong.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @CopyRightBy zcy.qyg.cn
 * @Author DongQing
 * @Date 2019-01-06 11:25
 * @ClassName RedisServiceImpl
 * @Description TODO
 **/
@Service
public class RedisServiceImpl implements RedisService {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void setString(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
    }

    @Override
    public void setString(String key, String value, long time, TimeUnit unit) {
        stringRedisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
    }

    @Override
    public void multiSetString(Map<String, String> map) {
        stringRedisTemplate.opsForValue().multiSet(map);
    }

    @Override
    public String getString(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

    @Override
    public List<String> multiGetString(Collection<String> keys) {
        return stringRedisTemplate.opsForValue().multiGet(keys);
    }

    @Override
    public void increment(String key, Long delta) {
        stringRedisTemplate.opsForValue().increment(key, delta);
    }

    @Override
    public void append(String key, String value) {
        stringRedisTemplate.opsForValue().append(key, value);
    }

    @Override
    public Long getListSize(String key) {
        return stringRedisTemplate.opsForList().size(key);
    }

    @Override
    public void pushLeftAll(String key, Collection<String> values) {
        stringRedisTemplate.opsForList().leftPushAll(key, values);
    }

    @Override
    public void pushRightAll(String key, Collection<String> values) {
        stringRedisTemplate.opsForList().rightPushAll(key, values);
    }

    @Override
    public void setIndexValue(String key, Long index, String value) {
        stringRedisTemplate.opsForList().set(key, index, value);
    }

    @Override
    public String getIndexValue(String key, Long index) {
        return stringRedisTemplate.opsForList().index(key, index);
    }

    @Override
    public void popList(String key) {
        stringRedisTemplate.opsForList().leftPop(key);
    }

    @Override
    public void setHash(String key, String hashKey, String hashValue) {
        stringRedisTemplate.opsForHash().put(key, hashKey, hashValue);
    }

    @Override
    public void deleteHash(String key, String hashKey) {
        stringRedisTemplate.opsForHash().delete(key, hashKey);
    }

    @Override
    public Object getHashValue(String key, String hashKey) {
        return stringRedisTemplate.opsForHash().get(key, hashKey);
    }
}
