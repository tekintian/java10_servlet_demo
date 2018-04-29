package cn.tekin.java10.demo1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

@WebServlet("/getcookie.html")
public class GetCookie extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取cookies 数组
        Cookie[] cookies = req.getCookies();

        //设置输入响应类型
        resp.setContentType("text/html;charset=utf-8");

        PrintWriter out = resp.getWriter();

        String title = "Cookie Read Demo";

        if( cookies != null ){
            out.println("<h2>已经设置的Cookie 名称和值</h2>");

            /*foreach 方式循环输出*/
            for (Cookie cval: cookies ) {
                out.print("名称：" + cval.getName( ) + "，");
                out.print("值：" +  URLDecoder.decode(cval.getValue(), "utf-8") +" <br/>");
            }
            /*for 方式循环输出*/
//            for (int i = 0; i < cookies.length; i++){
//                out.print("名称：" + cookies[i].getName( ) + "，");
//                out.print("值：" +  URLDecoder.decode(cookies[i].getValue(), "utf-8") +" <br/>");
//            }
            out.println("<BR><a href='DeleteCookie'>点此删除所有COOKIE</a>");
        }else{
            out.println(
                    "<h2 class=\"tutheader\">No Cookie founds</h2>");
        }
        out.println("</body>");
        out.println("</html>");


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //设置post请求交由 doGet处理
        doGet(req, resp);

    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
