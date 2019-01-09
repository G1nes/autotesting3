import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class InsuranceTest extends TestLauncher {
    /*private WebDriver driver;
    private WebElement element;
    private String url = "https://www.sberbank.ru/ru/person";*/

    /*@Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","src\\driver\\chromedriver.exe");
        System.setProperty("webdriver.gecko.driver","src\\driver\\geckodriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }*/
    @Test
    public void testSberInsurance () throws Exception{
        driver.get(url);
        Wait<WebDriver>wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//li [@class='lg-menu__item']/*/span[text()='Страхование']"))));
        driver.findElement(By.xpath("//li [@class='lg-menu__item']/*/span[text()='Страхование']")).click();
        //driver.findElement(By.xpath("//*[text()='Страхование']")).click();
        driver.findElement(By.xpath("//*[text()='Путешествия и покупки']")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[text()='Страхование путешественников']"))));
        element = driver.findElement(By.xpath("//*[text()='Страхование путешественников']"));
        Assert.assertEquals("Страхование путешественников", element.getText());
        driver.findElement(By.xpath("//*[contains(@href, 'vzr')]")).click();
        //Переключится на открывшуюся вкладку
        ArrayList <String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        //Нажать чекбокс на против суммы минимальной суммы
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@ng-click='setProdProg(prodProg)']"))));
        driver.findElement(By.xpath("//div[@ng-click='setProdProg(prodProg)']")).click();
        //Нажать кнопку оформить
        driver.findElement(By.xpath("//SPAN[@ng-click='save()']")).click();
        //Заполняем поля
        fillField(By.name("insured0_surname"),"Kurumov");
        fillField(By.xpath("//input[@name='insured0_name']"),"Deni");
        fillField(By.name("insured0_birthDate"), "01011992");
        fillField(By.name("surname"),"Курумова");
        fillField(By.name("name"),"Мадина");
        fillField(By.name("middlename"), "НеЗнаюОтчества");
        fillField(By.name("birthDate"), "01011995");
        driver.findElement(By.name("female")).click();
        fillField(By.name("passport_series"),"1234");
        fillField(By.name("passport_number"),"123456");
        fillField(By.name("issueDate"),"01012010");
        fillField(By.name("issuePlace"),"01012010");
        driver.findElement(By.xpath("//span[@ng-click='save()']")).click();
        element = driver.findElement(By.xpath("//*[text()='Заполнены не все обязательные поля']"));
        Assert.assertEquals("Заполнены не все обязательные поля", element.getText());
    }
    /*@After
    public void clean (){
        driver.close();
        driver.quit();
    }*/
}
