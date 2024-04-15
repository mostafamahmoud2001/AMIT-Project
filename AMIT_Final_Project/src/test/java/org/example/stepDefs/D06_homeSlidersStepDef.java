package org.example.stepDefs;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;
public class D06_homeSlidersStepDef {
    P03_homePage homePage;
    WebDriver driver;
    @Given("Open HomePage to slider")
    public void openHomePage(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        homePage = new P03_homePage(driver);
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
    }
    @When("^Click on Slider Image (.*)$")
    public void ClickOnSliderImage(int sliderNum){
        String actualUrl ;
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        Actions actions = new Actions(driver);
        if(sliderNum==1){
            wait.until(ExpectedConditions.visibilityOfElementLocated(homePage.getSliderImage1()));
            actions.moveToElement(driver.findElement(homePage.getSliderImage1())).click().perform();
            wait.until(ExpectedConditions.visibilityOfElementLocated(homePage.getHomePageLogoLoc()));
            actualUrl = driver.getCurrentUrl();
            Assert.assertEquals(actualUrl,"https://demo.nopcommerce.com/iphone-14-pro");
        }
        else if(sliderNum==2){
            wait.until(ExpectedConditions.visibilityOfElementLocated(homePage.getSliderImage2()));
            actions.moveToElement(driver.findElement(homePage.getSliderImage2())).click().perform();
            wait.until(ExpectedConditions.visibilityOfElementLocated(homePage.getHomePageLogoLoc()));
            actualUrl = driver.getCurrentUrl();
            Assert.assertEquals(actualUrl,"https://demo.nopcommerce.com/galaxy-s22-ultra");
        }
        driver.quit();
    }
}
