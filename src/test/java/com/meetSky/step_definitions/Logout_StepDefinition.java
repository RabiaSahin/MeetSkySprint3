package com.meetSky.step_definitions;

import com.meetSky.pages.LoginPage;
import com.meetSky.pages.LogoutPage;
import com.meetSky.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class Logout_StepDefinition {

    LoginPage loginPage = new LoginPage();
    LogoutPage logoutPage = new LogoutPage();


    @Then("Click on the profile icon")
    public void click_on_the_profile_icon() {
        logoutPage.profileIcon.click();
    }
    @Then("Verify that user can see the Logout link")
    public void verify_that_user_can_see_the_logout_link() {

    }
    @Then("Click on the Log out link")
    public void click_on_the_log_out_link() {
        logoutPage.logoutBtn.click();
    }
    @Then("Verify that user can log out on the files page and see login page")
    public void verify_that_user_can_log_out_on_the_files_page_and_see_login_page() {
        Assert.assertTrue(loginPage.LoginBtn.isDisplayed());
    }

    @And("Click on the step back button")
    public void clickOnTheStepBackButton() {
        Driver.getDriver().navigate().back();
    }

    @Then("Verify that user can NOT go to home page again")
    public void verifyThatUserCanNOTGoToHomePageAgain() {
        Assert.assertTrue(loginPage.LoginBtn.isDisplayed());
    }
}
