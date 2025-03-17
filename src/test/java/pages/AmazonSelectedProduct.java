package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class AmazonSelectedProduct extends ReusableMethods{

    public AmazonSelectedProduct(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // Bu kisim sayfa icin locators, selenium 4 ten sonra kullanılan yöntem
    By products_list = By.xpath("//div[@class='a-section a-spacing-base']");

    @FindBy(xpath = "//h1[@class='a-size-medium a-spacing-small']")
    public WebElement select_product_details;


    @Step("Sayfadaki ürünler listesinden üçüncü ürün secildi")
    public void selectThirdProduct(int productIndex){

        Actions actions = new Actions(Driver.getDriver());
        ReusableMethods.wait(1);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.wait(1);
        List<WebElement> searchResults = Driver.getDriver().findElements(products_list);

        if (searchResults.size() >= productIndex) {
            searchResults.get(productIndex - 1).click();
        }
    }

    @Step("İstenilen ürünün secildigi dogrulandi")
    public void selectedProductVerify(){

        ReusableMethods.scrollToElement(select_product_details);
        ReusableMethods.wait(1);
        Assert.assertTrue(select_product_details.isDisplayed());
    }
}
