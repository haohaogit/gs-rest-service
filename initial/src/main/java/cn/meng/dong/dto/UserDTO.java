package cn.meng.dong.dto;

import cn.meng.dong.domain.User;
import lombok.Data;

/**
 * @CopyRightBy zcy.qyg.cn
 * @Author DongQing
 * @Date 2019-06-29 17:25
 * @ClassName UserDTO
 * @Description TODO
 **/
@Data
public class UserDTO extends User {
    /**
     * 是否有女朋友
     */
    private Boolean hasGirl;
    /**
     * 女朋友姓名
     */
    private String girlName;
    /**
     * 女朋友年龄
     */
    private Integer girlAge;

}
