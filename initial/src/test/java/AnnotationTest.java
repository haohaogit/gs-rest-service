
import annotation.Mytest;
import ch.qos.logback.core.net.SyslogOutputStream;
import exercise.UseAnnotation;


import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @CopyRightBy zcy.qyg.cn
 * @ClassName AnnotationTest
 * @Description To test how to define and use annotation , and test reflect of annotation
 * @Author DongQing
 * @Date 2018-12-25 10:41
 **/
public class AnnotationTest {

    public static void main(String[] args) throws NoSuchMethodException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        // 通过反射 获取类的句柄
        Class className = Class.forName("exercise.UseAnnotation");

        UseAnnotation useAnnotation = (UseAnnotation) className.newInstance();
        useAnnotation.outPrintln();


        // 根据类名 获取 类指定的方法
        Method methods = className.getMethod("outPrintln", new Class[]{});


        if (methods.isAnnotationPresent(Mytest.class)) {
            Mytest myAnnotation = methods.getAnnotation(Mytest.class);
            System.out.println(myAnnotation.hello());
            System.out.println(myAnnotation.world());
        }

        // 获取所有 Runtime 类型的注解
        Annotation[] annotations = methods.getAnnotations();
        // 遍历所有注解的名字
        for (Annotation anno : annotations) {
            System.out.println(anno.annotationType().getName());
        }
    }

}
