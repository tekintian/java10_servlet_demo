package cn.tekin.java10.demo1;

//导入必需的 java 库
import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

//实现 Filter 类
public class LogFilter implements Filter  {
    private String mysite;
    public void  init(FilterConfig config) throws ServletException {

        // 获取初始化参数
        this.mysite = config.getInitParameter("mysite");

        // 输出初始化参数
        System.out.println("网站名称: " + mysite);
    }
//    public void  doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws java.io.IOException, ServletException {
//
//        // 输出站点名称
//        System.out.println("网址：http://dev.yunnan.ws");
//
//        // 把请求传回过滤链
//        chain.doFilter(request,response);
//    }

    public void doFilter(ServletRequest req, ServletResponse resp,
                         FilterChain chain) throws IOException, ServletException {

        //获取请求信息(测试时可以通过get方式在URL中添加name)
        //http://localhost:8080/servlet_demo/helloword?name=123
        String name = req.getParameter("name");

        // 过滤器核心代码逻辑
        System.out.println("过滤器获取请求参数:"+name);
        System.out.println("第二个过滤器执行--网站名称："+this.mysite);

        if ("tekin".equals(name)){
            // 把请求传回过滤链
            chain.doFilter(req,resp);

        }else {
            //设置返回内容类型
            resp.setContentType("text/html;charset=utf-8");

            //在页面输出响应信息
            PrintWriter out = resp.getWriter();
            out.println("name不正确，请求被拦截，不能访问web资源</b>");

            //在控制台输出
            System.out.println("用户名不正确，访问被拦截");
        }
//        if("123".equals(name)){
//            // 把请求传回过滤链
//            chain.doFilter(req, resp);
//        }else{
//            //设置返回内容类型
//            resp.setContentType("text/html;charset=GBK");
//
//            //在页面输出响应信息
//            PrintWriter out = resp.getWriter();
//            out.print("<b>name不正确，请求被拦截，不能访问web资源</b>");
//            System.out.println("name不正确，请求被拦截，不能访问web资源");
//        }
    }
    public void destroy( ){
        /* 在 Filter 实例被 Web 容器从服务移除之前调用 */
    }
}
