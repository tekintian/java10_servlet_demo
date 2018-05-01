package app.demo1;

/**
 * 计算测试
 */
public class Calculator {
    private static int result; // 静态变量，用于存储运行结果

    public void add(int n) {
        result = result + n;
    }

    public void substract(int n) {
        result = result - 1;  //Bug: 正确的应该是 result =result-n
    }

    /**
     * 没有括号的加减乘除运算
     * @param n
     */
    public void multiply(int n) {
        result = n + n - n * n / n ;
    }

    public void notComplete(int n){
        //没有完成的方法
    }

    public void divide(int n) {
        result = result / n;
    }

    public void square(int n) {
        result = n * n;
    }

    public void squareRoot(int n) {
        for (; ;) ;            //Bug : 死循环
    }

    public void clear() {     // 将结果清零
        result = 0;
    }

    /**
     * 返回存储的运算结果
     * @return int
     */
    public int getResult(){
        return result;
    }
}
