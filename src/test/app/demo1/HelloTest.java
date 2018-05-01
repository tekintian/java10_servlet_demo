package app.demo1;

import org.junit.*;

public class HelloTest{

    private Hello myhello = new Hello() ; // 注入一个Hello对象

    @Before
    public void setUp() throws Exception {
        myhello.addBefore("Hello,");
    }

    @Test
    public void sayHello() {

        Assert.assertEquals("Hello,Tekin", myhello.sayHello("Tekin")); // 判断返回值是否正确
    }

    @Test
    public void sayHello2() {
        //错误测试
        Assert.assertEquals("Hello,Error", myhello.sayHello("Neo")); // 判断返回值是否正确
    }

    @After
    public void tearDown() {
        /*
         * 此方法运行每个单元测试后都会执行,
         * 主要用来和setUp对应,清理获取的资源
         */
        myhello.clear();
    }

    @AfterClass
    public static void destroy() {
        /*
         * 此方法会在运行所有单元测试后执行一次,
         * 通常用来释放资源,例如数据库连接,IO流等等
         */
    }
}