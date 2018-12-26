package dong.exercise;

import dong.annotations.Mytest;

/**
 * @CopyRightBy zcy.qyg.cn
 * @ClassName UseAnnotation
 * @Description To try use the dong.annotations that define by myself
 * @Author DongQing
 * @Date 2018-12-25 10:44
 **/
public class UseAnnotation {
    @Mytest(hello = "dong.hello qiuli", world = "xincai")
    public void outPrintln() {
        System.out.println("i love you ");
    }
}
