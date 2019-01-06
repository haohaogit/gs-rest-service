package dong.service;

import dong.dao.UserDAO;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @CopyRightBy zcy.qyg.cn
 * @InterfaceName RedisService
 * @Description TODO
 * @Author DongQing
 * @Date 2019-01-06 11:16
 **/

public interface RedisService {

    /**
     *
     * 功能描述: 设置String 类型的Redis类型的缓存
     *
     * @auther: dongQing
     * @date: 2019-01-06 14:45
     * @param: 键
     * @param: 值
     * @return:
     */
    void setString(String key, String value);

    /**
     *
     * 功能描述: 带有失效时间的缓存
     *
     * @auther: dongQing
     * @date: 2019-01-06 14:48
     * @param: 
     * @param: 
     * @return: 
     */
    void setString(String key, String value, long time, TimeUnit unit);

    /**
     *
     * 功能描述: 批量导入缓存
     *
     * @auther: dongQing
     * @date: 2019-01-06 14:49
     * @param: 
     * @param: 
     * @return: 
     */
    void multiSetString(Map<String, String> map);

    /**
     *
     * 功能描述: 根据 key 值获取 value
     *
     * @auther: dongQing
     * @date: 2019-01-06 14:51
     * @param:
     * @param:
     * @return:
     */
    String getString(String key);

    /**
     *
     * 功能描述: 批量获取 value 值
     *
     * @auther: dongQing
     * @date: 2019-01-06 14:52
     * @param:
     * @param:
     * @return:
     */
    List<String> multiGetString(Collection<String> keys);

    /**
     *
     * 功能描述: 对 value 值 增加操作
     *
     * @auther: dongQing
     * @date: 2019-01-06 14:52
     * @param: 
     * @param: 
     * @return: 
     */
    void increment(String key, Long delta);

    /**
     *
     * 功能描述: 对字符串 续接 新的字符串
     *
     * @auther: dongQing
     * @date: 2019-01-06 14:54
     * @param:
     * @param:
     * @return:
     */
    void append(String key, String value);

    /**
     *
     * 功能描述: 获取链表的容量值
     *
     * @auther: dongQing
     * @date: 2019-01-06 14:55
     * @param:
     * @param:
     * @return:
     */
    Long getListSize(String key);

    /**
     *
     * 功能描述: 批量在链表 左侧插入values
     *
     * @auther: dongQing
     * @date: 2019-01-06 14:55
     * @param:
     * @param:
     * @return:
     */
    void pushLeftAll(String key, Collection<String> values);

    /**
     *
     * 功能描述: 批量在链表 右侧插入values
     *
     * @auther: dongQing
     * @date: 2019-01-06 14:56
     * @param:
     * @param:
     * @return:
     */
    void pushRightAll(String key, Collection<String> values);

    /**
     *
     * 功能描述: 在指定位置 index 处设置 value
     *
     * @auther: dongQing
     * @date: 2019-01-06 14:57
     * @param:
     * @param:
     * @return:
     */
    void setIndexValue(String key, Long index, String value);

    /**
     *
     * 功能描述: 获取指定 index 位置的value
     *
     * @auther: dongQing
     * @date: 2019-01-06 14:57
     * @param:
     * @param:
     * @return:
     */
    String getIndexValue(String key, Long index);

    /**
     *
     * 功能描述: 弹出value
     *
     * @auther: dongQing
     * @date: 2019-01-06 14:58
     * @param:
     * @param:
     * @return:
     */
    void popList(String key);

    /**
     *
     * 功能描述: 设置hash
     *
     * @auther: dongQing
     * @date: 2019-01-06 14:58
     * @param:
     * @param:
     * @return:
     */
    void setHash(String key, String hashKey, String hashValue);

    /**
     *
     * 功能描述: 删除指定键值的value
     *
     * @auther: dongQing
     * @date: 2019-01-06 14:59
     * @param:
     * @param:
     * @return:
     */
    void deleteHash(String key, String hashKey);

    /**
     *
     * 功能描述: 获取指定键值的value
     *
     * @auther: dongQing
     * @date: 2019-01-06 14:59
     * @param:
     * @param:
     * @return:
     */
    Object getHashValue(String key, String hashKey);

}
