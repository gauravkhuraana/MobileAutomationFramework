package com.udzial.driver;

import org.openqa.selenium.WebDriver;

public class DriverManager {

    private static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

    public static WebDriver getDriver()
    {
        return threadLocalDriver.get();
    }

    public static void setDriver(WebDriver driverref)
    {
        threadLocalDriver.set(driverref);
    }

    public static void unload()
    {
        threadLocalDriver.remove();
    }
}
