package cn.tekin.java10.demo1;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/helloworld.html")
public class HelloWorld extends HttpServlet {
    private String message;
    public int i = 0;
    private String name=null;

    @Override
    public void init() throws ServletException {

        System.out.println("servlet初始化……");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setCharacterEncoding("utf-8");
        //        设置响应内容类型
        resp.setContentType("text/html");
        this.name = req.getParameter("name");

        if (null != name) {
            String username = new String(name.getBytes("utf-8"),"utf-8");
            message = "Hello "+ username +" , Nice To Meet You: " + System.currentTimeMillis();
        } else {
            message = "Hello World , Nice To Meet You: " + System.currentTimeMillis();
        }



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
