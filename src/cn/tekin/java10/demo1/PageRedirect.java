package cn.tekin.java10.demo1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/PageRedirect.html")
public class PageRedirect extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取需要跳转的URL
        String redirect_url = req.getParameter("url");
//设置默认跳转URL
        if (redirect_url == null) {
            redirect_url = "http://dev.yunnan.ws";
        }

        //302定向
        resp.setStatus(resp.SC_MOVED_TEMPORARILY);
        //采用header location 定向
        resp.setHeader("Location", redirect_url);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
