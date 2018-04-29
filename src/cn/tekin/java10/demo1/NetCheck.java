package cn.tekin.java10.demo1;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class NetCheck extends HttpServlet {

    private static final long serialVersionUID = 1194662230797153372L;

    public void init() throws ServletException {
        boolean bool = pingLink();
        // 取得Application对象
        ServletContext application = this.getServletContext();
        // 设置Application属性
        application.setAttribute("bool", bool);
    }

    public boolean pingLink(){
        boolean bool = true;
        Runtime runtime = Runtime.getRuntime(); // 获取当前程序的运行进对象
        Process process = null; // 声明处理类对象
        String line = null; // 返回行信息
        InputStream is = null; // 输入流
        InputStreamReader isr = null; // 字节流
        BufferedReader br = null;
        String ip = "www.baidu.com";
        boolean res = false;// 结果
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
            } else {
                bool = false;
//             Log.print("ping www.baidu.com不通...无法连接外网");
            }
        } catch (IOException e) {
//            Log.print(e.getMessage());
        }
        return bool;
    }
}
