package cn.meng.dong;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @CopyRight By zcy.qyg.cn
 * @ClassName dong.Application
 * @Description start class
 * @Author DongQing
 * @Date 2018-12-22 20:24
 **/
@MapperScan("cn.meng.dong.dao")
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

    }
}
