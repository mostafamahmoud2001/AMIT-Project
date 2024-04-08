package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P03_homePage {
    String homePageURL = "https://demo.nopcommerce.com/";
    By myAccountTapLoc = By.cssSelector("a.ico-account");



    private final WebDriver driver;

    public P03_homePage(WebDriver driver) {this.driver = driver;}
    public String getExpectedURL(){return homePageURL;}
    public boolean accountTapIsDisplayed(){return driver.findElement(myAccountTapLoc).isDisplayed();}

}
