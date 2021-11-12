package com.udzial.pages;

import com.google.common.util.concurrent.Uninterruptibles;
import com.udzial.driver.DriverManager;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BasePage {

    // Parent of android and ios is mobile element
    // Android(android element), iOS(iOS Element), mobile chrome (webElement)

    protected String getText(MobileElement element)
    {
        return element.getText();
    }
    protected void click(MobileElement element, String elementName)
    {
        //you can use waits though generally not required in native apps
        explicitWait(element);

        element.click();
        System.out.println(elementName + " is clicked successfully");
    }

    private void explicitWait(MobileElement element)
    {
        new WebDriverWait(DriverManager.getDriver(),3)
                .withMessage(()-> " Some problems while finding the element")
                .pollingEvery(Duration.ofSeconds(1))
                .until(ExpectedConditions.visibilityOf(element));
    }



    protected void click(By by, String elementName)
    {
        click((MobileElement) DriverManager.getDriver().findElement(by),elementName);
    }
    protected void chooseItemAndClick(List<MobileElement> list,String menu)
    {
//        list.parallelStream()
//                .filter(e->e.getText().contains(menu))
//                .findFirst()
//                .ifPresent(WebElement::click);
//or
        MobileElement mobileElement=list.parallelStream()
                .filter(e->e.getText().contains(menu))
                .findFirst()
                .get();

        click(mobileElement,menu);




    }
    protected void click(String locatorType, String value, String elementname)
    {
        if(locatorType.equalsIgnoreCase("xpath"))
        {
            click(By.xpath(value),elementname);
        }
        else if(locatorType.equalsIgnoreCase("id"))
        {
            click(By.id(value),elementname);
        }
    }


    private void tap(AndroidElement androidElement) {
        new AndroidTouchAction((PerformsTouchActions) DriverManager.getDriver())
                .tap(TapOptions.tapOptions().withElement(ElementOption.element(androidElement)))
                .perform();
    }

    // This can break if you use different devices as these co-orindates change sometimes

    private void tapUsingCoordintates(int x ,int y) {
        new AndroidTouchAction((PerformsTouchActions) DriverManager.getDriver())
                .tap(TapOptions.tapOptions().withPosition(PointOption.point(x,y)))
                .perform();
    }

    private void longTap(AndroidElement androidElement) throws InterruptedException {
        new AndroidTouchAction((PerformsTouchActions) DriverManager.getDriver())
                .longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(androidElement)))
                .perform();


    }

    protected void longPress(AndroidElement androidElement) throws InterruptedException {
        new AndroidTouchAction((PerformsTouchActions) DriverManager.getDriver())
                .longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(androidElement)))
                .release()
                .perform();


    }


    // Similar to drag and drop - longPress is used
    protected void moveFromOneElementToOther(AndroidElement source, AndroidElement target) throws InterruptedException {
        new AndroidTouchAction((PerformsTouchActions) DriverManager.getDriver())
                .longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(source)))
                .moveTo(ElementOption.element(target))
                .release()
                .perform();


    }

    // We use lonnPress here
    protected void dragAndDrop(AndroidElement source, AndroidElement target) throws InterruptedException {
        new AndroidTouchAction((PerformsTouchActions) DriverManager.getDriver())
                .longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(source)))
                .moveTo(ElementOption.element(target))
                .release()
                .perform();
        System.out.println("drag and drop is success");


    }

    // during scrolling Keyboard might be open
    // So you can start from half of the screen to 20% portion from the top
    // So you need to get middle position

    protected void scrollToSpecificElements(By by)
    {
        int i=0;
        while(DriverManager.getDriver().findElements(by).isEmpty()) {

            Dimension dimension = DriverManager.getDriver().manage().window().getSize();
            Double heightToStartScroll = dimension.height * 0.5;
            Double heightToStopScroll = dimension.height * 0.2;

            int startscroll = heightToStartScroll.intValue();
            int stopscroll = heightToStopScroll.intValue();

            int center = (int) (dimension.width * 0.5);

            Uninterruptibles.sleepUninterruptibly(1,TimeUnit.SECONDS);
            new AndroidTouchAction((PerformsTouchActions) DriverManager.getDriver())
                    .press(PointOption.point(center, startscroll)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                    .moveTo(PointOption.point(center, stopscroll))
                    .release()
                    .perform();
            i++;

            if(i>10)
            {
                break;
            }
        }

        if(DriverManager.getDriver().findElements(by).size()>0)
        {
            DriverManager.getDriver().findElement(by).click();

        }
    }



}

