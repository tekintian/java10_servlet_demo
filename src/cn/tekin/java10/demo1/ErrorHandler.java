package cn.tekin.java10.demo1;

//导入必需的 java 库
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.util.*;

//扩展 HttpServlet 类
@WebServlet("/errorhandler.html")
public class ErrorHandler extends HttpServlet {

    // 处理 GET 方法请求的方法
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Throwable throwable = (Throwable)
                request.getAttribute("javax.servlet.error.exception");
        Integer statusCode = (Integer)
                request.getAttribute("javax.servlet.error.status_code");
        String servletName = (String)
                request.getAttribute("javax.servlet.error.servlet_name");
        if (servletName == null){
            servletName = "Unknown";
        }
        String requestUri = (String)
                request.getAttribute("javax.servlet.error.request_uri");
        if (requestUri == null){
            requestUri = "Unknown";
        }

        //get scheme
        String reqscheme = request.getScheme();

        //get servername+serverport
//        String reqhost = (String)request.getServerName();
//        Integer reqport = (Integer) request.getServerPort();
        //get scheme
        String scheme = request.getScheme();
        // 获取HOST名称，包括PORT
        String host = request.getHeader("host");

        //获取网站部署路径
        String cpath = (String) request.getContextPath();


//        String req_home = reqscheme+"://"+reqhost+":"+reqport+cpath;
        String req_home = scheme+"://"+host+cpath;

        // 设置响应内容类型
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        String title = "云南JAVA开发教程 Error/Exception 信息";

        String docType = "<!DOCTYPE html>\n";
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n");
        out.println("<h1>云南JAVA开发教程异常信息实例演示</h1>");
        if (throwable == null && statusCode == null){
            out.println("<h2>错误信息丢失</h2>");
            out.println("请返回 <a href=\"" +
                    response.encodeURL(req_home) +
                    "\">主页</a>。");
            out.println("Host:"+host);
        }else if (statusCode != null) {
            out.println("错误代码 : " + statusCode + "\n");
            out.println("<br>请求URI : " + requestUri + " \n\r");
            out.println("<br>请返回 <a href=\"" +
                    response.encodeURL(req_home) +
                    "\">主页</a>。");
            out.println("<BR><hr>By ErrorHandler");
            out.println("<br>");
            out.println("异常信息: " + throwable.getMessage( ));
        }else{
            out.println("<h2>错误信息</h2>");
            out.println("Servlet Name : " + servletName +
                    "</br></br>");
            out.println("异常类型 : " +
                    throwable.getClass( ).getName( ) +
                    "</br></br>");
            out.println("请求 URI: " + requestUri +
                    "<br><br>");
            out.println("异常信息: " +
                    throwable.getMessage( ));
        }
        out.println("</body>");
        out.println("</html>");
    }
    // 处理 POST 方法请求的方法
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
