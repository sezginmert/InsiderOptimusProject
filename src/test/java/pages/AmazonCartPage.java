package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class AmazonCartPage extends ReusableMethods{

    public AmazonCartPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // Bu kisim sayfa icin locators'lar, selenium 4 ten sonra kullanılan yöntem
    By goto_card_button = By.xpath("(//a[@class='a-button-text'])[3]");
    By cart_add = By.xpath("//*[@class='a-size-medium-plus a-color-base sw-atc-text a-text-bold']");
    By delete_button = By.xpath("//span[@class='a-size-small sc-action-delete']");
    By logo_homepage = By.id("nav-logo-sprites");

    // Bu kisim sayfa icin locators'lar, selenium 2'den ten sonra kullanılan yöntem
    @FindBy(id = "add-to-cart-button")
    public WebElement product_card_add_button;
    @FindBy(xpath = "//span[@id='sc-buy-box-ptc-button-announce']")
    public WebElement shopping_completion_button;

    //Burada degiskenler class seviyesinde tanımlandı her methodda olusturulmamak ve dinamik olmasi icin
    String expected;
    String actual;

    @Step("Sepete ürünü ekler ve dogrular")
    public void addToCartAndVerify() {

            ReusableMethods.wait(1);
            ReusableMethods.scrollToElement(product_card_add_button);
            Driver.getDriver().findElement(By.id("add-to-cart-button")).click();
            expected = ConfigReader.getProperty("expected_sepet");
            actual = Driver.getDriver().findElement(cart_add).getText();
            Assert.assertTrue(actual.contains(expected));
    }

    @Step("Sepete gider ve sepette oldugunu dogrular")
    public void goToCartAndVerifyProduct(){

            ReusableMethods.wait(1);
            Driver.getDriver().findElement(goto_card_button).click();
            ReusableMethods.wait(1);
            Assert.assertTrue(shopping_completion_button.isDisplayed());
            List<WebElement> cart_product_list = Driver.getDriver().findElements(By.xpath("//span[@class='a-truncate-cut']"));
            Assert.assertFalse(cart_product_list.isEmpty(),"Sepet,boş");
            Assert.assertTrue(cart_product_list.get(0).getText().toLowerCase().contains("galaxy"));
    }

    @Step("Sepetteki urunu siler ve dogrular")
    public void deleteProductAndVerify(){

            Driver.getDriver().findElement(delete_button).click();
            ReusableMethods.wait(1);
            List<WebElement> cart_product_list = Driver.getDriver().findElements(By.xpath("//span[@class='a-truncate-cut']"));
            Assert.assertTrue(cart_product_list.isEmpty(),"Urun silinmedi");
    }

    @Step("Anasayfaya geri döner ve dogrular")
    public void returnToHomeAndVerify(){

            Driver.getDriver().findElement(logo_homepage).click();
            expected = "Amazon";
            actual = Driver.getDriver().getTitle();
            Assert.assertTrue(actual.contains(expected));
    }

}
