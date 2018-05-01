//定义包名，最好与需要测试的对象的包名一致，这样不用 import
package app.demo1;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    private static Calculator calculator;

    @Before
    public void setUp() throws Exception {
        //创建需要测试的对象
        calculator = new Calculator();

        //将返回值归0
        calculator.clear();
    }

    @Test
    public void testAdd() {
        calculator.add(3);
        calculator.add(4);
        assertEquals(7, calculator.getResult());

    }

    @Test
    public void testSubstract() {
        calculator.add(8);
        calculator.substract(3);
        assertEquals(5, calculator.getResult());

    }

    @Test
    public void testMultiply() {
        calculator.multiply(2);
        assertEquals(2,calculator.getResult());
    }

    @Ignore("notComplete() Not yet implemented")
    @Test
    public void notComplete() {
        fail("Not yet implemented");
    }
    @Test
    public void testDivide() {
        calculator.add(8);
        calculator.divide(2);
        assertEquals(4, calculator.getResult());

    }
}
