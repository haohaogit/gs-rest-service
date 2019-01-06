package dong.spi.impl;

import dong.spi.HelloInterface;

/**
 * @CopyRightBy zcy.qyg.cn
 * @ClassName textHello
 * @Description Test SPI .  to implements interface
 * @Author DongQing
 * @Date 2018-12-28 16:57
 **/
public class textHello implements HelloInterface {
    @Override
    public void sayHello() {
        System.out.println("text Hello World!");

    }
}
