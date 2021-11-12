package com.udzial.testCases;

import com.udzial.driver.Driver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    @BeforeMethod
    public void setupTest() throws MalformedURLException {
        Driver.initDriver();
    }

    @AfterMethod
    public void tearDownTest()
    {
        Driver.quitDriver();
    }
}
