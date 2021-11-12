package com.udzial.testCases;

import com.udzial.driver.Driver;
import com.udzial.driver.DriverManager;
import com.udzial.facade.DragDropFacade;
import com.udzial.pages.DragAndDropPage;
import com.udzial.pages.HomePage;
import com.udzial.pages.ViewsLandingPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.aspectj.weaver.ast.And;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import sun.security.krb5.internal.crypto.Des;

import javax.swing.*;
import javax.swing.text.View;
import java.net.MalformedURLException;
import java.net.URL;

import static org.assertj.core.api.Assertions.assertThat;

public class tapTests extends BaseTest{

    // Never hardcode
    // Try to reuse the code but inheritance is the last solution
    // Make it easy for others to follow or write new tests
    // clean code
    // keep right things at right places


    @Test
    public void tapTests() throws MalformedURLException {

        DriverManager.getDriver().findElement(By.xpath("//android.widget.TextView[contains(@text,'Views')]")).click();
    }

    @Test
    public void tapTestsAnotherWay() throws MalformedURLException {

       // new HomePage().clickOnViews();
       // new ViewsLandingPage().clickAMenuItem("Drag and Drop");

        //new HomePage().clickOnViewsSecondWay().clickAMenuItem("Animation");
        new HomePage().clickAMenuItem("Animation");
    }

    @Test
    public void tapTestsWrapperWay() throws MalformedURLException {

        // new HomePage().clickOnViews();
        // new ViewsLandingPage().clickAMenuItem("Drag and Drop");

        //new HomePage().clickOnViewsSecondWay().clickAMenuItem("Animation");
        new ViewsLandingPage().clickAMenuItemWrapperWay("Animation");
    }

    @Test
    public void dragAndDropTestsUsingFacade() throws InterruptedException {
        new DragDropFacade().navigateToDragAndDropPage();
        String successMessage = new  DragAndDropPage().performDragAndDrop().getSuccessMessage();

        assertThat(successMessage)
                .isEqualTo("Dropped!");


    }

    @Test
    public void dragAndDropTestsUsingFacadeAlternateWay() throws InterruptedException {

        String successMessage = new DragDropFacade()
                .navigateToDragAndDropPage()
                .getDragAndDropPage()
                .getSuccessMessage();


        assertThat(successMessage)
                .isEqualTo("Dropped!");


    }


    @Test
    public void swipeTests() throws MalformedURLException {

        DriverManager.getDriver().findElement(By.xpath("//android.widget.TextView[contains(@text,'Views')]")).click();
    }

    public void swipeTest() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.APP,System.getProperty("user.dir")+"src/test/resources/apkfiles/ApiDemos-debug.apk");
        cap.setCapability(AndroidMobileCapabilityType.SYSTEM_PORT,"8201");
        cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"io.appium.android.apis");
        cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,".ApiDemos");
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        // to be updated
        cap.setCapability(MobileCapabilityType.DEVICE_NAME,"nexus 6");
        cap.setCapability(MobileCapabilityType.UDID,"emulator-5554");

        AndroidDriver<AndroidElement> driver =
                new AndroidDriver<AndroidElement>( new URL("http://127.0.0.1:4729/wd/hub"),cap);
        driver.findElementByXPath("//android.widget.TextView[contains(@text,'Views')]").click();

    }
}
