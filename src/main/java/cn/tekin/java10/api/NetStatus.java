package cn.tekin.java10.api;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/api/NetStatus")
public class NetStatus extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Runtime runtime = Runtime.getRuntime(); // 获取当前程序的运行进对象
        Process process = null; // 声明处理类对象
        String line = null; // 返回行信息
        InputStream is = null; // 输入流
        InputStreamReader isr = null; // 字节流
        BufferedReader br = null;
        String ip = "www.baidu.com";
        boolean res = false;// 结果
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter out = resp.getWriter();

        try {
            process = runtime.exec("ping " + ip); // PING
            is = process.getInputStream(); // 实例化输入流
            isr = new InputStreamReader(is);// 把输入流转换成字节流
            br = new BufferedReader(isr);// 从字节中读取文本
            while ((line = br.readLine()) != null) {
                if (line.contains("TTL")) {
                    res = true;
                    break;
                }
            }
            is.close();
            isr.close();
            br.close();
            if (res) {
//             Log.print("ping www.baidu.com通...已经连接外网");
                String data = "{\"status\":1,\"desc\":\"恭喜，你成功連接互聯網\"}";
                out.write(data);
            } else {

//             Log.print("ping www.baidu.com不通...无法连接外网");
                String data = "{\"status\":0,\"desc\":\"Sorry，你的网络未连接！请检查！\"}";
                out.write(data);
            }

            out.close();


        } catch (IOException e) {
//            Log.print(e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
