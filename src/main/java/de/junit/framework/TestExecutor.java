package de.junit.framework;

public class TestExecutor {

    public static void main(String[] args) {

        CalcTest test = new CalcTest("addNumbers");
        test.run();

        CalcTest test2 = new CalcTest("divideNumbers");

        TestResult result = new TestResult();
        test2.run(result);
        result.printSummary();
    }
}
