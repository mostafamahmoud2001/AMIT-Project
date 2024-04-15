package org.example.stepDefs;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.pages.P03_homePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
public class D07_followUsStepDef {
    P03_homePage homePage;
    WebDriver driver;
    @Given("open home page to followUs")
    public void openHomePage(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        homePage = new P03_homePage(driver);
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
    }
    @Then("^Click on (.*) and the (.*)$")
    public void clickOnIcon(String icon , String expectedURL){
        By iconLoc = null;
        if(icon.contains("facebook"))       iconLoc = homePage.getFacebookIconLoc();
        else if (icon.contains("twitter"))  iconLoc = homePage.getTwitterIconLoc();
        else if (icon.contains("rss"))      iconLoc = homePage.getRssIconLoc();
        else if (icon.contains("youtube"))  iconLoc = homePage.getYouTubeIconLoc();
        driver.findElement(iconLoc).click();
        List<String> handles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(handles.get(1));
        try {Thread.sleep(2000);} catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL,expectedURL);
        driver.close();driver.switchTo().window(handles.get(0));
        driver.quit();
    }
}
