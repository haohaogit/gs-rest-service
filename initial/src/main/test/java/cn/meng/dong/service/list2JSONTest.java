package dong.service;

import java.util.ArrayList;
import java.util.List;

/**
 * @CopyRightBy zcy.qyg.cn
 * @Author DongQing
 * @Date 2019-06-14 16:01
 * @ClassName list2JSONTest
 * @Description TODO
 **/
public class list2JSONTest {

    public static void main(String[] args){
        List<Long> longList = new ArrayList<>();
        longList.add((long)2);
        longList.add((long)4);
        longList.add((long)5);
        longList.add((long)6);

        System.out.println(longList.toString());

    }
}
