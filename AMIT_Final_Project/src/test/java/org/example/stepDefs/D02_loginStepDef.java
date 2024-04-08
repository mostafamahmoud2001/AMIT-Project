package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_login;
import org.example.pages.P03_homePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class D02_loginStepDef {
    P02_login loginPage;
    P03_homePage homePage;
    WebDriver driver;
    @Given("user go to login page")
    public void userGoToLoginPage(){
        driver = new ChromeDriver();
        loginPage = new P02_login(driver);
        homePage  = new P03_homePage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://demo.nopcommerce.com/login?returnUrl=%2F");
    }
    @When("^user login with (.*) and (.*)$")
    public void loginWithEmailAndPassword(String email , String password){
        loginPage.setEmailField(email);
        loginPage.setPasswordField(password);
    }
    @And("user press on login button")
    public void pressLoginButton(){loginPage.loginBtnClick();}
    @Then("user login to the system successfully")
    public void userLoginToSystem(){
        String currentURL = driver.getCurrentUrl();
        boolean URL_Assert = currentURL.equals(homePage.getExpectedURL());
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(URL_Assert);
        softAssert.assertTrue(homePage.accountTapIsDisplayed());
        softAssert.assertAll();
    }
    @Then("user could not login to the system")
    public void userCouldNotLoginToSystem(){
        String message = loginPage.getErrorMessageText();
        boolean actual = message.contains("Login was unsuccessful");
        String color = Color.fromString(loginPage.getErrorMessageColor()).asHex();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(color,"#e4434b");
        softAssert.assertTrue(actual);
        softAssert.assertAll();
    }
}
