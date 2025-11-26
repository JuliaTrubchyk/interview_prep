import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTests {
    @Test
    public void addTest(){
        Calculator calculator = new Calculator();
        int result = calculator.add(5, 3);
        Assertions.assertEquals(8, result);
    }

    @Test
    public void subtractTest(){
        Calculator calculator = new Calculator();
        int result = calculator.subtract(8, 5);
        Assertions.assertEquals(3, result);
    }
}
