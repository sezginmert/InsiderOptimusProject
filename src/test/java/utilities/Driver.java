package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {

    // Constructor'i gorunur yapip, kimsenin erisememesi icin private yaptim
    private Driver(){

    }

    public static WebDriver driver;

    public static WebDriver getDriver(){

        /*
           Burada configReader dosyasindan calisacagimiz driver browseri aliyoruz
           configde "configurations.properties" directory'den aliyor verileri

         */

        String calisacakBrowser = ConfigReader.getProperty("browser");

        if (driver == null){

            switch (calisacakBrowser){

                case "safari" :
                    driver = new SafariDriver();
                    break;

                case "edge" :
                    driver = new EdgeDriver();
                    break;

                case "firefox" :
                    driver = new FirefoxDriver();
                    break;

                default:
                    driver = new ChromeDriver();

            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        }


        return driver;
    }


    // quitDriver methodu cagirdigimizda sayfayi tamamen kapatiyor
    // ve kapatinca driver'a null degeri atiyor
    public static void quitDriver(){
        driver.quit();
        driver=null;
    }
}
