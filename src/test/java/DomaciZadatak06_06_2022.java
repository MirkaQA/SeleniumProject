import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class DomaciZadatak06_06_2022 {
    //Zadatak za Wordpress koji smo radili treba uraditi ponovo
    //sa anotacijama i napraviti test kejseve za neuspesan login

    WebDriver driver;
    WebDriverWait wdwait;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @BeforeMethod
    public void PageSetUp() throws InterruptedException {
        driver.manage().window().maximize();
        driver.navigate().to("https://wordpress.com/");
        Thread.sleep(2000);
        wdwait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div/nav/ul[2]/li[1]/a"))));
        WebElement logInButton = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div/nav/ul[2]/li[1]/a"));
        logInButton.click();
    }

    @Test(priority = 10)
    public void HappyPath() throws InterruptedException {
        Thread.sleep(2000);
        WebElement usernameField = driver.findElement(By.className("form-text-input"));
        WebElement continueButton = driver.findElement(By.cssSelector(".button.form-button.is-primary"));
        usernameField.sendKeys("alfmirka");
        continueButton.click();
        Thread.sleep(1500);

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("itbootcamp");
        WebElement logInButton = driver.findElement(By.cssSelector(".button.form-button.is-primary"));
        logInButton.click();
        Thread.sleep(4000);

        WebElement profileButton = driver.findElement(By.cssSelector(".gravatar.masterbar__item-me-gravatar"));
        Assert.assertTrue(profileButton.isDisplayed());
        String welcome = "Добродошли у Читалац";
        WebElement welcomeMessage = driver.findElement(By.className("empty-content__title"));
        Assert.assertEquals(welcomeMessage.getText(), welcome);


    }

    @Test(priority = 20)
    public void wrongUsername() throws InterruptedException {
        Thread.sleep(2000);
        WebElement usernameField = driver.findElement(By.className("form-text-input"));
        WebElement continueButton = driver.findElement(By.cssSelector(".button.form-button.is-primary"));
        usernameField.sendKeys("wrong");
        continueButton.click();
        Thread.sleep(1500);

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("itbootcamp");
        WebElement logInButton = driver.findElement(By.cssSelector(".button.form-button.is-primary"));
        logInButton.click();
        Thread.sleep(3000);

        boolean check = false;
        try {
            check = driver.findElement(By.xpath("/html/body/div[1]/div/header/div[3]/a[1]/span/img")).isDisplayed();
        } catch (Exception e) {
        }
        Assert.assertFalse(check);
    }

    @Test (priority = 30)
    public void WrongPassword() throws InterruptedException {
        Thread.sleep(2000);
        WebElement usernameField = driver.findElement(By.className("form-text-input"));
        WebElement continueButton = driver.findElement(By.cssSelector(".button.form-button.is-primary"));
        usernameField.sendKeys("alfmirka");
        continueButton.click();
        Thread.sleep(1500);
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("wrongPassword");
        WebElement logInButton = driver.findElement(By.cssSelector(".button.form-button.is-primary"));
        logInButton.click();
        Thread.sleep(3000);

        boolean check = false;
        try {
            check = driver.findElement(By.xpath("/html/body/div[1]/div/header/div[3]/a[1]/span/img")).isDisplayed();
        } catch (Exception e) {
        }
        Assert.assertFalse(check);

    }

    @Test (priority = 40)
    public void BlankFields() throws InterruptedException {
        Thread.sleep(2000);
        WebElement usernameField = driver.findElement(By.className("form-text-input"));
        WebElement continueButton = driver.findElement(By.cssSelector(".button.form-button.is-primary"));
        continueButton.click();
        Thread.sleep(1500);
        WebElement exclamationMark = driver.findElement(By.cssSelector(".gridicon.gridicons-notice-outline"));
        Assert.assertTrue(exclamationMark.isDisplayed());
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