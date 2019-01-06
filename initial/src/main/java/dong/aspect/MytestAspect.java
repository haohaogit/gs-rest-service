package dong.aspect;

import dong.annotations.Mytest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @CopyRightBy zcy.qyg.cn
 * @ClassName MytestAspect
 * @Description TODO
 * @Author DongQing
 * @Date 2018-12-25 14:45
 **/
@Component
@Aspect
@Slf4j
public class MytestAspect {



    @Around(value = "@annotation(Mytest)")
    //@Around(value = "@dong.annotations(SubscriberAuth)")
    public Object aspectTest(ProceedingJoinPoint point, Mytest Mytest) throws Throwable {
        //System.out.println(mytest.dong.hello());
        log.info("Around 环绕通知： "+point.getSignature().toLongString());

        System.out.println("******** Aspect programming test");
        return point.proceed();
        //System.out.println("******** Aspect programming test1111111");
    }
}
