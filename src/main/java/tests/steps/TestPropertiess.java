package tests.steps;

import io.qameta.allure.Attachment;
import org.junit.AfterClass;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class TestPropertiess {
    private static WebDriver driver;
    public static WebDriver getDriver(){
        return driver;
    }
    public void nextTab (){
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }
    @Before
    public void startTest(){
        System.setProperty("webdriver.chrome.driver","src\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.sberbank.ru/ru/person");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
    @AfterClass
    public static void endTest(){
        driver.quit();
    }
    //@Attachment(type = "image/png",value = "Screenshot")
    //public static byte [] takeScreenshot(){mvn
    //    return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    //}
}
