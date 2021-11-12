package com.udzial.driver;

import com.udzial.constants.FrameworkConstants;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class LocalDriverImpl implements IDriver{

    @Override
    public WebDriver getDriver() throws MalformedURLException {
        DesiredCapabilities capabilities;
        //AndroidDriver<AndroidElement> driver;

        capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.APP, FrameworkConstants.getApkfilepath());
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"emulator");
        capabilities.setCapability(MobileCapabilityType.UDID,"emulator-5554");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"io.appium.android.apis");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,".ApiDemos");
        capabilities.setCapability(AndroidMobileCapabilityType.SKIP_DEVICE_INITIALIZATION,true);


        return new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4729/wd/hub"),capabilities);

    }
}
