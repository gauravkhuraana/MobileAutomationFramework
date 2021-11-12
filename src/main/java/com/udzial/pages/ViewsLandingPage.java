package com.udzial.pages;

import com.udzial.driver.Driver;
import com.udzial.driver.DriverManager;
import com.udzial.utils.DynamicXpathUtils;
import org.openqa.selenium.By;

import static com.udzial.utils.DynamicXpathUtils.getXpath;

public class ViewsLandingPage extends BasePage{

    // Easy way to click various by name

    // 2 Ways of replacing

    private String dragAndDrop = "//android.widget.TextView[contains(@text,'%replaceable%')]";
    private String dragAndDrop1 = "//android.widget.TextView[contains(@text,'%s')]";

    public void clickAMenuItem(String menuname)
    {
        String newxpath = dragAndDrop.replace("%replaceable%",menuname);
        String newxpath1 = String.format(dragAndDrop1,menuname);
        String newxpath2 = getXpath(dragAndDrop1,menuname);

        //DriverManager.getDriver().findElement(By.xpath(newxpath)).click();
        DriverManager.getDriver().findElement(By.xpath(newxpath2)).click();
    }

    public void clickAMenuItemWrapperWay(String menuname)
    {
        String newxpath = getXpath(dragAndDrop1,menuname);
        click("xpath",newxpath,"Drag and Drop");


    }


}
