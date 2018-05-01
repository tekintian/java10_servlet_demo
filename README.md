# java10 Servlet 学习项目 Maven Junit
	java10 servlet demo  JAVA Servlet 学习项目， 没有技术含量，纯粹的新手学习的项目
	Maven 依赖管理，Junit 单元测试

## java foreach,  for 循环

### foreach
foreach语句是java5的新特征之一，在遍历数组、集合方面，foreach为开发人员提供了极大的方便。 
foreach语句是for语句的特殊简化版本，但是foreach语句并不能完全取代for语句，然而，任何的foreach语句都可以改写为for语句版本。 
foreach并不是一个关键字，习惯上将这种特殊的for语句格式称之为“foreach”语句。从英文字面意思理解foreach也就是“for 每一个”的意思。实际上也就是这个意思。 foreach的语句格式：for(元素类型t 元素变量x : 遍历对象obj){     引用了x的java语句;} 下面通过几个例子简单例子看看foreach是如何简化编程的。

1.首先增强for循环和iterator遍历的效果是一样的，也就说增强for循环的内部也就是调用iteratoer实现的，

但是增强for循环有些缺点，例如不能在增强循环里动态的删除集合内容。不能获取下标等。
2.ArrayList由于使用数组实现，因此下标明确，最好使用普通循环。
3.而对于LinkedList 由于获取一个元素，要从头开始向后找，因此建议使用增强for循环，也就是iterator。

    for(type var : arr) {
        //循环体
    }

- 示例
```java
List<String> list = new ArrayList<String>();
for(String item : list){
    System.out.println("循环元素：" + item);
}

int arr[] = {1,2,3};
//forecah写法
for (int i : arr) {
    System.out.println(i);
}
//普通for循环写法
for(int x=0;x<arr.length;x++){
   System.out.println(arr[x]);
}

//forecah 循环输出list
       List<String> list = new ArrayList<String>();
       list.add("1");
       list.add("2");
       list.add("3");

       for (String a : list) {
        System.out.println("a="+a);
       }

//foreach循环输出object
       Object s[] = list.toArray();
       for (Object x : s) {   
           if(x == "3"){
               break;
           }
           System.out.println(x);
        }  

//foreach输出二维数组
        public void testArray2() {   
             int arr2[][] = {{4, 3}, {1, 2}};   
              System.out.println("----3----foreach输出二维数组测试");   
             for (int x[] : arr2) {   
                 for (int e : x) {   
                      System.out.println(e); //逐个输出数组元素的值   
                  }   
              }   
          }
          
          

```

## Servlet json中文乱码问题 

	response.setCharacterEncoding("UTF-8");
	request.setCharacterEncoding("UTF-8");
	response.setContentType("application/json;charset=utf-8");
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

## JAVA Servlet 乱码问题解决方法

---
### 数据库入库乱码问题
- Servlet mysql 乱码示例代码

```java
//PS: 数据库连接不加  characterEncoding=utf8  则，入库的数据全部是问号  加了 characterEncoding=utf8 则是乱码
String DB_URL = "jdbc:mysql://localhost:3306/java_demo?characterEncoding=utf8&useSSL=false";

response.setContentType("text/html;charset=utf-8");
response.setCharacterEncoding("utf-8");
request.setCharacterEncoding("utf-8");

PrintWriter out = response.getWriter();

.....


```

上面代码在控制台打印出来的入库时候的数据是正常的，当是入库后且是乱码或者问号

- Servlet mysql入库乱码解决方法

```java
String DB_URL = "jdbc:mysql://localhost:3306/java_demo?characterEncoding=utf8&useSSL=false";
response.setContentType("text/html;charset=utf-8");
request.setCharacterEncoding("UTF-8");

PrintWriter out = response.getWriter();

.....

```

删除 response 的UTF-8编码设置后入库的数据正常。


-  MySQL 5.5.45+,requirements SSL connection must be established 。。。解决方法
在jdbc连接参数上面添加  useSSL=false
```java
String DB_URL = "jdbc:mysql://localhost:3306/java_demo?characterEncoding=utf8&useSSL=false";

```
### 其他乱码问题
1. 老版本的 tomcat:默认是ISO8859-1，不支持中文的，在获取request 的中文输入的时候需要使用 getBytes("UTF-8") 方法转换；
    ```java
    String name = new String(request.getParameter("name").getBytes("ISO8859-1"),"utf-8");
    ```
2. 查看tomcat的默认字符集编码方法： java.nio.charset.Charset.defaultCharset() ， 如果非UTF-8则需要使用上面的方法将默认的ISO8859-1转换为utf-8

3. 浏览器调用jsp，html等页面中文显示乱码
    ```text
        此情况需满足两个要求：
        （1）文件本身是以utf-8编辑保存的（myEclipse中在properties中鼠标右键选择utf-8）
        （2）浏览器用utf-8解析：
        (手动)==> 在浏览器中右键选择编码格式为utf-8
        (智能)==> 在文件中写入如： <meta name="content-type" content="text/html; charset=UTF-8"> 
        通过<meta>标签模拟response头，起到告诉浏览器用utf-8的编码解析
        (智能)==> response.setContentType("text/html;charset=UTF-8");
        起到告诉浏览器用utf-8的编码解析
        常用：
        <meta name="content-type" content="text/html; charset=UTF-8">或<meta charset="utf-8">
        <%@ pageEncoding="utf-8"%>
        <?xml encoding="UTF-8"?>
    ```

4. 通过浏览器调用servlet，页面显示乱码。
    Servlet乱码分为request乱码和response乱码；

5. response乱码问题 解决方法：
    ```text
    在网上很有效的解决方法是添加：
    
    response.setContentType("text/html;charset=utf-8");
    response.setCharacterEncoding("UTF-8");
    
    或者 response.setHeader("content-type","text/html;charset=UTF-8");
    
    告诉浏览器用utf-8解析。(setHeader是HttpServletResponse的方法。如果想在拦截器Filter中设置字符编码，则无此方法，因为Filter的doFilter方法的参数类型是ServletResponse)
    
    response.setContentType("text/html;charset=UTF-8"); 目的是为了告诉浏览器输出的内容和输出使用的编码，即控制浏览器用UTF-8进行解码；
    response.setCharacterEncoding("UTF-8");目的是用于response.getWriter()输出的字符流的乱码问题。如果是response.getOutputStream()是不需要此种解决方案的，因为这句话的意思是为了将response对象中的数据以UTF-8解码后的字节流发向浏览器；
    
    ```
6. request乱码问题

    使用：request.setCharacterEncoding("utf-8")
    如果无法解决，则需要查看tomcat的版本以及默认编码 

    //查看tomcat编码方法
    java.nio.charset.Charset.defaultCharset()
    //解决方法
    String usernameString = new String(username.getBytes("ISO-8859-1"),"UTF-8"); 

7. properties文件乱码

    问题描述：在使用一些类库或者框架时，为了实现页面内容国际化，需要编写对应的properties文件。而properties文件中的中文内容在显示的时候也会出现乱码。
    
    解决方法：这个乱码问题可以通过jdk中的native2ascii工具解决。使用如下命令：
    
    native2ascii   -encoding   utf-8  display.properties    display_zh_CN.properties
    
    出现乱码问题的原因是因为java编译器只能处理Latin-1或unicode编码的字符文件。




