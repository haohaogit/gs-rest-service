package dong.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @CopyRightBy zcy.qyg.cn
 * @AnnotationName LoginValidate
 * @Description TODO
 * @Author DongQing
 * @Date 2018-12-26 17:50
 **/
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginValidate {
}
