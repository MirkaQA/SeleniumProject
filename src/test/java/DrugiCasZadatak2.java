import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.DriverManager;
import java.time.Duration;

import static org.openqa.selenium.Keys.ENTER;

public class DrugiCasZadatak2 {

    public static void main(String[] args) throws InterruptedException {
        //Na sajtu https://cms.demo.katalon.com/
        //dodati u korpu "Patient ninja" proizvod i proveriti da li je dodat u korpu

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://cms.demo.katalon.com/");
        Object JavascriptExecutor;
       // JavascriptExecutor js = (JavascriptExecutor).driver;
        WebElement patientNinja = driver.findElement(By.id("66"));
        //js.executeScript(driver.findElement("arguments[0].scrollIntoView(true);"patientNinja));

        driver.findElement(By.id("66")).click();
        WebElement button = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/main/div[2]/ul/li[6]/div/a[2]"));
        WebDriverWait wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wdwait.until(ExpectedConditions.elementToBeClickable(button));
    }


}
