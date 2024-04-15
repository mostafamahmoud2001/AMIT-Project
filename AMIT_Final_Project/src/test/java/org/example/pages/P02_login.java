package org.example.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class P02_login {
    By emailLoc           = By.id("Email");
    By passwordLoc        = By.id("Password");
    By loginBtnLoc        = By.className("login-button");
    By errorMessageLoc    = By.cssSelector("div.message-error");
    private final WebDriver driver;
    public P02_login(WebDriver driver) {this.driver = driver;}
    public void setEmailField(String email){driver.findElement(emailLoc).sendKeys(email);}
    public void setPasswordField(String pass) {driver.findElement(passwordLoc).sendKeys(pass);}
    public void loginBtnClick(){driver.findElement(loginBtnLoc).click();}
    public String getErrorMessageText(){return driver.findElement(errorMessageLoc).getText();}
    public String getErrorMessageColor(){return driver.findElement(errorMessageLoc).getCssValue("color");}
}
