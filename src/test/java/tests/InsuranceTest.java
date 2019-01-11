package tests;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class InsuranceTest extends TestLauncher {
    @Test
    @Ignore
    public void testSberInsurance () throws Exception{
        driver.get(url);
        Wait<WebDriver>wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//li [@class='lg-menu__item']/*/span[text()='Страхование']"))));
        driver.findElement(By.xpath("//li [@class='lg-menu__item']/*/span[text()='Страхование']")).click();
        driver.findElement(By.xpath("//*[text()='Путешествия и покупки']")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[text()='Страхование путешественников']"))));
        element = driver.findElement(By.xpath("//*[text()='Страхование путешественников']"));
        driver.findElement(By.xpath("//*[contains(@href, 'vzr')]")).click();
        Assert.assertEquals("Страхование путешественников", element.getText());
        //Переключится на открывшуюся вкладку
        ArrayList <String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        //Нажать чекбокс на против суммы минимальной суммы
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@ng-click='setProdProg(prodProg)']"))));
        driver.findElement(By.xpath("//div[@ng-click='setProdProg(prodProg)']")).click();
        //Нажать кнопку оформить
        driver.findElement(By.xpath("//SPAN[@ng-click='save()']")).click();
        //Заполняем поля
        fillFieldByXpath(By.name("insured0_surname"),"Kurumov");
        fillFieldByXpath(By.xpath("//input[@name='insured0_name']"),"Deni");
        fillFieldByXpath(By.name("insured0_birthDate"), "01011992");
        fillFieldByXpath(By.name("surname"),"Курумова");
        fillFieldByXpath(By.name("name"),"Мадина");
        fillFieldByXpath(By.name("middlename"), "НеЗнаюОтчества");
        fillFieldByXpath(By.name("birthDate"), "01011995");
        driver.findElement(By.name("female")).click();
        fillFieldByXpath(By.name("passport_series"),"1234");
        fillFieldByXpath(By.name("passport_number"),"123456");
        fillFieldByXpath(By.name("issueDate"),"01012010");
        fillFieldByXpath(By.name("issuePlace"),"01012010");
        driver.findElement(By.xpath("//span[@ng-click='save()']")).click();
        element = driver.findElement(By.xpath("//*[text()='Заполнены не все обязательные поля']"));
        Assert.assertEquals("Заполнены не все обязательные поля", element.getText());
    }
}
