package com.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

    protected static WebDriver driver;
    Select select;

    // to get the path of the project file
    public String getPropertyPath() {
        String path = System.getProperty("user.dir");
        return path;
    }

    // to get the path of the cofig property file path
    public String getPropertyFileValue(String key) throws IOException {
        // FileInputStream stream = new FileInputStream(getPropertyPath() +
        // "\\Config\\Config.properties");
        Properties properties = new Properties();
        properties.load(new FileInputStream(getPropertyPath() + "\\Config\\Config.properties"));
        return (String) properties.get(key);

    }

    // Implicit wait
    public void implicitWait() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    // Explicit Wait

    public void elementVisibility(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    // 1
    public static void browserLaunch(String browserType) {
        switch (browserType) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "ie":
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;

            default:
                break;
        }
    }

    public void getBrowser(String url) {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.get(url);
    }

    // 2
    public WebElement findElementId(String id) {

        WebElement element = driver.findElement(By.id(id));
        return element;
    }

    // 3
    public WebElement findElementName(String name) {
        WebElement element = driver.findElement(By.name(name));
        return element;
    }

    // 4
    public WebElement findElementXpath(String xpathExpression) {
        WebElement element = driver.findElement(By.xpath(xpathExpression));
        return element;
    }

    // 5
    public void sendvalues(WebElement element, String data) {
        elementVisibility(element);
        element.sendKeys(data);

    }

    // 6
    public void click(WebElement element) {
        element.click();
    }

    // 7
    public String elementGetText(WebElement element) {
        String text = element.getText();
        return text;
    }




    // 8
    public String getAttribute(WebElement element) {
        String attribute = element.getAttribute("value");
        return attribute;
    }

    // 9
    public void moveElements(WebElement target) {
        Actions actions = new Actions(driver);
        actions.moveToElement(target);

    }

    // 10
    public void dropDown(WebElement source, WebElement target) {
        Actions actions = new Actions(driver);
        Actions dragAndDrop = actions.dragAndDrop(source, target);
        dragAndDrop.perform();
    }

    // 11
    public void rightClick(WebElement target) {
        Actions actions = new Actions(driver);
        actions.contextClick(target).perform();
    }

    // 12
    public void doubleclick(WebElement target) {
        Actions actions = new Actions(driver);
        actions.doubleClick(target).perform();
    }

    // 13
    public void alertAccept() {
        driver.switchTo().alert().accept();
    }

    // 14
    public String getTitle() {
        String title = driver.getTitle();
        return title;
    }

    // 15
    public String getCurrenturl() {
        String currentUrl = driver.getCurrentUrl();
        return currentUrl;
    }

    // 16
    public void sleep(int millis) throws InterruptedException {
        Thread.sleep(millis);
    }

    // 17
    public void robotKeyPress(int keycode) throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(keycode);
    }

    // 18
    public void robotkeyrelease(int keycode) throws AWTException {
        Robot robot = new Robot();
        robot.keyRelease(keycode);
    }

    // 19
    public void keyDown(CharSequence key) {
        Actions actions = new Actions(driver);
        actions.keyDown(key);
    }

    // 20

    public void keyUp(CharSequence key) {
        Actions actions = new Actions(driver);
        actions.keyUp(key);
    }

    // 21

    public void alertDismiss() {
        driver.switchTo().alert().dismiss();
    }

    // 22
    public void maximizeWindow() {
        driver.manage().window().maximize();
    }

    // 23
    public void clear(WebElement element) {
        element.clear();
    }

    // 24
    public File getScreenShotAs(String pathName) {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File File = screenshot.getScreenshotAs(OutputType.FILE);
        return File;
    }

    // 25
    public File screenShotWebElement(WebElement element) {
        File screenshotAs = element.getScreenshotAs(OutputType.FILE);
        return screenshotAs;
    }

    // 26
    public void copyPasteFile(String source, String destination) throws IOException {
        File s = new File(source);
        File d = new File(destination);
        FileUtils.copyFile(s, d);
    }

    // 27
    public void urlNavigation(String url) {
        driver.navigate().to(url);
    }

    // 28
    public void urlNavigationForward() {
        driver.navigate().forward();
    }

    // 29
    public void urlNavigationBack() {
        driver.navigate().back();
    }

    // 30
    public void urlNavigationRefresh() {
        driver.navigate().refresh();
    }

    // 31
    public void selectByIndex(WebElement element, int index) {
        select.selectByIndex(index);
    }

    // 32
    public void selectByVisibleText(WebElement element, String text) {
        Select s = new Select(element);
        s.selectByVisibleText(text);
    }

    // 33
    public void selectByValue(WebElement element, String value) {
        select.selectByValue(value);
    }

    // 34
    public List<WebElement> getOptions(WebElement element) {
        List<WebElement> options = select.getOptions();
        return options;
    }

    // 35
    public List<WebElement> getAllSelectedOption(WebElement element) {
        List<WebElement> allSelectedOptions = select.getAllSelectedOptions();
        return allSelectedOptions;
    }

    // 36
    public WebElement getFirstSelectedrOption(WebElement element) {
        WebElement firstSelectedOption = select.getFirstSelectedOption();
        return firstSelectedOption;
    }

    // 37
    public boolean isMultiple(WebElement element) {
        boolean multiple = select.isMultiple();
        return multiple;
    }

    // 38
    public void deselectByIndex(WebElement element, int index) {
        select.deselectByIndex(index);
    }

    // 39
    public void deselectAll(WebElement element) {
        select.deselectAll();
    }

    // 40
    public void deselectByValue(WebElement element, String value) {
        select.deselectByValue(value);
    }

    // 41
    public void deselectByText(WebElement element, String text) {
        select.deselectByVisibleText(text);
    }

    // 42
    public void SwitchToFrameByNameOrId(String NameOrId) {
        driver.switchTo().frame(NameOrId);
    }

    // 43
    public void SwitchToFrameByIndex(int index) {
        driver.switchTo().frame(index);
    }

    // 44
    public void switchToFrameByWebElement(WebElement frameElement) {
        driver.switchTo().frame(frameElement);
    }

    // 45
    public void defaultContent() {
        driver.switchTo().defaultContent();
    }

    // 46
    public String getWindowHandle() {
        String parentWinId = driver.getWindowHandle();
        return parentWinId;
    }

    // 47
    public Set<String> getWindowHandles() {
        Set<String> allWinId = driver.getWindowHandles();
        return allWinId;
    }

    // 48
    public void switchToWindow(String nameOrHandle) {
        driver.switchTo().window(nameOrHandle);
    }

    // 49
    public void close() {
        driver.close();
    }

    // 50
    public void waitMethod() throws InterruptedException {
        driver.wait();
    }

    // 51
    public void excelRead(String pathname, String sheetName, int rowNo, int cellNo) throws IOException {
        File file = new File(pathname);
        FileInputStream inputStream = new FileInputStream(file);
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheet(sheetName);
        Row row = sheet.getRow(rowNo);
        Cell cell = row.getCell(cellNo);

    }

    // 52
    public String getDataFromExcel(String pathname, String sheetname, int rowNo, int cellNo) throws IOException {

        String data = null;
        File file = new File(pathname);
        FileInputStream inputStream = new FileInputStream(file);

        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheet(sheetname);

        Row row = sheet.getRow(rowNo);
        Cell cell = row.getCell(cellNo);

        CellType cellType = cell.getCellType();

        String value = "";

        if (cellType.toString() == "1") {

            data = cell.getStringCellValue();
        }

        if (cellType.toString() == "0") {

            if (DateUtil.isCellDateFormatted(cell)) {
                Date dateCellValue = cell.getDateCellValue();
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mmm-yyyy");
                dateFormat.format(dateCellValue);
            }

            else {
                double db = cell.getNumericCellValue();
                long l = (long) db;
                data = String.valueOf(l);
            }
            return data;
        }
        return data;
    }

}
