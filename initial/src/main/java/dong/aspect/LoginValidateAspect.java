package dong.aspect;

import dong.aop.LoginValidate;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @CopyRightBy zcy.qyg.cn
 * @ClassName LoginValidate
 * @Description    use AOP programming to validate how to use @annotation
 * @Author DongQing
 * @Date 2018-12-26 17:51
 **/
@Aspect
@Component
public class LoginValidateAspect {

    /**
     *
     * 功能描述: 使用自定义注解（@LoginValidate），定义切面
     *
     * @param:
     * @return:
     * @auther: dongQing
     * @date: 2018-12-26 19:13
     */
    @Around("@annotation(LoginValidate)")
    public Object validateUserAuth(ProceedingJoinPoint point, LoginValidate LoginValidate) {
        Object obj = null;
        System.out.println(" user authrity validate ");
        try {
            obj = point.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return obj;
    }
}
