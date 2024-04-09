package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;
import java.time.Duration;
import java.util.List;

public class D04_searchStepDef {
    P03_homePage homePage;
    WebDriver driver;
    String searchingProduct;
    @Given("Open HomePage")
    public void openHomePage(){
        driver = new ChromeDriver();
        homePage = new P03_homePage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
    }
    @When("^search using (.*)$")
    public void searchWith(String text){
        homePage.search(text);
        searchingProduct = text;
    }
    @Then("^Search shows relevant results (.*)$")
    public void searchShowsRelevantTextResults(String text){
        System.out.println(homePage.getProductsElements().size());
        List<String> titles = homePage.getTitlesTextOfProduct();
        boolean isContains = true;
        text = text.toLowerCase();
        for (String s : titles){
            s = s.toLowerCase();
            if(!s.contains(text)){
                isContains = false;
                break;
            }
        }
        driver.quit();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(isContains);
        softAssert.assertAll();
    }
    @And("Click On the product")
    public void clickOnTheProduct(){
        homePage.clickOnTheProductWithIndex(0);
    }
    @Then("^Search shows relevant SKU results (.*)$")
    public void searchShowsRelevantSKUResults(String sku){
        String actualSKU = homePage.getSKUText();
        System.out.println(actualSKU);
        boolean actual = actualSKU.contains(sku);
        driver.quit();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(actual);
        softAssert.assertAll();
    }
}
