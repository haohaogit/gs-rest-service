package cn.meng.dong.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
 * @Description: to test how to define and use dong.annotations
 * @Annotation Function: this demo is validate the legality of user name;
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidateName {
}
