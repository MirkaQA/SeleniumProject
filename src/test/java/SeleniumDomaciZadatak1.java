import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SeleniumDomaciZadatak1 {
    public static void main(String[] args) throws InterruptedException {
        //Napraviti program koji ce dodati ovaj proizvod u korpu
        // https://www.amazon.com/Selenium-Framework-Design-Data-Driven-Testing/dp/1788473574/ref=sr_1_2?dchild=1&keywords=selenium+test&qid=1631829742&sr=8-2
        //zatim obrisati proizvod brisanjem cookie-a i proveriti da li je korpa prazna

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.amazon.com/Selenium-Framework-Design-Data-Driven-Testing/dp/1788473574/ref=sr_1_2?dchild=1&keywords=selenium+test&qid=1631829742&sr=8-2");
        Thread.sleep(5000);
        Cookie cookie1 = new Cookie("session-id", "137-4124455-0249946");
        Cookie cookie2 = new Cookie("session-token", "wKQxB5elQ43OtA+E8Tfrw3EQTbZ+gvW37kQ6WBXW/VQuWTjP/9pF9iwbC4e5LKDpxBSkD1kyoOUllyuAl96+4ExK6JT1XwxjOU+o1e3vlPT86+IA4qUM/nBJhj0qGSaa/fM3JJTyvY0S70Ws8CbcI+Ua1GlobgQ6I+gByj8O2LgbcP4oWzITgb7SdzfBgxd3OHJq8eh4RLdCm9aGbgTnWVwNqM8cSew96I5cQ5lVEhX9TRtktDiF9SDEHnlN8Web");
        Cookie cookie3 = new Cookie("session-id-time","2082787201l");
        Cookie cookie4 = new Cookie("i18n-prefs", "i18n-prefs");
        Cookie cookie5 = new Cookie("csm-hit", "tb:s-VHPZGF9ND3PKBJPMVX5C|1654268456059&t:1654268456096&adb:adblk_no");
        Cookie cookie6 = new Cookie("ubid-main","133-2566211-1123857");
        Cookie cookie7 = new Cookie("sp-cdn","L5Z9:RS");


        driver.manage().addCookie(cookie1);
        driver.manage().addCookie(cookie2);
        driver.manage().addCookie(cookie3);
        driver.manage().addCookie(cookie4);
        driver.manage().addCookie(cookie5);
        driver.manage().addCookie(cookie6);
        driver.manage().addCookie(cookie7);
        driver.navigate().refresh();
        WebElement cartAfterAdding = driver.findElement(By.id("nav-cart-count"));
        Assert.assertEquals(cartAfterAdding.getText(), "1");
        driver.manage().deleteCookieNamed("session-id");



    }
}
