
    /*

     Amazonda otomasyonla gidilince iki farklı arayüz gelebiliyor olması gereken arayüz cookie olan
     indirilip ilk calistirildigindan dolayi tarayici'da url olarak hata alınabilir. Ancak 2. calistirmada sorun olmicaktir.
     Hata alınırsa extra testng.xml dosyası olusturdum oradan calistirilabilir gerekli bilgiler xml file'a yazıldı.

     */

Projede @By notasyonu ve @FindBy notasyonu kullanildi ikiside projede locat almak icin kullanildi birisi selenium 4den sonra geldi projenin daha fazla dinamik olmasi icin böyle bir yol izledim.


## 🚀 Kullanılan Teknolojiler
- **Java 17 coretto**
- **Selenium WebDriver**
- **TestNG**
- **Allure Report**
- **Maven**
- **testng.xml**


Test sonuçlarını Intellij IDEA terminale : `allure serve ` yazıp enter ile görüntüleyebilirsin.



## 📌 Test Case Steps

1. Go to https://www.amazon.com.tr/
2. Verify that you are on the home page
3. Type 'samsung' in the search field at the top of the screen and perform search.
4. Verify that there are results for Samsung on the page that appears.
5. Click on the 2nd page from the search results and verify that the 2nd page is
   currently displayed on the page that opens.
6. Go to the 3rd Product page from the top
7. Verify that you are on the product page
8. Add the product to the cart
9. Verify that the product has been added to the cart
10. Go to the cart page
11. Verify that you are on the cart page and that the correct product has been added to
    the cart
12. Delete the product from the cart and verify that it has been deleted
13. Return to the home page and verify that it is on the home page