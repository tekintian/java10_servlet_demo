package cn.tekin.java10.demo1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Servlet implementation class CurrentDate
 */
@WebServlet("/CurrentDate")
public class CurrentDate extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public CurrentDate() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String title = "显示当前的日期和时间";
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("Y-m-d H:m:s  E a z");
        String mydate = df.format(date);
        String docType = "<!DOCTYPE html> \n";
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n" +
                "<h2 align=\"center\">" + date.toString() + "</h2>\n" +
                "<h2 align=\"center\">格式后的时间：" + mydate + "</h2>\n" +
                "</body></html>");

    }

}
