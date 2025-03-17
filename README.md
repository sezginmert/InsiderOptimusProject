# **Amazon Test Otomasyonu**

    /*
         Amazon'da otomasyonla işlem yapıldığında iki farklı arayüzle karşılaşılabilir. Olması gereken arayüz, 
         cookie'lerin oldugu arayüz olmali ve ilk çalıştırıldığında tarayıcıda hatası alabileceğiniz bir durum yaratabilir.
         Ancak, ikinci çalıştırmada sorun yaşanmayacaktır. Eğer hata alırsanız, ekstra bir testng.xml dosyası oluşturdum; 
         bu dosya üzerinden çalıştırılabilir ve gerekli bilgiler XML dosyasına yazılmıştır.

     */

📌 Projede @By notasyonu ve @FindBy notasyonu kullanildi ikiside projede locat almak icin kullanildi birisi selenium 4den sonra geldi projenin daha fazla dinamik olmasi icin böyle bir yol izledim.

📌 Test sonuçlarını Intellij IDEA terminale : `allure serve ` yazıp enter ile görüntüleyebilirsin.

📌 Test adımları icin ekstra beklemeler yerlestirdim internet hızlarından kaynakli hatalari azaltmak icin


## 🚀 Technology Tools Used
- **Java 17 coretto**
- **Selenium WebDriver**
- **TestNG**
- **Allure Report**
- **Maven**
- **testng.xml**


## 📌 Project Timeline
- **Week 1: Requirement analysis and tool selectioni**
- **Week 1: Framework design and setup.**
- **Week 1: Script development and initial test execution.**




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