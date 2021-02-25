package com.onsolve.exercise.hooks;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.onsolve.exercise.common.Browser;
import com.onsolve.exercise.manage.DriverManager;
import com.onsolve.exercise.manage.ExtentManager;
import com.onsolve.exercise.model.YAMLConfig;
import com.onsolve.exercise.pages.CaptureForm;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.lang.reflect.Method;

import static com.onsolve.exercise.common.Helper.*;

public abstract class AbstractTest {
    protected ExtentTest extentTest;
    protected WebDriver driver;
    protected CaptureForm captureForm;

    @BeforeTest
    public void setUp() throws IOException {
        setYamlConfig(yamlToObject(YAMLConfig.class, getResourceDir() + "config.yml"));
        DriverManager.initWebDriver(Browser.CHROME);
        driver = DriverManager.getDriver();
        captureForm = new CaptureForm();
    }

    @BeforeMethod
    public void initTestReport(Method method) {
        ExtentReports extent = ExtentManager.getInstance();
        extentTest = extent.createTest(method.getName());
        ExtentManager.setTest(extentTest);
    }

    @AfterTest
    public void tearDown() {
        DriverManager.closeDriver();
    }
}
