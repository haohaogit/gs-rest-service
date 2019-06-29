package cn.meng.dong.spi.impl;

import cn.meng.dong.spi.HelloInterface;

/**
 * @CopyRightBy zcy.qyg.cn
 * @ClassName ImageHello
 * @Description Test SPI.
 * @Author DongQing
 * @Date 2018-12-28 16:58
 **/
public class ImageHello implements HelloInterface {
    @Override
    public void sayHello() {
        System.out.println("Image Hello China!");

    }
}
