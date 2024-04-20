package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Automation {
    public static void main(String[] args) throws InterruptedException {
       WebDriverManager.edgedriver().setup();
        EdgeDriver driver = new EdgeDriver();
        Thread.sleep(3000);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://www.google.com");
        System.out.println(driver.getTitle());
        Thread.sleep(3000);
       WebElement txt = driver.findElementByXPath("//textarea[@class = 'gLFyf'] ");
       txt.sendKeys("javapoint", Keys.ENTER);
       Thread.sleep(3000);
        Actions a = new Actions(driver);
       WebElement ele = driver.findElementByXPath("//span[@class='VuuXrf']");
       a.moveToElement(ele).click().perform();
        System.out.println(driver.getTitle());
       driver.close();
    }
}
