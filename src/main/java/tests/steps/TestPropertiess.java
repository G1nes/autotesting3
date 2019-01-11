package tests.steps;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestPropertiess {
    private static WebDriver driver;
    public static WebDriver getDriver(){
        return driver;
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
}
