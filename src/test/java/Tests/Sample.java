package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class Sample {
    public static void main(String[] args) {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.santanderbank.com/");
        driver.manage().window().maximize();
        WebElement location = driver.findElement(By.xpath("//a" +
                "[@href='https://locations.santanderbank.com/']"));
        location.click();
        driver.findElement(By.id("q")).sendKeys("washington");
        Actions a = new Actions(driver);
        WebElement move = driver.findElement(By.id("ui-id-10']"));
        a.moveToElement(move).click().perform();
        driver.findElement(By.xpath("(//a[@class = 'more-info ga-link'])[2]")).click();
        String Title = driver.getTitle();
        System.out.println("The Title is : " + Title);
       WebElement enroll = driver.findElement(By.xpath("//button[@class='online-banking-button']"));
        JavascriptExecutor je = (JavascriptExecutor)driver;
        je.executeScript("je.arguments[0].scrollIntoView(false)", enroll);
        je.executeScript("je.arguments[0].click()", enroll);

    }

}
