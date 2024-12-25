package de.junit.framework;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// Because we expect this class to be reused through inheritance, we declare it "public abstract".
public abstract class TestCase implements Test {

    // Every TestCase is created with a name, so if a test fails, you can identify which test failed.
    private final String fName;

    protected TestCase(String fName) {
        this.fName = fName;
    }

    public TestResult run() {
        TestResult result = createResult();
        run(result);
        return result;
    }

    protected TestResult createResult() {
        return new TestResult();
    }

    // We want the developer to be able to separately consider how to write the fixture (set up and tear down) code and
    // how to write the testing code. The execution of this sequence, however, will remain the same for all tests,
    // no matter how the fixture code is written or how the testing code is written.
    // template method:
    public void run(TestResult result) {
        // Add a parameter to the TestCase.run() method and notify the TestResult that the test is running
        result.startTest(this);
        setUp();

        try {
            runTest();
        } catch (AssertionFailedError e) { //1
            result.addFailure(this, e);
        }
        catch (Throwable e) { // 2
            result.addError(this, e);
        }
        finally {
            tearDown();
        }
    }

    // Since runTest is intended to be overridden but will be called by the framework we declare it as protected.
    protected void runTest() {
        Method runMethod = null;
        try {
            runMethod = getClass().getMethod(fName, new Class[0]);
        } catch (NoSuchMethodException e) {
            throw new IllegalArgumentException("Test method \"" + fName + "\" not found.");
        }
        try {
            runMethod.invoke(this, new Class[0]);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    // Since setUp is intended to be overridden but will be called by the framework we declare it as protected.
    protected void setUp() {
    }

    // Since tearDown is intended to be overridden but will be called by the framework we declare it as protected.
    protected void tearDown() {
    }


    protected void assertEquals(Object expected, Object actual) {
        if (!expected.equals(actual)) {
            throw new AssertionFailedError("Expected: " + expected + ", but got: " + actual);
        }
    }

    protected void assertTrue(boolean condition) {
        if (!condition) {
            throw new AssertionFailedError("Condition is not true.");
        }
    }

    protected void assertFalse(boolean condition) {
        if (condition) {
            throw new AssertionFailedError("Condition is not false.");
        }
    }
}
