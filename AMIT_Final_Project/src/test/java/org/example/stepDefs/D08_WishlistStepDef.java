package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.Colors;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

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
    @When("Open mobile")
    public void OpenMobile(){
        driver.findElement(homePage.getMobileLoc()).click();
    }
    @And("Add to wishlist")
    public void AddToWishlist(){
        driver.findElement(homePage.getAddToWishlistBtnLoc()).click();
    }
    @Then("success message is displayed with green background")
    public void successMessageAppears(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePage.getSuccessMessContainerLoc()));
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(driver.findElement(homePage.getSuccessMessTextLoc()).isDisplayed());
        String color = driver.findElement(homePage.getSuccessMessContainerLoc())
                .getCssValue("background-color");
        color = Color.fromString(color).asHex();
        softAssert.assertEquals(color,"#4bb07a");
        driver.quit();
        softAssert.assertAll();
    }
    @Then("open wishlist page")
    public void openWishlistPage(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(homePage.getSuccessMessContainerLoc()));
        driver.findElement(homePage.getWishlistTabLoc()).click();
        int quantity = Integer.parseInt(driver.findElement(homePage.getItemQuantityLoc()).getAttribute("value"));
        boolean actual = (quantity > 0);
        driver.quit();
        Assert.assertTrue(actual);
    }
}
