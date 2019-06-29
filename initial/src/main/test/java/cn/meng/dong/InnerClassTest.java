package dong;

import lombok.extern.slf4j.Slf4j;

/**
 * @CopyRightBy zcy.qyg.cn
 * @Author DongQing
 * @Date 2019-06-24 20:33
 * @ClassName InnerClassTest
 * @Description TODO
 **/
@Slf4j
public class InnerClassTest {
    public static void main(String[] args){

        Inner inner = new Inner();
        inner.grade = "A";
        inner.name = "haohao";

        log.info("The Student's name is {}, and his grade is {}",inner.name,inner.grade);
    }

    public static class Inner{
        public String name;
        public String grade;
    }
}
