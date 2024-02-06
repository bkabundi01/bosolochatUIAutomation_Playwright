package Utilities;


import Base.BaseTestSetup;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Date;

import static Utilities.HelperMethods.takeScreenshot;


public class ExtentReportListener extends BaseTestSetup implements ITestListener, ISuiteListener{

    private static final String OUTPUT_FOLDER = "src/test/resources/Reports";
    private static final String FILE_NAME = "/TestExecutableReport_" + currentDateTime + ".html";

    private static final ExtentReports extent = init();
//    public static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();
    private static ExtentReports extentReports;

    private static ExtentReports init() {
        Path path = Paths.get(OUTPUT_FOLDER);
        //to see whether the directory exists
        if (!Files.exists(path)) {
            try {
                Files.createDirectories(path);
            } catch (IOException ioException) {
                System.out.println("Error in Creating the directory");
                ioException.printStackTrace();
            }
        }

        extentReports = new ExtentReports();
        //saving the report to the correct directory
        ExtentSparkReporter reporter = new ExtentSparkReporter(OUTPUT_FOLDER + FILE_NAME);
        reporter.config().setReportName("BosoloChat Web Automation Report Results");
        reporter.config().setTheme(Theme.DARK);
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("System", "MacOS");
        extentReports.setSystemInfo("Author", "Ben Thisuaka");
        extentReports.setSystemInfo("Build Number", "1.1");
        extentReports.setSystemInfo("Team", "Automation Team");
        extentReports.setSystemInfo("Client Name", "BosoloChat");

        return extentReports;
    }

    @Override
    public synchronized void onStart(ITestContext context) {
        System.out.println("Test Suite Has Started" +
                "\n-----------------------");
    }

    @Override
    public synchronized void onFinish(ITestContext context) {
        System.out.println("Test Suite Has Ended");
        extent.flush();
        test.remove();
    }

    @Override
    public synchronized void onTestStart(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        String qualifiedName = result.getMethod().getQualifiedName();
        int last = qualifiedName.lastIndexOf(".");
        int mid = qualifiedName.substring(0, last).lastIndexOf(".");
        String className = qualifiedName.substring(mid + 1, last);

        System.out.println(methodName + " Has Started \n-------------------------");
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName(), result.getMethod().getDescription());

        extentTest.assignCategory(result.getTestContext().getSuite().getName());
        extentTest.assignCategory(className);
        test.set(extentTest);
        test.get().getModel().setStartTime(getTime(result.getStartMillis()));
    }

    @Override
    public synchronized void onTestSuccess(ITestResult result) {
        System.out.println((result.getMethod().getMethodName()) + " Has Passed \n-------------------------");
        test.get().pass("[ PASSED ]");
//        logConsoleOutput(result);
        test.get().getModel().setEndTime(getTime(result.getStartMillis()));
    }

    @Override
    public synchronized void onTestFailure(ITestResult result) {
        System.out.println((result.getMethod().getMethodName()) + " Has Failed \n--------------------");
        test.get().fail(result.getThrowable(),
                MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(result.getMethod().getMethodName() + "[ FAILED ]")).build());
    }

    @Override
    public synchronized void onTestSkipped(ITestResult result) {
        System.out.println(result.getMethod().getMethodName() + " Was Skipped \n-------------------------");
        test.get().skip(result.getThrowable(),
                MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(result.getMethod().getMethodName() + " Skipped")).build());
        test.get().getModel().setEndTime(getTime(result.getEndMillis()));
    }

    private String getConsoleOutputForTest(ITestResult result) {
        return "Console Output For Test: " + result.getName();
    }

    private void logConsoleOutput(ITestResult result) {
        String consoleOutput = getConsoleOutputForTest(result);

        test.get().pass(getConsoleOutputForTest(result));
    }

    private Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
    }
}
