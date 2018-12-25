package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @CopyRightBy zcy.qyg.cn
 * @AnnotationName Mytest
 * @Description to test annotation parameter and reflect test
 * @Author DongQing
 * @Date 2018-12-25 10:39
 **/
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Mytest {
    String hello() default "hello haohao";
    String world();
}
