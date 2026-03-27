package test;

public interface I_Test {
    void assertEquals(String nombreTest, Object expected, Object actual);

    void assertNotEquals(String nombreTest, Object expected, Object actual);

    void assertError(String nombreTest, String error, Runnable testFunc);

    void printScore();
}
