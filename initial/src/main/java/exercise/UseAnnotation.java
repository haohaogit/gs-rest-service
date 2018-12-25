package exercise;

import annotation.Mytest;

/**
 * @CopyRightBy zcy.qyg.cn
 * @ClassName UseAnnotation
 * @Description To try use the annotation that define by myself
 * @Author DongQing
 * @Date 2018-12-25 10:44
 **/
public class UseAnnotation {
    @Mytest(hello = "hello qiuli", world = "xincai")
    public void outPrintln() {
        System.out.println("i love you ");
    }
}
