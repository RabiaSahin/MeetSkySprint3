package com.meetSky.step_definitions;

import com.meetSky.pages.LoginPage;
import com.meetSky.utilities.BrowserUtils;
import com.meetSky.utilities.ConfigurationReader;
import com.meetSky.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class Login_StepDefinition {

    LoginPage loginPage = new LoginPage();

    @When("Navigate to login page")
    public void navigate_to_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("meetSky_url"));
    }
    @When("Enter username into {string} inputbox")
    public void enter_valid_username_into_username_inputbox(String username) {
        loginPage.usernameInput.sendKeys(username);
    }
    @When("Enter password into {string} inputbox")
    public void enter_valid_password_into_password_inputbox(String password) {
        loginPage.passwordInput.sendKeys(password);
    }
    @When("Click on the login button on the login page")
    public void click_on_the_login_button_on_the_login_page() {
        loginPage.submitFormButton.click();
    }

    @Then("Verify that user can login files page successfully")
    public void verify_that_user_can_login_files_page_successfully() {
        Assert.assertTrue(loginPage.meetSkyLogo.isDisplayed());

    }

    @Then("Verify that user can not login and see the notice message")
    public void verifyThatUserCanNotLoginAndSeeTheNoticeMessage() {
        Assert.assertTrue(loginPage.warningInvalidCredential.isDisplayed());
    }

    @Then("Verify that user can not login with blank username and see the alert message")
    public void verifyThatUserCanNotLoginWithBlankUsernameAndSeeTheAlertMessage() {
        String message = Driver.getDriver().findElement(By.name("user")).getAttribute("validationMessage");
        Assert.assertTrue(message.equalsIgnoreCase("Please fill in this field."));
    }

    @Then("Verify that user can not login with blank password and see the alert message")
    public void verifyThatUserCanNotLoginWithBlankPasswordAndSeeTheAlertMessage() {
        String message = Driver.getDriver().findElement(By.name("password")).getAttribute("validationMessage");
        Assert.assertTrue(message.equalsIgnoreCase("Please fill in this field."));
    }

    @Then("Verify that user can see the password in a form of dots by default")
    public void verifyThatUserCanSeeThePasswordInAFormOfDotsByDefault() {
        String inputType = loginPage.passwordInput.getAttribute("type");
        System.out.println("inputType = " + inputType);
        Assert.assertTrue(inputType.equalsIgnoreCase("password"));

    }

    @And("Click on the eye sign after entering the password")
    public void clickOnTheEyeSignAfterEnteringThePassword() {
        loginPage.togglePassword.click();
    }

    @Then("Verify that user can see the password explicitly")
    public void verifyThatUserCanSeeThePasswordExplicitly() {
        String inputType = loginPage.passwordInput.getAttribute("type");
        System.out.println("inputType = " + inputType);
        Assert.assertTrue(inputType.equalsIgnoreCase("text"));
    }

    @And("Verify that user can see the Forgot password? link")
    public void verifyThatUserCanSeeTheForgotPasswordLink() {
        Assert.assertTrue(loginPage.forgotPassword.isDisplayed());
    }

    @And("Click on the Forgot password? link")
    public void clickOnTheForgotPasswordLink() {
        loginPage.forgotPassword.click();
    }

    @Then("Verify that user can see the Reset Password button")
    public void verifyThatUserCanSeeTheResetPasswordButton() {
        BrowserUtils.sleep(1);
        Assert.assertTrue(loginPage.resetPassword.isDisplayed());
    }

    @Then("Verify that user can see valid placeholders on Username inpurbox")
    public void verifyThatUserCanSeeValidPlaceholdersOnUsernameInpurbox() {
        Assert.assertTrue(loginPage.usernamePlaceholder.isDisplayed());
        
    }

    @Then("Verify that user can see valid placeholders on Password inputbox")
    public void verifyThatUserCanSeeValidPlaceholdersOnPasswordInputbox() {
        Assert.assertTrue(loginPage.passwordPlaceholder.isDisplayed());
    }
}
