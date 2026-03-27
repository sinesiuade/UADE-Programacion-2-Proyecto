package test;

import java.util.ArrayList;
import java.util.List;

public class Test implements I_Test {
    private int passed = 0;
    private int failed = 0;

    public void assertEquals(String nombreTest, Object expected, Object actual) {
        if ((expected == null && actual == null) ||
                (expected != null && expected.equals(actual))) {
            this.passed++;
            printTest(nombreTest, true, expected, actual);
        } else {
            this.failed++;
            printTest(nombreTest, false, expected, actual);
        }
    }

    public void assertNotEquals(String nombreTest, Object expected, Object actual) {
        if ((expected == null && actual == null) ||
                (expected != null && !expected.equals(actual))) {
            this.passed++;
            printTest(nombreTest, true, expected, actual);
        } else {
            this.failed++;
            printTest(nombreTest, false, expected, actual);
        }
    }

    public void assertError(String nombreTest, String error, Runnable testFunc) {
        try {
            testFunc.run();
            failed++;
            printTest(nombreTest, false, error, " no error thrown");
        } catch (Exception e) {
            if (e.getMessage().contains(error)) {
                passed++;
            } else {
                failed++;
                printTest(nombreTest, false, error, e.getMessage());
            }
        }
    }

    public void printScore() {
        String color = "";
        String resultado = "";

        if (this.failed == 0) {
            color = Colors.GREEN;
            resultado = "All tests passed!";
        } else if (this.passed == 0) {
            color = Colors.RED;
            resultado = "All tests failed!";
        } else {
            color = Colors.YELLOW;
            resultado = "Some tests failed!";
        }

        System.out.println(Colors.BLUE + "---- TEST RESULTS ----" + Colors.RESET);
        System.out.println("Passed: " + this.passed + "\n" + "Failed: " + this.failed);
        System.out.println(color + resultado + Colors.RESET);
        System.out.println(Colors.BLUE + "----------------------" + Colors.RESET);
    }

    private void printTest(String nombreTest, boolean passed, Object expected, Object actual) {
        String color = passed ? Colors.GREEN : Colors.RED;
        System.out.println(color + nombreTest + Colors.RESET +
                " | expected: " + expected +
                " but got: " + actual + ".");
    }
}
