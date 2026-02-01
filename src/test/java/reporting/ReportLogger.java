package reporting;

public class ReportLogger {

    public static void info(String message) {
        ExtentTestListener.getTest().info(message);
    }

    public static void pass(String message) {
        ExtentTestListener.getTest().pass(message);
    }

    public static void fail(String message) {
        ExtentTestListener.getTest().fail(message);
    }
}
