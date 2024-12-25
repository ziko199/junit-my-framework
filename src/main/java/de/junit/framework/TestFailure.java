package de.junit.framework;

public class TestFailure {

    protected Test fFailedTest;

    protected Throwable fThrownException;

    public TestFailure(Test fFailedTest, Throwable fThrownException) {
        this.fFailedTest = fFailedTest;
        this.fThrownException = fThrownException;
    }

    public Test getFailedTest() {
        return fFailedTest;
    }

    public Throwable getThrownException() {
        return fThrownException;
    }

    @Override
    public String toString() {
        return "Test Failure: " + fFailedTest + " - " + fThrownException.getMessage();
    }
}