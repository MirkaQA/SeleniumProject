import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Selenium3Zadatak2 {

    public static void main(String[] args) throws InterruptedException {
        //Zadatak 2 - Ulogovati se na sajt https://demoqa.com/
        // preko kolacica, izlogovati se i asertovati da je korisnik izlogovan
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/login");
        Thread.sleep(5000);
        //JavascriptExecutor js = (JavascriptExecutor) driver;
       // driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[6]/div/ul/li[1]")).click();
        Cookie cookie1 = new Cookie("userName", "Alfmirka");
        Cookie cookie2 = new Cookie("userID", "b4c9575c-ef60-4e26-9f05-bcff6b51f15a");
        Cookie cookie3 = new Cookie("expires", "2022-06-10T09%3A35%3A49.376Z");
        Cookie cookie4 = new Cookie("token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6ImFsZm1pcmthIiwicGFzc3dvcmQiOiJBbGZtaXJrYTEzISIsImlhdCI6MTY1NDI0ODk0OX0.QkBoQUO6yqRe6_KcRnbmnaCiEMUzY671WduGSvaQlSE");
        driver.manage().addCookie(cookie1);
        driver.manage().addCookie(cookie2);
        driver.manage().addCookie(cookie3);
        driver.manage().addCookie(cookie4);
        driver.navigate().refresh();
        Thread.sleep(2000);

        WebElement logOutButton = driver.findElement(By.id("submit"));
        Assert.assertTrue(logOutButton.isDisplayed());

        //WebElement expectedUsername = driver.findElement(By.id("userName-value"));
        //String actualUsername = expectedUsername.getText();
        //Assert.assertEquals(actualUsername, expectedUsername);

        driver.manage().deleteCookieNamed(cookie4.getName());

    }
}
