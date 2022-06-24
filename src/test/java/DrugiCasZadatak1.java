import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class DrugiCasZadatak1 {
    public static void main(String[] args) throws InterruptedException {

       // Pokrenuti browser, otici na google, otvoriti jos 2 taba,
        //u drugom otici na youtube,
        //u trecem otici na linkedin. Nakon toga zatvoriti sve tabove posebno.

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String google = "https://www.google.com/?gws_rd=ssl";
        String youtube = "https://www.youtube.com/";
        String linkedin = "https://www.linkedin.com/";
        driver.get(google);

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.open()");
        js.executeScript("window.open()");
        //js.executeScript("window.open()");
        ArrayList<String> listaTabova = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(listaTabova.get(1));
        driver.get(youtube);
        driver.switchTo().window(listaTabova.get(2));
        driver.get(linkedin);
       driver.close();
       driver.switchTo().window(listaTabova.get(1));
       driver.close();
       driver.switchTo().window(listaTabova.get(0));
       driver.close();
       Thread.sleep(2000);
       driver.quit();




    }
}
