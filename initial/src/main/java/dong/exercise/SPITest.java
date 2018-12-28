package dong.exercise;

import dong.spi.HelloInterface;

import java.util.ServiceLoader;

/**
 * @CopyRightBy zcy.qyg.cn
 * @ClassName SPITest
 * @Description TO test SPI function
 * @Author DongQing
 * @Date 2018-12-28 17:02
 **/
public class SPITest {
    public static void main(String[] args) {
        ServiceLoader<HelloInterface> serviceLoader = ServiceLoader.load(HelloInterface.class);
        System.out.println("SPI test");
        for (HelloInterface in: serviceLoader) {
            in.sayHello();
        }
    }
}
