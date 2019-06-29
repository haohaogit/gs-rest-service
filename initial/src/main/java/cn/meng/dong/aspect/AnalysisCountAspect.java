package cn.meng.dong.aspect;

import cn.meng.dong.annotations.AnalysisCount;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @CopyRightBy zcy.qyg.cn
 * @Author DongQing
 * @Date 2019-05-28 21:07
 * @ClassName AnalysisCountAspect
 * @Description TODO
 **/
@Aspect
@Component
@Slf4j
public class AnalysisCountAspect {
    Long beginTime = System.currentTimeMillis();


    @Pointcut("@annotation(analysisCount)")
    public void serviceStatistic(AnalysisCount analysisCount){

    }

    @Before("serviceStatistic(analysisCount)")
    public void beforeStatistic(AnalysisCount analysisCount){
        beginTime = System.currentTimeMillis();
        log.info("cy666 note:{}", analysisCount.note());
    }

    @After("serviceStatistic(analysisCount)")
    public void afterStatistic(AnalysisCount analysisCount){
        System.out.println("after serviceStatistic");
        log.info("cy666 statistic time {}, note:{}",System.currentTimeMillis()-beginTime,analysisCount.note());
    }

    @Around("serviceStatistic(analysisCount)")
    public String aroundStatistic(JoinPoint joinPoint,AnalysisCount analysisCount){
        ProceedingJoinPoint templatePoint = (ProceedingJoinPoint)joinPoint;

        try {
            Object object = templatePoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("around serviceStatistic");
        log.info("cy666 statistic time {}, note:{}",System.currentTimeMillis()-beginTime,analysisCount.note());
        return "around test";
    }


}
