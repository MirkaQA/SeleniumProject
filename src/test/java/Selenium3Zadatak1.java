import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Selenium3Zadatak1 {
    public static void main(String[] args) throws InterruptedException {
    //Napraviti automatski test koji ce se ulogovati na wordpress
      //  i proveriti da li je korisnik ulogovan

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://wordpress.com/");
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div/nav/ul[2]/li[1]/a")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("usernameOrEmail")).sendKeys("alfmirka");
        driver.findElement(By.cssSelector(".button.form-button.is-primary")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div/div/div[1]/div[1]/div/main/div/div/form/div[1]/div[1]/div/div/input")).sendKeys("itbootcamp");
        driver.findElement(By.cssSelector(".button.form-button.is-primary")).click();
        Thread.sleep(3000);
        String ocekivaniURL = "https://wordpress.com/read";
        WebElement dobrodoslica = driver.findElement(By.cssSelector(".gravatar.masterbar__item-me-gravatar"));
        Assert.assertTrue(dobrodoslica.isDisplayed());
       Assert.assertEquals(ocekivaniURL, driver.getCurrentUrl());



    }
}
