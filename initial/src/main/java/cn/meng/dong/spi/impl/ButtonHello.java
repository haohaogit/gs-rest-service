package cn.meng.dong.spi.impl;

import cn.meng.dong.spi.HelloInterface;

/**
 * @CopyRightBy zcy.qyg.cn
 * @Author DongQing
 * @Date 2019-05-28 18:03
 * @ClassName ButtonHello
 * @Description TODO
 **/
public class ButtonHello implements HelloInterface {
    @Override
    public void sayHello() {
        System.out.println("button hello cai_inc");
    }
}
