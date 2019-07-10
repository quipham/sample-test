package com.onsolve.exercise.pages;

import com.onsolve.exercise.common.Helper;
import com.onsolve.exercise.manage.DriverManager;
import com.onsolve.exercise.model.YAMLConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

abstract class AbstractPage {
    WebDriver driver;
    YAMLConfig yamlConfig;

    AbstractPage() {
        yamlConfig = Helper.getYamlConfig();
        driver = DriverManager.getDriver();
        PageFactory.initElements(driver, this);
    }
}
