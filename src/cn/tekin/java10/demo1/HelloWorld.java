package cn.tekin.java10.demo1;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/helloworld.php")
public class HelloWorld extends HttpServlet {
    private String message;
    public int i = 0;

    @Override
    public void init() throws ServletException {


        System.out.println("servlet初始化……");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        message = "Hello World , Nice To Meet You: " + System.currentTimeMillis();
//        设置响应内容类型
        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();
        out.println("<h1>" + message + "</h1>");
        i++;
        System.out.println("我被访问了 " + i + " 次");

    }

    @Override
    public void destroy() {
        System.out.println("servlet销毁！");
        super.destroy();
    }
}
