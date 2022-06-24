import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class SeleniumMeme {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.navigate().to("https://imgflip.com/memegenerator");
        wdwait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("mm-show-upload"))));
        WebElement uploadButton = driver.findElement(By.id("mm-show-upload"));
        uploadButton.click();
        wdwait.until(ExpectedConditions.elementToBeClickable(By.id("mm-upload-btn")));
        WebElement uploadButton2 = driver.findElement(By.id("mm-upload-file"));
        uploadButton2.sendKeys("C:\\Users\\Stevan\\Desktop\\IT Boot Camp\\6iif31.jpg");
        WebElement uploadButton3 = driver.findElement(By.id("mm-upload-btn"));
        uploadButton3.click();
        wdwait.until(ExpectedConditions.elementToBeClickable(By.className("mm-text")));
        WebElement text = driver.findElement(By.className("mm-text"));
        text.sendKeys("Ovo je tekst koji hocu da postavim na fotku");

        WebElement generateMeme = driver.findElement(By.cssSelector(".mm-generate.b.but"));
        generateMeme.click();

}
}

