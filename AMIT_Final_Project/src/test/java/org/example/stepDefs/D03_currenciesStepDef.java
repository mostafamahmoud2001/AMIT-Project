package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import org.example.pages.P03_homePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class D03_currenciesStepDef {
    WebDriver driver;
    P03_homePage homePage ;
    @Given("Select Euro currency from the dropdown")
    public void selectEuroCurrency(){
        driver = new ChromeDriver();
        homePage = new P03_homePage(driver);
        driver.get("https://demo.nopcommerce.com/");
        homePage.selectEuroFromList();
    }
    @Then("get Price Text Of Product")
    public void getPriceOfProduct(){
      List<String> prices = homePage.getPriceTextOfProduct();
      boolean euroFlag = true;
      for (String s : prices){
          if (!s.contains("€")){//If the price does not include the euro symbol (€), then the flag should be set to false.
              euroFlag = false;
              break;
          }
      }
        Assert.assertTrue(euroFlag);
    }
}
