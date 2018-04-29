package cn.tekin.java10.demo1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/DeleteCookie")
public class DeleteCookie extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        Cookie[] cookies = req.getCookies();

        PrintWriter out = resp.getWriter();
        String site_url = (String) req.getServletContext().getInitParameter("site_url");

        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                cookies[i].setMaxAge(0);
                resp.addCookie(cookies[i]);
                out.println("已删除的 cookie：" + cookies[i].getName() + "<br>");
            }
        }else{
            out.println("暂时没有cookie信息，<a href="+ site_url +">点此放回首页</a><br>");
        }

    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
