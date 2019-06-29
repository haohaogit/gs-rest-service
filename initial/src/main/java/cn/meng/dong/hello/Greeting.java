package cn.meng.dong.hello;

/**
 * @CopyRight By zcy.qyg.cn
 * @ClassName Greeting
 * @Description TODO
 * @Author DongQing
 * @Date 2018-12-22 20:21
 **/
public class Greeting {
    private final long id;
    private final String content;

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
