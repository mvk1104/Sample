package com.base;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static com.base.BaseClass.browserLaunch;

public class Testing extends BaseClass {
    @Parameters({"browser"})
    @Test
        public void test1(String bws){
        if (bws.equals("chrome")){
            browserLaunch("chrome");
        }
        else if (bws.equals("firefox")){
            browserLaunch("firefox");
        }
        else if (bws.equals("edge")){
            browserLaunch("edge");
        }
    }
    @Test(dependsOnMethods = "test1")
        public void test2(){
        WebElement element = findElementId("email");
        sendvalues(element, "test@123.com");

        WebElement element1 = findElementId("pass");
        sendvalues(element1, "1234");

        WebElement element2 = findElementXpath("//button[@type='submit']");
        click(element2);
        String title = getTitle();
        System.out.println(title);
    }




}
