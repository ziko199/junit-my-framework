package de.junit.framework;

import java.util.Vector;

public class TestResult extends Object {

    protected int fRunTests;

    protected final Vector<TestFailure> fFailures = new Vector<>();

    protected final Vector<TestFailure> fErrors = new Vector<>();

    public TestResult() {
        fRunTests= 0;
    }

    // And the TestResult has to keep track of the number of tests run:

    // We declare the TestResult method startTest as synchronized so that a single TestResult can collect the results
    // safely when the tests are run in different threads.
    public synchronized void startTest(Test test) {
        fRunTests++;
    }

    public synchronized void addError(Test test, Throwable t) {
        fErrors.addElement(new TestFailure(test, t));
    }

    public synchronized void addFailure(Test test, Throwable t) {
        fFailures.addElement(new TestFailure(test, t));
    }

    public int getRunCount() {
        return fRunTests;
    }

    public int getFailureCount() {
        return fFailures.size();
    }

    public int getErrorCount() {
        return fErrors.size();
    }

    public void printSummary() {
        System.out.println("Tests run: " + getRunCount());
        System.out.println("Failures: " + getFailureCount());
        System.out.println("Errors: " + getErrorCount());

        if (!fFailures.isEmpty()) {
            System.out.println("Failure details:");
            for (TestFailure failure : fFailures) {
                System.out.println(failure.getFailedTest() + ": " + failure.getThrownException());
            }
        }

        if (!fErrors.isEmpty()) {
            System.out.println("Error details:");
            for (TestFailure error : fErrors) {
                System.out.println(error.getFailedTest() + ": " + error.getThrownException());
            }
        }
    }
}
