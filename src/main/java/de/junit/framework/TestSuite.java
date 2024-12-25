package de.junit.framework;

import java.util.Enumeration;
import java.util.Vector;

public class TestSuite implements Test {

    private final Vector<Test> tests = new Vector<>();


    @Override
    public void run(TestResult result) {
        for (Enumeration e = tests.elements(); e.hasMoreElements(); ) {
            Test test= (Test)e.nextElement();
            test.run(result);
        }
    }

    public void addTest(Test test) {
        tests.addElement(test);
    }

    public void reportResults(TestResult result) {
        System.out.println("Tests run: " + result.getRunCount());
        System.out.println("Failures: " + result.getFailureCount());
        System.out.println("Errors: " + result.getErrorCount());
    }
}
