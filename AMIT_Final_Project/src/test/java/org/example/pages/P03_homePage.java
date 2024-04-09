package org.example.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class P03_homePage {
    String homePageURL    = "https://demo.nopcommerce.com/";
    By myAccountTapLoc    = By.cssSelector("a.ico-account");
    By currenciesListLoc  = By.id("customerCurrency");
    By productListLoc     = By.className("product-item");
    By priceTextLoc       = By.className("actual-price");
    private final WebDriver driver;

    public P03_homePage(WebDriver driver) {this.driver = driver;}
    public String getExpectedURL(){return homePageURL;}
    public boolean accountTapIsDisplayed(){return driver.findElement(myAccountTapLoc).isDisplayed();}
    public void selectEuroFromList(){
        Select select = new Select(driver.findElement(currenciesListLoc));
        select.selectByVisibleText("Euro");
    }
    public List<WebElement> getProductsElements(){return driver.findElements(productListLoc);}
    public List<String> getPriceTextOfProduct(){
        List<String> pricesList = new ArrayList<>();
        List<WebElement> productsList = getProductsElements();//Parent of each Card to make the code more scalable
        for(WebElement ele : productsList){
            // in each iteration access the child(Price Text) from the parent (Product Card)
            String price = ele.findElement(priceTextLoc).getText();
            pricesList.add(price);
        }
        return pricesList;
    }
}
