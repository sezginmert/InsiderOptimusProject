package tests;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AmazonCartPage;
import pages.AmazonHomePage;
import pages.AmazonProductPage;
import pages.AmazonSelectedProduct;
import utilities.Driver;

public class AmazonTest extends AmazonSelectedProduct{

    /*
      Lütfen Projeyi çalistirmadan önce gereklilikler ve
      bilgilendirmeler için README.md dosyasını okuyunuz.
      Daha iyi analiz etme adına türkce olusturulmustur
    */

    AmazonCartPage cartPage;
    AmazonHomePage homePage;
    AmazonProductPage productPage;
    AmazonSelectedProduct amazonSelectedProduct;


    // Burası objeleri olusturmak icin Test methodun'dan once calisicak
    @BeforeTest
    public void setUp(){

        cartPage = new AmazonCartPage();
        homePage = new AmazonHomePage();
        productPage = new AmazonProductPage();
        amazonSelectedProduct = new AmazonSelectedProduct();
    }


    @Test(description = "Amazon.com'da sepete ürün ekleme ve silme işlemi yapip geri anasayfaya dönme kontrolü")
    public void amazon_shopping_test(){

        homePage.goToAmazonVerify();
        homePage.cookieHandle();
        homePage.productSearch("product");
        productPage.productVerifyFound();
        productPage.goToSecondPage();
        amazonSelectedProduct.selectThirdProduct(3);
        amazonSelectedProduct.selectedProductVerify();
        cartPage.addToCartAndVerify();
        cartPage.goToCartAndVerifyProduct();
        cartPage.deleteProductAndVerify();
        cartPage.returnToHomeAndVerify();
    }


    // Burasi test bittikten sonra acik olan driveri kapatmak icin test methodun'dan sonra calisicak
    @AfterTest
    public void tearDown(){
        Driver.quitDriver();
    }
}
