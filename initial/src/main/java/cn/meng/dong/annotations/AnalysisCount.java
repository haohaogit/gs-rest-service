package cn.meng.dong.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @CopyRightBy zcy.qyg.cn
 * @AnnotationName AnalysisCount
 * @Description TODO
 * @Author DongQing
 * @Date 2019-05-28 21:06
 **/
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AnalysisCount {
    String note() default "";
}
