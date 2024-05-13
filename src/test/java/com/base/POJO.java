package com.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class POJO extends BaseClass{

    public void POJO(WebDriver driver) {
        this.driver = driver;
    }
    @FindBy(id = "email")
    private WebElement txtEmail;

    @FindBy(id = "pass")
    private WebElement txtPass;

    @FindBy(xpath = "//button[@value='1']")
    private WebElement btnClick;

    public WebElement getTxtPass() {
        return txtPass;
    }

    public WebElement getBtnClick() {
        return btnClick;
    }

    public WebElement getTxtEmail() {
        return txtEmail;
    }



}
