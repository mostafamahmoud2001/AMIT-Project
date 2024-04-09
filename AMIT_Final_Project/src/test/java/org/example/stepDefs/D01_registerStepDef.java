package org.example.stepDefs;
import org.example.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.Random;

public class D01_registerStepDef {
    public ChromeDriver driver;
    P01_register registerPage;
    @Given("user go to register page")
    public void goToRegisterPage(){
       driver = new ChromeDriver();
       registerPage = new P01_register(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
       driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
    }


    @When("^user select gender type(.*)$")
    public void selectGenderType(String genderType) {registerPage.getGenderLocation(genderType).click();}

    @And("^user enter first name (.*) and last name (.*)$")
    public void enterNames(String firstName , String lastName){
        registerPage.getFirstNameLocation().sendKeys(firstName);
        registerPage.getLastNameLocation().sendKeys(lastName);
    }


    @And("user enter date of birth")
    public void enterDateOfBirth(){
        registerPage.selectDayOfBirth("10");
        registerPage.selectMonthOfBirth("February");
        registerPage.selectYearOfBirth("2001");
    }


    @And("^user enter email  field (.*)$")
    public void enterEmail(String email){
        //Adding a random number to email to make the email unique
        Random random = new Random();
        int randomNum = random.nextInt(100)+1; //This line generate number between 1 and 100
        int indexOfAt = email.indexOf('@'); // get the index of @ in email to adding the randomNum before it
        String newEmail = email.substring(0 ,indexOfAt)+randomNum+email.substring(indexOfAt);
        // split the email int two parts the first part before '@' and second starts from '@' and concatenate the random number between them
        registerPage.setEmailField(newEmail);
    }
    @And("^user fills Password fields (.*) (.*)$")
    public void fillsPasswords(String password , String confirmPassword){
        registerPage.setPasswordField(password);
        registerPage.setConfirmPasswordField(confirmPassword);
    }
    @And("user clicks on register button")
    public void clickRegisterButton(){registerPage.submitButtonClick();}
    @Then("success message is displayed")
    public void successMessageDisplayed(){
        SoftAssert softAssert = new SoftAssert();
        boolean actualText = registerPage.getResultText().contains("Your registration completed");
        boolean actualColor = registerPage.getResultColor().contains("76, 177, 124");
        driver.quit();
        softAssert.assertEquals(actualText,true);
        softAssert.assertEquals(actualColor,true);
        softAssert.assertAll();

    }

}

