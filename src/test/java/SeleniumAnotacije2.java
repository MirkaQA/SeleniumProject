import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.build.Plugin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class SeleniumAnotacije2 {
    WebDriver driver;
    WebDriverWait wdwait;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @BeforeMethod
    public void SetUpPage() throws InterruptedException {
        driver.manage().window().maximize();
        driver.navigate().to("https://practicetestautomation.com/");
        Thread.sleep(5000);
    }

    @Test (priority = 10)
    public void HappyPath() throws InterruptedException {
        driver.findElement(By.id("menu-item-20")).click();
        wdwait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText("Test Login Page"))));
        driver.findElement(By.xpath("/html/body/div/div/section/div/div/article/div[2]/div[1]/div[1]/p/a")).click();

        WebElement username = driver.findElement(By.xpath("/html/body/div/div/section/section/div[1]/div[1]/input"));
        WebElement password = driver. findElement((By.xpath("/html/body/div/div/section/section/div[1]/div[2]/input")));
        WebElement submitButton = driver.findElement(By.className("btn"));

        username.sendKeys("student");
        password.sendKeys("Password123");
        submitButton.click();

        WebElement logOutButton = driver.findElement(By.cssSelector(".wp-block-button__link.has-text-color.has-background.has-very-dark-gray-background-color"));
        Assert.assertTrue(logOutButton.isDisplayed());
    }

    @Test (priority = 20)
    public void WrongUsername() throws InterruptedException {
        driver.findElement(By.id("menu-item-20")).click();
        wdwait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText("Test Login Page"))));
        driver.findElement(By.xpath("/html/body/div/div/section/div/div/article/div[2]/div[1]/div[1]/p/a")).click();

        WebElement username = driver.findElement(By.xpath("/html/body/div/div/section/section/div[1]/div[1]/input"));
        WebElement password = driver. findElement((By.xpath("/html/body/div/div/section/section/div[1]/div[2]/input")));
        WebElement submitButton = driver.findElement(By.className("btn"));

        username.sendKeys("Student");
        password.sendKeys("Password123");
        submitButton.click();
        Thread.sleep(2000);
        WebElement errorMessage = driver.findElement(By.xpath("/html/body/div/div/section/section/div[2]"));
        Assert.assertTrue(errorMessage.isDisplayed());

    }

    @Test (priority = 25)
    public void BlankUsername() throws InterruptedException {
        driver.findElement(By.id("menu-item-20")).click();
        wdwait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText("Test Login Page"))));
        driver.findElement(By.xpath("/html/body/div/div/section/div/div/article/div[2]/div[1]/div[1]/p/a")).click();

        WebElement password = driver. findElement((By.xpath("/html/body/div/div/section/section/div[1]/div[2]/input")));
        WebElement submitButton = driver.findElement(By.className("btn"));

        password.sendKeys("Password123");
        submitButton.click();
        Thread.sleep(2000);
        WebElement errorMessage = driver.findElement(By.xpath("/html/body/div/div/section/section/div[2]"));
        Assert.assertTrue(errorMessage.isDisplayed());

    }

    @Test (priority = 30)
    public void WrongPassword() throws InterruptedException {
        driver.findElement(By.id("menu-item-20")).click();
        wdwait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText("Test Login Page"))));
        driver.findElement(By.xpath("/html/body/div/div/section/div/div/article/div[2]/div[1]/div[1]/p/a")).click();

        WebElement username = driver.findElement(By.xpath("/html/body/div/div/section/section/div[1]/div[1]/input"));
        WebElement password = driver. findElement((By.xpath("/html/body/div/div/section/section/div[1]/div[2]/input")));
        WebElement submitButton = driver.findElement(By.className("btn"));

        username.sendKeys("student");
        password.sendKeys("111111");
        submitButton.click();
        Thread.sleep(2000);
        WebElement errorMessage = driver.findElement(By.xpath("/html/body/div/div/section/section/div[2]"));
        Assert.assertTrue(errorMessage.isDisplayed());
    }

    @Test (priority = 40)
    public void BlankFields() throws InterruptedException {
        driver.findElement(By.id("menu-item-20")).click();
        wdwait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText("Test Login Page"))));
        driver.findElement(By.xpath("/html/body/div/div/section/div/div/article/div[2]/div[1]/div[1]/p/a")).click();

        WebElement username = driver.findElement(By.xpath("/html/body/div/div/section/section/div[1]/div[1]/input"));
        WebElement password = driver. findElement((By.xpath("/html/body/div/div/section/section/div[1]/div[2]/input")));
        WebElement submitButton = driver.findElement(By.className("btn"));

        submitButton.click();
        Thread.sleep(2000);
        WebElement errorMessage = driver.findElement(By.xpath("/html/body/div/div/section/section/div[2]"));
        Assert.assertTrue(errorMessage.isDisplayed());
    }

    @AfterMethod
    public void Cookies(){
        driver.manage().deleteAllCookies();
    }

    @AfterClass
    public void CloseAndQuit(){
        driver.close();
        driver.quit();
    }

}
