package com.udzial.pages;

import com.udzial.driver.DriverManager;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


import java.util.List;

public class HomePage {


    // Page Factory

    // By locators

    // String locators


    // Below will work for both android and appium
    // you have to use MObile Element Type instead of Android Element
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Views')]")
    @iOSXCUITFindBy(accessibility = "Views")
    //private AndroidElement views;
    private MobileElement views;


  // WE removed [contains(@text,'Views')] to make it more generic
    @AndroidFindBy(xpath = "//android.widget.TextView")
    @iOSXCUITFindBy(accessibility = "Views")
    private List<MobileElement> menuItems;


    public void clickAMenuItem(String menu)
    {
        menuItems.parallelStream().filter(e->e.getText().contains(menu)).findFirst().ifPresent(WebElement::click);

        //below is another way of doing and it will take more time
        /* for(WebElement element:menuitems)
        {
        if(element.getText().equalsIgnoreCase(menu)
        {
        element.click();
        }
         */


    }

    public HomePage()
    {
        PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()),this);
    }

    public void clickOnViews()
    {
        views.click();
    }

    // Where the function returns the next page
    public ViewsLandingPage clickOnViewsSecondWay()
    {
        views.click();
        return new ViewsLandingPage();
    }

}
