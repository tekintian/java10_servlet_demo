package app.demo1;

public class Hello {
    private String msg="";

    public String sayHello(String name) {
        this.msg = msg + name;
        return msg;
    }

    public void addBefore(String msg){
        this.msg=msg;
    }
    /**
     * clear
     * 清空msg
     */
    public void clear(){
        this.msg="";
    }
}
