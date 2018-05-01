package cn.tekin.java10.demo1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ticket_demo.html")
public class TicketDemo extends HttpServlet {
    //票数
    private int ticket = 2;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html:charset=utf-8");
        resp.setCharacterEncoding("utf-8");

        PrintWriter out = resp.getWriter();

        //线程安全问题解决
        synchronized (this) {

            if (ticket > 0) {
                out.println("你买到票了");
                System.out.println("你买到票了");
//                try {
//                    Thread.sleep(10 * 1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }

                ticket--;
            } else {
                out.println("你来晚了，票已经卖完");
                System.out.println("你来晚了，票已经卖完");
            }
        }

    }
}
