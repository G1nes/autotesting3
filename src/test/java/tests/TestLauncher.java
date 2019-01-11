package tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import tests.pages.TestPropertiess;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestLauncher {
    public static Properties setProperties = TestPropertiess.getInstance().getProperties();
    public static WebDriver driver;
    public static String url;
    public static WebElement element;
    @BeforeClass
    public static void setUp () throws Exception{
        switch (setProperties.getProperty("browser")){
            case "firefox" :
                System.setProperty("webdriver.gecko.driver", setProperties.getProperty("webdriver.gecko.driver"));
                driver = new FirefoxDriver();
                break;
            case "chrome" :
                System.setProperty("webdriver.chrome.driver", setProperties.getProperty("webdriver.chrome.driver"));
                driver = new ChromeDriver();
                break;
                default:
                    System.setProperty("webdriver.chrome.driver", setProperties.getProperty("webdriver.chrome.driver"));
                    driver = new ChromeDriver();
                    break;
        }
        url = setProperties.getProperty("url");
        System.out.println(url);
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver .manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @AfterClass
    public static void cleaner ()throws Exception{
        driver.quit();
    }

    public void fillFieldByXpath (By locator, String value){
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(value);
    }
}
