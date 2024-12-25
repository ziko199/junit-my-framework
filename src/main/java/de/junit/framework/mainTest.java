package de.junit.framework;

public class mainTest {

    public static void main(String[] args) {

        Test test = suite();
        System.out.println(test.toString());
        TestResult result = new TestResult();
        test.run(result);
        System.out.println(result);
        System.out.println(result.fRunTests);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite();
        suite.addTest(new MoneyTest("testMoneyEquals"));
        suite.addTest(new MoneyTest("testSimpleAdd"));
        return suite;
    }

}
