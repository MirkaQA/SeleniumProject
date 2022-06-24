import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class SeleniumDomaciZadatak2 {

    public static void main(String[] args) {
        //Otici na sajt https://s1.demo.opensourcecms.com/wordpress/
        //Naci comment sekciju. Ostaviti komentar. Assertovati da li je komentar prikazan na stranici.

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.navigate().to("https://s1.demo.opensourcecms.com/wordpress/");
        WebElement helloWorld = driver.findElement(By.xpath("/html/body/div/main/ul/li/div/h2/a"));
        wdwait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/main/ul/li/div/h2/a")));
        Assert.assertTrue(helloWorld.isDisplayed());
        helloWorld.click();
        WebElement comment = driver.findElement(By.id("comment"));
        wdwait.until(ExpectedConditions.visibilityOf(comment));
        js.executeScript("arguments[0].scrollIntoView(true);", comment);
        comment.sendKeys("Divan pogled na kanjon odavde...ODAVDE!!!");
        driver.findElement(By.xpath("/html/body/div/main/div[5]/div[3]/div[3]/form/p[3]/input")).sendKeys("Sima Kosmos iz dalekog svemira");
        driver.findElement(By.xpath("/html/body/div/main/div[5]/div[3]/div[3]/form/p[4]/input")). sendKeys("siminkosmos@yahoo.com");
        driver.findElement(By.id("submit")).click();
        wdwait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("comment-awaiting-moderation"))));
        WebElement awaitingModeration = driver.findElement(By.className("comment-awaiting-moderation"));
        Assert.assertEquals(awaitingModeration.getText(),"Your comment is awaiting moderation. This is a preview; your comment will be visible after it has been approved.");

    }
}
