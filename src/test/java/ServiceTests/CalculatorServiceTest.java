package ServiceTests;

import com.example.calculator.Service.CalculatorService;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorServiceTest {

    CalculatorService tester=new CalculatorService();

    @Test
    public void operate() {


        assertEquals("12.0",tester.operate("5","7","+"));
        assertEquals("3.0",tester.operate("10","7","-"));
        assertEquals("23.0",tester.operate("46","2","/"));
        assertEquals("66.0",tester.operate("6","11","*"));

        assertEquals("-12.0",tester.operate("-5","-7","+"));
        assertEquals("12.0",tester.operate("5","-7","-"));
        assertEquals("5.0",tester.operate("-10","-2","/"));
        assertEquals("20.0",tester.operate("8","2.5","*"));

    }

    @Test
    public void format() {
        assertEquals("7.5",tester.format("7.5"));
        assertEquals("7",tester.format("7.0"));
        assertEquals("-7.5",tester.format("-7.5"));
        assertEquals("-7",tester.format("-7.0"));
        assertEquals("0",tester.format("0.0"));
        assertEquals("0.23",tester.format("0.23"));
    }
}