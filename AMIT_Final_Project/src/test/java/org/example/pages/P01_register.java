package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class P01_register {
    By genderMaleLoc       = By.id("gender-male");
    By genderFemaleLoc     = By.id("gender-female");
    By firstNameLoc        = By.id("FirstName");
    By lastNameLoc         = By.id("LastName");
    By dayOfBirthLoc       = By.name("DateOfBirthDay");
    By monthOfBirthLoc     = By.name("DateOfBirthMonth");
    By yearOfBirthLoc      = By.name("DateOfBirthYear");
    By emailLoc            = By.id("Email");
    By passwordLoc         = By.id("Password");
    By confirmPasswordLoc  = By.id("ConfirmPassword");
    By submitLoc           = By.id("register-button");
    By resultLoc           = By.cssSelector("div.result");
    private final WebDriver driver;

    public P01_register(WebDriver driver){
        this.driver = driver;
    }
    public  WebElement getGenderLocation(String gender){

        if(gender.contains("Male")){
            return driver.findElement(genderMaleLoc);
        }
        else if (gender.contains("Female")){
            return driver.findElement(genderFemaleLoc);
        }
        return null;
    }
    public WebElement getFirstNameLocation(){
        return driver.findElement(firstNameLoc);
    }
    public WebElement getLastNameLocation(){
        return driver.findElement(lastNameLoc);
    }
    public void selectDayOfBirth(String day){
      WebElement element = driver.findElement(dayOfBirthLoc);
      Select select = new Select(element);
      select.selectByValue(day);
    }
    public void selectMonthOfBirth(String month){
        WebElement element = driver.findElement(monthOfBirthLoc);
        Select select = new Select(element);
        select.selectByVisibleText(month);
    }
    public void selectYearOfBirth(String year){
        WebElement element = driver.findElement(yearOfBirthLoc);
        Select select = new Select(element);
        select.selectByValue(year);
    }
    public void setEmailField(String email){
        driver.findElement(emailLoc).sendKeys(email);
    }
    public void setPasswordField(String password){
        driver.findElement(passwordLoc).sendKeys(password);
    }
    public void setConfirmPasswordField(String confirmPassword){
        driver.findElement(confirmPasswordLoc).sendKeys(confirmPassword);
    }
    public void submitButtonClick(){
        driver.findElement(submitLoc).click();
    }
    public String getResultText(){
       return driver.findElement(resultLoc).getText();
    }
    public String getResultColor(){
        return driver.findElement(resultLoc).getCssValue("color");
    }
}
