package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    static Properties properties;

    /*
     Burada static yaparak config dosyası calisinca herseyden önce calisip verileri
     almasini sagladim "configuration.properties" directory'den

     */

    static {

        String dosyaYolu= "configuration.properties";
        try {

            FileInputStream fis= new FileInputStream(dosyaYolu);
            properties= new Properties();
            properties.load(fis);


        } catch (IOException e) {
            System.out.println("properties dosyasi okunamadi");
        }
    }

    public static String getProperty(String key){

        return properties.getProperty(key);

    }

}
