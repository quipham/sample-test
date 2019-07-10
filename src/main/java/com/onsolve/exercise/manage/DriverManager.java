package com.onsolve.exercise.manage;

import com.onsolve.exercise.common.Browser;
import com.onsolve.exercise.common.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class DriverManager {
    private static ConcurrentHashMap<String, WebDriver> driverPool = new ConcurrentHashMap<>();

    public static synchronized WebDriver getDriver() {
        return driverPool.get(Thread.currentThread().getName());
    }

    public static synchronized void closeDriver() {
        driverPool.get(Thread.currentThread().getName()).quit();
    }

    public static synchronized void initWebDriver(String browser) {
        WebDriver driver;
        if (browser.equals(Browser.CHROME)) {
            System.setProperty("webdriver.chrome.driver", Helper.getRootDir() + "/driver/chromedriver");
            driver = new ChromeDriver();
            driverPool.put(Thread.currentThread().getName(), driver);
            driver.manage().timeouts().implicitlyWait(12000, TimeUnit.MILLISECONDS);
            driver.manage().window().maximize();
        }
    }

    private DriverManager() {
    }
}
