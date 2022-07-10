package com.meetSky.pages;

import com.meetSky.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//input[@id='user']")
    public WebElement usernameInput;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordInput;

    @FindBy (xpath = "//input[@id='submit-form']")
    public WebElement LoginBtn;


    @FindBy (xpath = "//div[@class='logo logo-icon']")
    public WebElement meetSkyLogo;

    @FindBy (xpath = "//*[contains(text(),'Wrong')]")
    public WebElement warningInvalidCredential;

    @FindBy (className = ("toggle-password"))
    public WebElement togglePassword;

    @FindBy (id = ("lost-password"))
    public WebElement forgotPassword;

    @FindBy (id = ("reset-password-submit"))
    public WebElement resetPassword;

    @FindBy (xpath = ("//input[@placeholder=('Username or email')]"))
    public WebElement usernamePlaceholder;

    @FindBy (xpath = ("//input[@placeholder=('Password')]"))
    public WebElement passwordPlaceholder;



}
