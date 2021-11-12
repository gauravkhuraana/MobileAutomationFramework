package com.udzial.driver;

import com.udzial.utils.ProprertyUtils;
import org.openqa.selenium.WebDriver;


import java.net.MalformedURLException;
import java.util.Objects;

import static com.udzial.driver.DriverManager.getDriver;
import static com.udzial.driver.DriverManager.setDriver;


public class Driver {

    private Driver(){}
    private static WebDriver driver;



    public static void initDriver() throws MalformedURLException {

        if(Objects.isNull(getDriver())) {
            String modevalue = ProprertyUtils.getValue("mode");
            driver = DriverFactory.get(Modes.valueOf(modevalue.toUpperCase()));
            setDriver(driver);
        }

    }

    public static void quitDriver(){
        //unload();
        if(Objects.nonNull(getDriver()))
        getDriver().quit();
        DriverManager.unload();

    }

}
