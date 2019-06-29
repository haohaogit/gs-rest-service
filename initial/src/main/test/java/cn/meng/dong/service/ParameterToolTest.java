package dong.service;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * @CopyRightBy zcy.qyg.cn
 * @Author DongQing
 * @Date 2019-06-20 11:11
 * @ClassName ParameterToolTest
 * @Description TODO
 **/
public class ParameterToolTest {


    @Test
    public void assertTest() {
        String url = "www.taobao.com";
        assertThat(url, containsString("taobao"));
        assertFalse(1 > 2);
    }
}
