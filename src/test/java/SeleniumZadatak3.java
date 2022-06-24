import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.EdgeDriverManager;
import jdk.jshell.spi.ExecutionControl;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import static org.openqa.selenium.Keys.ENTER;

public class SeleniumZadatak3 {
    public static void main(String[] args) throws InterruptedException {
        //Otvoriti browser, otici na google, pretraziti "itbootcamp",
          //      otvoriti prvi link i asertovati URL

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).sendKeys("itbootcamp");
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).sendKeys(ENTER);
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[7]/div/div[10]/div/div[2]/div[2]/div/div/div[1]/div/div/div/div/div/div[1]/a/h3")).click();

        String ocekivaniURL = "https://itbootcamp.rs/?script=cir";
        String dobijeniURL = driver.getCurrentUrl();
        Assert.assertEquals(dobijeniURL, ocekivaniURL);

        String ocekivaniNaslov = "Obrazovanje je najbolja investicija";
        String dobijeniNaslov = driver.findElement(By.xpath("/html/body/div/div/div/div/main/article/div/div[3]/div[1]/div/div[1]/div/div/div/div/div/div/div/h2")). getText();
        Assert.assertEquals(dobijeniNaslov, ocekivaniNaslov);

        WebElement slika = driver.findElement(By.xpath("/html/body"));
        Assert.assertTrue(slika.isDisplayed());

    }
}
