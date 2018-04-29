# java10_servlet_demo JAVA Servlet 学习项目
java10 servlet demo  JAVA Servlet 学习项目， 没有技术含量，纯粹的新手学习的项目

## 中文乱码问题 ##

	resp.setCharacterEncoding("UTF-8");
	req.setCharacterEncoding("UTF-8");
	resp.setContentType("application/json;charset=utf-8");
	PrintWriter out = resp.getWriter();

一定要注意顺序， 编码设置一定要在  PrintWriter 对象创建 之前，否则无效！


## Servlet返回JSON格式数据

Servlet返回JSON格式的数据 
代码：
```java
	response.setCharacterEncoding("UTF-8");
	response.setContentType("application/json; charset=utf-8");
	String jsonStr = "{\"status\":\"success\",\"site_url\":\"http://localhost\",\"site_name\":\"云南网\"}";
	PrintWriter out = null;
	try {
	    out = response.getWriter();
	    out.write(jsonStr);
	} catch (IOException e) {
	    e.printStackTrace();
	} finally {
	    if (out != null) {
	        out.close();
	    }
	}
```



