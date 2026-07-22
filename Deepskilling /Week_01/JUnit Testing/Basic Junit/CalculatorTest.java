import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void testAdd() {
        int result = calculator.sum(2, 5);
        assertEquals(8, result);
    }

    @Test
    public void testMultiply() {

        int result = calculator.multiply(5, 5);
        assertEquals(25, result);
    }

    @Test
    public void testAge() {
        int age = calculator.age(25);
        assertTrue(age > 15);
    }

    @Test
    public void testSalary() {
        int salary = calculator.Salary(25000);
        assertFalse(salary < 30000);
    }

    @Test
    public void testNull() {
        String result = calculator.name;
        assertNull(result);
    }

    @Test
    public void test2Null() {
        String result = calculator.name2;
        assertNull(result);
    }

    @Test
    public void testNotNull() {
        String name = calculator.name;
        assertNotNull(name);
    }

}