package de.junit.framework;

public class CalcTest extends TestCase {

    private Calculator calculator;

    protected CalcTest(String fName) {
        super(fName);
    }

    public void setUp(){
        calculator = new Calculator();
    }

    public void addNumbers() {
        System.out.println("call addNumbers");
        int result = calculator.add(40,2);
        System.out.println(result);

    }

    public void multiplyNumbers() {
        calculator.multiply(40,2);
    }

    public void divideNumbers() {
        System.out.println("call divideNumbers");

        calculator.divide(40,0);
    }
}
