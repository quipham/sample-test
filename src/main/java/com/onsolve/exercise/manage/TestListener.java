package com.onsolve.exercise.manage;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    private static Logger logger = LogManager.getLogger(TestListener.class);
    private static ExtentReports extent = ExtentManager.createInstance();
    private static ExtentTest extentTest;

    @Override
    public synchronized void onStart(ITestContext context) {
        logger.info("Reports Test Suite started!");
    }

    @Override
    public synchronized void onFinish(ITestContext context) {
        logger.info("Reports Test Suite is generated!");
        extent.flush();
    }

    @Override
    public synchronized void onTestStart(ITestResult result) {
        logger.info(result.getMethod().getMethodName() + " started!");
    }

    @Override
    public synchronized void onTestSuccess(ITestResult result) {
        logger.info(result.getMethod().getMethodName() + " passed!");
        extentTest = ExtentManager.getTest();
        extentTest.pass("Test passed");
    }

    @Override
    public synchronized void onTestFailure(ITestResult result) {
        logger.info(result.getMethod().getMethodName() + " failed!");
        extentTest = ExtentManager.getTest();
        extentTest.fail(result.getThrowable());
    }

    @Override
    public synchronized void onTestSkipped(ITestResult result) {
        logger.info(result.getMethod().getMethodName() + " skipped!");
        extentTest = ExtentManager.getTest();
        extentTest.skip(result.getThrowable());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        logger.info("onTestFailedButWithinSuccessPercentage for " + result.getMethod().getMethodName());
    }
}
