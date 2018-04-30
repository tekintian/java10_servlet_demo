package demo2;

public class AppDemo1 {
    public static void main(String[] ARGS) {
        Integer x = 9;
        System.out.println(x.compareTo(7));
        System.out.println(x.compareTo(9));
        System.out.println(x.compareTo(18));

        System.out.println("Tomcat9.04默认编码:" + java.nio.charset.Charset.defaultCharset());

    }
}
