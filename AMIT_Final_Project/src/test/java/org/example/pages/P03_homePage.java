package org.example.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class P03_homePage {
    String homePageURL    = "https://demo.nopcommerce.com/";
    By myAccountTapLoc    = By.cssSelector("a.ico-account");
    By currenciesListLoc  = By.id("customerCurrency");
    By productListLoc     = By.className("product-item");
    By priceTextLoc       = By.className("actual-price");
    By productTitleLoc    = By.className("product-title");
    By searchBoxLoc       = By.cssSelector("input#small-searchterms");
    By searchBtnLoc       = By.cssSelector("button.search-box-button");
    By skuTextLoc         = By.cssSelector("div.sku span.value");
    By pageTitleLoc       = By.cssSelector("div.page-title");
    By sliderImage1Loc    = By.cssSelector("img[class=\"nivo-main-image\"][src=\"https://demo.nopcommerce.com/images/thumbs/0000088_banner_01.webp\"]");
    By sliderImage2Loc    = By.cssSelector("img[class=\"nivo-main-image\"][src=\"https://demo.nopcommerce.com/images/thumbs/0000089_banner_02.webp\"]");
    By homePageLogoLoc    = By.cssSelector("img[alt=\"nopCommerce demo store\"]");
    By facebookIconLoc    = By.xpath("//ul[@class=\"networks\"]/li/a[text()=\"Facebook\"]");
    By twitterIconLoc     = By.xpath("//ul[@class=\"networks\"]/li/a[text()=\"Twitter\"]");
    By rssIconLoc         = By.xpath("//ul[@class=\"networks\"]/li/a[text()=\"RSS\"]");
    By youTubeIconLoc     = By.xpath("//ul[ @class=\"networks\"]/li/a[text()=\"YouTube\"]");
    List<By> categories   = new ArrayList<By>(){
    {
        add(By.xpath("//ul[@class=\"top-menu notmobile\"]/li/a[text()=\"Computers \"]"));
        add(By.xpath("//ul[@class=\"top-menu notmobile\"]/li/a[text()=\"Electronics \"]"));
        add(By.xpath("//ul[@class=\"top-menu notmobile\"]/li/a[text()=\"Apparel \"]"));
        add(By.xpath("//ul[@class=\"top-menu notmobile\"]/li/a[text()=\"Digital downloads \"]"));
        add(By.xpath("//ul[@class=\"top-menu notmobile\"]/li/a[text()=\"Books \"]"));
        add(By.xpath("//ul[@class=\"top-menu notmobile\"]/li/a[text()=\"Jewelry \"]"));
        add(By.xpath("//ul[@class=\"top-menu notmobile\"]/li/a[text()=\"Gift Cards \"]"));
    }
    };
    private final WebDriver driver;
    public P03_homePage(WebDriver driver) {this.driver = driver;}
    public String getExpectedURL(){return homePageURL;}
    public boolean accountTapIsDisplayed(){return driver.findElement(myAccountTapLoc).isDisplayed();}
    public By getFacebookIconLoc()  {return facebookIconLoc;}
    public By getTwitterIconLoc()   {return twitterIconLoc;}
    public By getRssIconLoc()       {return rssIconLoc;}
    public By getYouTubeIconLoc()   {return youTubeIconLoc;}
    public void selectEuroFromList(){
        Select select = new Select(driver.findElement(currenciesListLoc));
        select.selectByVisibleText("Euro");
    }
    public List<WebElement> getProductsElements(){return driver.findElements(productListLoc);}
    public List<String> getPricesTextOfProduct(){
        List<String> pricesList = new ArrayList<>();
        List<WebElement> productsList = getProductsElements();//Parent of each Card to make the code more scalable
        for(WebElement ele : productsList){
            // in each iteration access the child(Price Text) from the parent (Product Card)
            String price = ele.findElement(priceTextLoc).getText();
            pricesList.add(price);
        }
        return pricesList;
    }
    public List<String> getTitlesTextOfProduct(){
        List<String> TitlesList = new ArrayList<>();
        List<WebElement> productsList = getProductsElements();//Parent of each Card to make the code more scalable
        for(WebElement ele : productsList){
            // in each iteration access the child(Price Text) from the parent (Product Card)
            String price = ele.findElement(productTitleLoc).getText();
            TitlesList.add(price);
        }
        return TitlesList;
    }
    public void search(String text){
        driver.findElement(searchBoxLoc).sendKeys(text);
        driver.findElement(searchBtnLoc).click();
    }
    public String getSKUText(){
        return driver.findElement(skuTextLoc).getText();
    }
    public void clickOnTheProductWithIndex(int index){getProductsElements().get(index).click();}
    public String setCategories() {
        String category;
        Random random = new Random();
        int randIndex = random.nextInt(categories.size());
        By loc = categories.get(randIndex);
        WebElement ele = driver.findElement(loc);
        System.out.println(ele.getText());
        Actions action = new Actions(driver);
        action.moveToElement(ele).perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        List<WebElement> sublistElements = ele.findElements(By.xpath("//parent::li/ul/li"));
        sublistElements = cleaningList(sublistElements);
        if(sublistElements.isEmpty()){
            category= ele.getText();
            ele.click();
        }
        else {
            int rand = random.nextInt(sublistElements.size());
            category= sublistElements.get(rand).getText();
            sublistElements.get(rand).click();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return category;
    }
    private List<WebElement> cleaningList(List<WebElement> list){
        List<WebElement> newList = new ArrayList<>();
        for (WebElement sublistItem : list) {
            String sublistItemText = sublistItem.getText();
            if (!sublistItemText.equalsIgnoreCase("")){
                newList.add(sublistItem);
            }
        }
        return newList;
    }
    public String getPageTitleText(){
        return driver.findElement(pageTitleLoc).getText();
    }
    public By getSliderImage1(){
        return sliderImage1Loc;
    }
    public By getSliderImage2(){
        return sliderImage2Loc;
    }
    public By getHomePageLogoLoc(){
        return homePageLogoLoc;
    }
}
