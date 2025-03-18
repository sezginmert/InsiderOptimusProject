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
import tests.AmazonTest;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class AmazonProductPage extends AmazonTest {

    public AmazonProductPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    // Bu kisim sayfa icin locators'lar, selenium 4 ten sonra kullanılan yöntem
    By products_list = By.xpath("//div[@class='a-section a-spacing-base']");
    By second_button_click = By.xpath("//a[@class='s-pagination-item s-pagination-button s-pagination-button-accessibility']");

    @FindBy(xpath ="(//li[@class='s-list-item-margin-right-adjustment'])[2]" )
    public WebElement scroll;


    @Step("Aranan ürünün sonuçlarinin oldugu dogrulanir")
    public void productVerifyFound(){

        ReusableMethods.wait(1);
        Actions actions = new Actions(Driver.getDriver());
        ReusableMethods.wait(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        List<WebElement> searchResults = Driver.getDriver().findElements(products_list);
        Assert.assertTrue(searchResults.size() > 1);
        ReusableMethods.wait(1);
    }

    @Step("Arama sonucunun ikinci sayfasina gidilip, dogrulandi")
    public void goToSecondPage(){

        ReusableMethods.scrollToElement(scroll);
        ReusableMethods.wait(1);
        Driver.getDriver().findElement(second_button_click).click();
        ReusableMethods.wait(1);

        String expected = ConfigReader.getProperty("amazon_page2_verification");
        String actual = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actual.contains(expected));
        ReusableMethods.wait(1);
    }

}
