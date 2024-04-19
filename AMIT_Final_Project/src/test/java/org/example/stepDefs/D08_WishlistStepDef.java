package org.example.stepDefs;

import io.cucumber.java.en.Given;
import org.example.pages.P03_homePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class D08_WishlistStepDef {
    P03_homePage homePage;
    WebDriver driver;
    @Given("Open Home Page to wishlist")
    public void openHomePage(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        homePage = new P03_homePage(driver);
        driver.get("https://demo.nopcommerce.com/");
    }
}
