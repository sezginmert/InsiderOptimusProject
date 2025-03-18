package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class AmazonHomePage extends ReusableMethods {

    public AmazonHomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

     int MAX_RETRY_COUNT = 3; // Maksimum deneme sayısı
     int retryCount = 0;


    // Bu kisim sayfa icin locators'lar, selenium 4 ten sonra kullanılan yöntem
    By amazon_search_box = By.id("twotabsearchtextbox");
    By accept_cookie = By.xpath("//input[@class='a-button-input celwidget']");


    @Step("Amazona gidip anaSayfada oldugu dogrulanir")
    public void goToAmazonVerify(){

        Driver.getDriver().get(ConfigReader.getProperty("amazon_Url"));
        String expectedHomePage = ConfigReader.getProperty("amazon_homepage");
        String actualHomePage = Driver.getDriver().getCurrentUrl();
        ReusableMethods.wait(1);
        Assert.assertEquals(actualHomePage,expectedHomePage);
        ReusableMethods.wait(1);
    }


    @Step("Amazon.com.tr'de cikan cookie handle ediliyor eger yoksa try-catch ile adimi atliyor")
    public void cookieHandle(){

        try {

            if (Driver.getDriver().findElement(accept_cookie).isDisplayed()) {
                Driver.getDriver().findElement(accept_cookie).click();;
            }else {
                Driver.quitDriver();
            }

        } catch (Exception e) {
            retryCount++;
            if (retryCount < MAX_RETRY_COUNT) {

                goToAmazonVerify();
                cookieHandle();
                ReusableMethods.wait(1);
            } else {
                System.out.println("Test başarısız.");
            }
        }

    }



   @Step("Samsung urun aramasi yapilir")
   public WebElement productSearch(String urun){

        ReusableMethods.wait(1);

       WebElement searchBox = Driver.getDriver().findElement(amazon_search_box);
       searchBox.sendKeys(ConfigReader.getProperty(urun));
       ReusableMethods.wait(1);
       Actions actions = new Actions(Driver.getDriver());
       ReusableMethods.wait(1);
       actions.sendKeys(Keys.ENTER).perform();
       ReusableMethods.wait(1);

       return searchBox;
   }

}
