package com.udzial.driver;

import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public final class DriverFactory {

    private DriverFactory(){}

    public static WebDriver get(Modes mode) throws MalformedURLException {
        WebDriver driver = null;


        if(mode.equals(Modes.LOCAL))
        {
            driver = new LocalDriverImpl().getDriver();
        }
        else if(mode.equals(Modes.BS))
        {
            driver = new BrowserStackImpl().getDriver();
        }
        return driver;

    }
}
