package dong.dao;

import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @CopyRightBy zcy.qyg.cn
 * @Author DongQing
 * @Date 2019-01-06 10:56
 * @ClassName UserDAO
 * @Description TODO
 **/
@Data
@Component
public class UserDAO {
    public static final String table = "T_user";

    private String name;

    private String address;

    private Integer age;

    @Override
    public String toString() {
        return "UserDAO {" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                '}';
    }
}
