package org.example.stepDefs;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import java.time.Duration;

public class D05_hoverCategoriesStepDef {
    P03_homePage homePage;
    WebDriver driver;
    String categorySelected;
    @Given("Open HomePage to hover")
    public void openHomePage(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        homePage = new P03_homePage(driver);
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
    }
    @When("Select random category")
    public void SelectRandomCategory() {
        categorySelected = homePage.setCategories();
    }
    @Then("The category page opens successfully")
    public void categoryPageOpensSuccessfully(){
        String titleText = homePage.getPageTitleText();
        titleText = titleText.toLowerCase().trim();
        categorySelected= categorySelected.toLowerCase().trim();
        driver.quit();
        Assert.assertEquals(titleText,categorySelected);
    }
}
