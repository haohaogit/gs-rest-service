import dong.annotations.Mytest;
import dong.exercise.AspectTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.lang.reflect.Method;

/**
 * @CopyRightBy zcy.qyg.cn
 * @ClassName AOPTest
 * @Description TODO
 * @Author DongQing
 * @Date 2018-12-25 15:51
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootConfiguration
public class AOPTest {
    private static String astr= "AopTest ";


    @Test
    public void aopTest1() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        //AspectTest aopTest = new AspectTest();
        Class className = Class.forName("dong.exercise.AspectTest");

        AspectTest aspectTest = (AspectTest) className.newInstance();
        aspectTest.printInfo();
        //useAnnotation.outPrintln();


        // 根据类名 获取 类指定的方法
        Method methods = className.getMethod("printInfo", new Class[]{});


        if (methods.isAnnotationPresent(Mytest.class)) {
            Mytest myAnnotation = methods.getAnnotation(Mytest.class);
            System.out.println(myAnnotation.hello());
            System.out.println(myAnnotation.world());
        }

        //aopTest.printInfo();
    }

    @Test
    public void AopTest() {
        AspectTest aspectTest = new AspectTest();
        aspectTest.printInfo();
    }
}
