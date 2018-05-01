package cn.tekin.java10.demo1;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NetCheckTest {

    //定义测试的对象
    private NetCheck mynet;

    /**
     * 在测试函数执行执行之前执行的操作
     */
    @Before
    public void before(){
        mynet = new NetCheck();
        System.out.println("测试开始...");
    }

    /**
     * 测试用例
     */
    @Test
    public void isOk() {
        //未通过测试时提示信息：
        Assert.assertEquals("你没有联网！",true,mynet.pingLink());
    }

    /**
     * 在测试函数执行之后执行的操作
     */
    @After
    public void after(){
        System.out.println("测试结束");
    }
}
