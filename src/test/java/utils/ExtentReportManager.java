package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
	private static ExtentReports extent;
	private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

	public static void setUp() {
		// Initialize ExtentReports and attach a reporter
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(".\\target\\SparkReport\\ExtentReport\\Spark.html");
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
	}

	public static void createTest(String testName) {
		// Create a new test and assign it to the ThreadLocal instance
		ExtentTest extentTest = extent.createTest(testName);
		test.set(extentTest);
	}

	public static ExtentTest getTest() {
		// Return the ThreadLocal instance of ExtentTest
		return test.get();
	}

	public static void tearDown() {
		// Flush the reports
		extent.flush();
	}
}
