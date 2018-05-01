package cn.tekin.java10.demo1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;
import java.util.Locale;

@WebServlet("/ReqServletDemo")
public class ReqServletDemo extends HttpServlet {

    /**
     * Constructor of the object.
     */
    public ReqServletDemo() {
        super();
    }

    /**
     * Destruction of the servlet. <br>
     */
    public void destroy() {
        super.destroy(); // Just puts "destroy" string in log
        // Put your code here
    }

    // 返回客户端浏览器接受的文件类型
    private String getAccept(String accept) {
        StringBuffer buffer = new StringBuffer();
        if (accept.contains("image/gif"))
            buffer.append("GIF文件，");
        if (accept.contains("image/x-xbitmap"))
            buffer.append("BMP文件，");
        if (accept.contains("image/jpeg"))
            buffer.append("JPG文件，");
        if (accept.contains("application/vnd.ms-execel"))
            buffer.append("EXCEL文件，");
        if (accept.contains("application/vnd.ms-powerpoint"))
            buffer.append("PPT文件，");
        if (accept.contains("application/vnd.msword"))
            buffer.append("Word文件，");
        return buffer.toString().replaceAll(", $", "");
    }

    // 返回客户端的语言环境
    private String getLocale(Locale locale) {
        if (Locale.SIMPLIFIED_CHINESE.equals(locale))
            return "简体中文";
        if (Locale.TRADITIONAL_CHINESE.equals(locale))
            return "繁体中文";
        if (Locale.ENGLISH.equals(locale))
            return "英文";
        if (Locale.JAPANESE.equals(locale))
            return "日文";
        return "未知语言环境";
    }

    // 返回IP地址对应的物理地址
    // private String getAddress(String ip){
    // return IpUtil.getIpAddress(ip);
    // }

    // 返回客户端浏览器信息
    private String getNavigatior(String userAgent) {
        if (userAgent.indexOf("TencentTraveler") > 0)
            return "腾讯浏览器";
        if (userAgent.indexOf("Maxthon") > 0)
            return "Maxthon浏览器";
        if (userAgent.indexOf("MyIE2") > 0)
            return "MyIE2浏览器";
        if (userAgent.indexOf("Firefox") > 0)
            return "Firefox浏览器";
        if (userAgent.indexOf("MSIE") > 0)
            return "IE浏览器";
        return "未知浏览器";
    }

    // 返回客户端操作系统
    private String getOS(String userAgent) {
        if (userAgent.indexOf("Windows NT 5.1") > 0)
            return "Windows XP";
        if (userAgent.indexOf("Windows 98") > 0)
            return "Windows 98";
        if (userAgent.indexOf("Windows NT 5.0") > 0)
            return "Windows 2000";
        if (userAgent.indexOf("Linux") > 0)
            return "Linux";
        if (userAgent.indexOf("Unix") > 0)
            return "Unix";
        return "未知";
    }

    /**
     * The doGet method of the servlet. <br>
     * <p>
     * This method is called when a form has its tag value method equals to get.
     *
     * @param request  the request send by the client to the server
     * @param response the response send by the server to the client
     * @throws ServletException if an error occurred
     * @throws IOException      if an error occurred
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");//文档类型为HTML

        String authType = request.getAuthType();
        String localAddr = request.getLocalAddr();//本地IP，服务器IP
        String localName = request.getLocalName();//本地名称，服务器名称
        int localPort = request.getLocalPort();//本地端口，Tomcat端口

        Locale locale = request.getLocale(); //用户的语言环境
        String contextPath = request.getContextPath();
        String method = request.getMethod();//get还是post
        String pathInfo = request.getPathInfo();
        String pathTranslated = request.getPathTranslated();
        String protocol = request.getProtocol(); //协议，这里指HTTP协议
        String queryString = request.getQueryString();//查询字符串，即？后面的字符串

        String remoteAddr = request.getRemoteAddr();//远程IP，客户端IP

        int port = request.getRemotePort();//远程端口，客户端端口
        String remoteUser = request.getRemoteUser();//远程用户
        String requestedSessionId = request.getRequestedSessionId();//客户端session的ID

        String requestURI = request.getRequestURI();//用户请求的URI
        StringBuffer requestURL = request.getRequestURL();//用户请求的URL

        String scheme = request.getScheme(); //协议头，这里为 http
        String serverName = request.getServerName();//服务器名称
        int serverPort = request.getServerPort();//服务器端口
        String servletPath = request.getServletPath();// servlet的路径
        Principal userPrincipal = request.getUserPrincipal();

        String accept = request.getHeader("accept");//浏览器支持的格式
        String referer = request.getHeader("referer");//从哪个页面单击到本页

        //user-agent 包括操作系统类型、版本号、浏览器类型、版本号
        String userAgent = request.getHeader("user-agent");
        String serverInfo = this.getServletContext().getServerInfo();

        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
        out.println("<HTML>");

        out.println("  <HEAD><TITLE>Request Servlet</TITLE></HEAD>");
        out.println(" <style>body, font, td, dic {font-size:12px; line-height:18px }</style>");
        out.println("  <BODY>");

        out.println("<b>您的IP为</b>" + remoteAddr + "<b>，位于</b>:空 "
                + "<b>； 您使用</b>" + getOS(userAgent) + "<b>操作系统</b>，"
                + getNavigatior(userAgent) + "<b>,您使用</b> " + getLocale(locale)
                + "。 <br/>");

        out.println("<b>服务器IP为</b>" + localAddr + "<b>，位于</b>:空 "
                + "<b>； 服务器使用</b>" + serverPort + "<b>端口，您的浏览器使用了</b>，" + port
                + "<b>端口访问本网页。</b><br/>");

        out.println("<b>服务器软件为</b>" + serverInfo + "<b>服务器名称为</b>  "
                + localName + "。<br/>");
        out.println("<b>您的浏览器接受</b>" + getAccept(accept) + "。<br/>");
        out.println("<b>您从</b>" + referer + "<b>访问到该页面。</br><br/>");
        out.println("<b>使用的协议为</b>" + protocol + "。<b>URL协议头</b>" + scheme
                + ",<b>服务器名称</b>" + serverName + ",<b>您访问的URI为</b>"
                + requestURI + "。<br/>");
        out.println("<b>该servlet的路径为</b>" + servletPath + ", <b>该servlet类名为</b>" + this.getClass().getName()
                + "。<br/>");
        out.println("<b>本应用程序在硬盘的根目录为</b>" + this.getServletContext().getRealPath("") + ", <b>网络的相对路径为</b>" + contextPath + "。<br/>");
        out.println("<br/>");
        out.println("<br/><br/><a href=" + requestURI + "> 单击刷新本页面</a>");
        out.println("  </BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();
    }

    /**
     * Initialization of the servlet. <br>
     *
     * @throws ServletException if an error occurs
     */
    public void init() throws ServletException {
        // Put your code here
    }
}