# java10_servlet_demo JAVA Servlet ѧϰ��Ŀ
java10 servlet demo  JAVA Servlet ѧϰ��Ŀ�� û�м������������������ѧϰ����Ŀ

## ������������ ##

	resp.setCharacterEncoding("UTF-8");
	req.setCharacterEncoding("UTF-8");
	resp.setContentType("application/json;charset=utf-8");
	PrintWriter out = resp.getWriter();

һ��Ҫע��˳�� ��������һ��Ҫ��  PrintWriter ���󴴽� ֮ǰ��������Ч��


## Servlet����JSON��ʽ����

Servlet����JSON��ʽ������ 
���룺
```java
	response.setCharacterEncoding("UTF-8");
	response.setContentType("application/json; charset=utf-8");
	String jsonStr = "{\"status\":\"success\",\"site_url\":\"http://localhost\",\"site_name\":\"������\"}";
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



