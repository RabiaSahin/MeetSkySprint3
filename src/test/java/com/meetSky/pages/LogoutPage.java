package com.meetSky.pages;

import com.meetSky.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
    public LogoutPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//img[@height='32']")
    public WebElement profileIcon;

    @FindBy(xpath = "//li[@data-id='logout']")
    public WebElement logoutBtn;


}
