package com.newtours.utilities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.xml.XmlSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This Class is used to implement <b>Test NG Listeners</b> using CSV files.
 * 
 * @author Sujay Sawant
 * @version 1.0.3
 * @since 12/14/2019
 */
public class MyListeners implements ITestListener, ISuiteListener, IReporter {

	private ExtentReports extent;
	private String failedScreenshot;

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Execution of the test " + result.getName() + " started");
		Reporter.log("Execution of the test " + result.getName() + " started<br>");
	}

	@Override
	public void onTestSuccess(ITestResult result) {

	}

	@Override
	public void onTestFailure(ITestResult result) {
		failedScreenshot = ScreenShot.takeScreenShot("Failure");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		printTestResults(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("About to begin executing Test " + context.getName());
		Reporter.log("About to begin executing Test " + context.getName() + "<br>");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("About to end executing Test " + context.getName());
		Reporter.log("About to end executing Test " + context.getName() + "<br>");
	}

	@Override
	public void onStart(ISuite suite) {
		System.out.println("About to begin executing Suite " + suite.getName());
		Reporter.log("About to begin executing Suite " + suite.getName() + "<br>");
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("About to end executing Suite " + suite.getName());
		Reporter.log("About to end executing Suite " + suite.getName() + "<br>");
	}

	@Override
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		init(xmlSuites);
		suites.forEach(suite -> {
			Map<String, ISuiteResult> results = suite.getResults();
			results.values().forEach(result -> {
				ITestContext context = result.getTestContext();
				buildTestNodes(context.getFailedTests(), Status.FAIL);
				buildTestNodes(context.getSkippedTests(), Status.SKIP);
				buildTestNodes(context.getPassedTests(), Status.PASS);
			});
		});
		Reporter.getOutput().forEach(extent::setTestRunnerOutput);
		extent.flush();
	}

	private void buildTestNodes(IResultMap tests, Status status) {
		SortedSet<ITestResult> sortedSet = new TreeSet<ITestResult>();
		tests.getAllResults().forEach(sortedSet::add);
		if (tests.size() > 0) {
			sortedSet.forEach(result -> {
				ExtentTest test = extent.createTest(result.getTestContext().getCurrentXmlTest().getName() + " - "
						+ result.getMethod().getMethodName());
				test.assignCategory(result.getMethod().getRealClass().getSimpleName());
				Throwable throwable = result.getThrowable();
				Object[] parameters = result.getParameters();
				if (parameters.length > 0) {
					String params = Arrays.asList(parameters).stream().map(p -> p.toString()).collect(Collectors.joining(", "));
					test.info(params);
				}
				Reporter.getOutput(result).forEach(test::info);
				if (throwable != null) {
					test.log(status, throwable);
					try {
						test.addScreenCaptureFromPath(System.getProperty("user.dir") + failedScreenshot, "Failure");
					} catch (IOException e) {
						e.printStackTrace();
					}
				} else
					test.log(status, "Test " + status.toString().toLowerCase() + "ed");
				test.getModel().setStartTime(getTime(result.getStartMillis()));
				test.getModel().setEndTime(getTime(result.getEndMillis()));
			});
		}
	}

	/**
	 * This method is used to provide Date
	 * 
	 * @param millis: Date in milli seconds
	 * @return Date
	 */
	private Date getTime(long millis) {
		return Date.from(Instant.ofEpochMilli(millis));
	}

	/**
	 * This method is used to initialize the suite report generation mechanism
	 * 
	 * @param xmlSuites : List of XML Suites
	 */
	private void init(List<XmlSuite> xmlSuites) {
		String suiteName = xmlSuites.get(0).getName();
		if (Files.notExists(Paths.get(Constants.reportsDestination)))
			try {
				Files.createDirectory(Paths.get(Constants.reportsDestination));
			} catch (IOException e) {
				System.out.println("Unable to create path: " + Constants.reportsDestination);
			}
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(
				Constants.reportsDestination + Constants.reportsFileName);
		htmlReporter.config().setDocumentTitle("ExtentReports: " + suiteName);
		htmlReporter.config().setReportName(suiteName);
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setEncoding("utf-8");

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setReportUsesManualConfiguration(true);
	}

	/**
	 * This method is used to Print Test Results
	 * 
	 * @param result : Test Results
	 */
	private void printTestResults(ITestResult result) {
		System.out.println("Test Method resides in " + result.getTestClass().getName());
		Reporter.log("Test Method resides in " + result.getTestClass().getName() + "<br>");
		if (result.getParameters().length != 0) {
			String params = "";
			for (Object parameter : result.getParameters()) {
				params += parameter.toString() + ", ";
			}
			params = params.substring(0, params.length() - 2);
			System.out.println("Test Method has the following parameters: " + params);
			Reporter.log("Test Method has the following parameters: " + params + "<br>");
		}
		String status;
		switch (result.getStatus()) {
		case ITestResult.SUCCESS:
			status = "Passed";
			break;
		case ITestResult.FAILURE:
			status = "Failed";
			break;
		case ITestResult.SKIP:
			status = "Skipped";
			break;
		default:
			status = null;
		}
		System.out.println("Test Status: " + status);
		Reporter.log("Test Status: " + status + "<br>");
	}

}
