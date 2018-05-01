package cn.tekin.java10.demo1;

//导入必需的 java 库

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

//实现 Filter 类
public class LogFilter implements Filter {
    private String mysite;

    public void init(FilterConfig config) throws ServletException {

        // 获取初始化参数
        this.mysite = config.getInitParameter("mysite");

        // 输出初始化参数
        System.out.println("网站名称: " + mysite);

    }


    public void doFilter(ServletRequest req, ServletResponse resp,
                         FilterChain chain) throws IOException, ServletException {

       resp.setContentType("text/html;charset=utf-8");
//        resp.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");
        //获取请求信息(测试时可以通过get方式在URL中添加name)
        //http://localhost:8090/java10_demo1/readallparams.html?name=tekin
        String name = req.getParameter("name");

        // 过滤器核心代码逻辑
        System.out.println("过滤器获取请求参数:" + name);
        System.out.println("第二个过滤器执行--网站名称：" + this.mysite);

        //在页面输出响应信息
        PrintWriter out = resp.getWriter();

//        if (null == name) {
//            out.println("缺少参数 name ，请求被拦截，请重试</b>");
//            //在控制台输出
//            System.out.println("缺少参数 name。用户名不正确，访问被拦截");
//        } else {
//            switch (name) {
//
//                case "tekin":
//                    // 把请求传回过滤链
//                    chain.doFilter(req, resp);
//                    break;
//                default:
//                    out.println("参数 name：" + name + " 不正确，请求被拦截，请重试</b>");
//                    //在控制台输出
//                    System.out.println("用户名:" + name + "不正确，访问被拦截");
//                    break;
//
//            }
//        }

        if ("tekin".equals(name)){
            // 把请求传回过滤链
            chain.doFilter(req,resp);
        }else if(null == name) { //name 为空的情况
            out.println("缺少参数 name ，请求被拦截，请重试</b>");
            //在控制台输出
            System.out.println("缺少参数 name。用户名不正确，访问被拦截");
        }else{
            out.println("参数 name："+ name +" 不正确，请求被拦截，请重试</b>");
            //在控制台输出
            System.out.println("用户名:"+ name +"不正确，访问被拦截");
        }

    }

    public void destroy() {
        /* 在 Filter 实例被 Web 容器从服务移除之前调用 */
    }
}
