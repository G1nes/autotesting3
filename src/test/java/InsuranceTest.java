import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class InsuranceTest extends TestLauncher {
    @Test
    public void testSberInsurance () throws Exception{
        driver.get(url);
        //Wait<WebDriver>wait = new WebDriverWait(driver,5);
        //wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//li [@class='lg-menu__item']/*/span[text()='Страхование']"))));
        //driver.findElement(By.xpath("//li [@class='lg-menu__item']/*/span[text()='Страхование']")).click();
        //driver.findElement(By.xpath("//*[text()='Путешествия и покупки']")).click();
        MainPage mainPage = new MainPage(driver);
        mainPage.insuranceBtn.click();
        mainPage.travelAndPurchases.click();
        //wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[text()='Страхование путешественников']"))));
        //element = driver.findElement(By.xpath("//*[text()='Страхование путешественников']"));
        //driver.findElement(By.xpath("//*[contains(@href, 'vzr')]")).click();
        TravelAndPurchasesPage travelAndPurchasesPage = new TravelAndPurchasesPage(driver);
        travelAndPurchasesPage.issueOnline.click();
        Assert.assertEquals("Страхование путешественников", travelAndPurchasesPage.travellerInsurance.getText());
        //Переключится на открывшуюся вкладку
        ArrayList <String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        //Нажать чекбокс на против суммы минимальной суммы
        //wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@ng-click='setProdProg(prodProg)']"))));
        //driver.findElement(By.xpath("//div[@ng-click='setProdProg(prodProg)']")).click();
        //Нажать кнопку оформить
        //driver.findElement(By.xpath("//SPAN[@ng-click='save()']")).click();
        CalculatorForm calculatorForm = new CalculatorForm(driver);
        calculatorForm.priceBox.click();
        calculatorForm.orderBtn.click();
        //Заполняем поля
        //fillField(By.name("insured0_surname"),"Kurumov");
        //fillField(By.xpath("//input[@name='insured0_name']"),"Deni");
        //fillField(By.name("insured0_birthDate"), "01011992");
        //fillField(By.name("surname"),"Курумова");
        //fillField(By.name("name"),"Мадина");
        //fillField(By.name("middlename"), "НеЗнаюОтчества");
        //fillField(By.name("birthDate"), "01011995");
        //driver.findElement(By.name("female")).click();
        //fillField(By.name("passport_series"),"1234");
        //fillField(By.name("passport_number"),"123456");
        //fillField(By.name("issueDate"),"01012010");
        //fillField(By.name("issuePlace"),"01012010");
        //driver.findElement(By.xpath("//span[@ng-click='save()']")).click();
        //element = driver.findElement(By.xpath("//*[text()='Заполнены не все обязательные поля']"));
        OrderPage orderPage = new OrderPage(driver);
        fillField(orderPage.lNameInsured, "Kurumov");
        fillField(orderPage.fNameInsured, "Deni");
        fillField(orderPage.birthDateInsured, "01011992");
        fillField(orderPage.sName, "Курумова");
        fillField(orderPage.fName, "Мадина");
        fillField(orderPage.mName, "НеЗнаюОтчества");
        fillField(orderPage.birthDate, "01011995");
        orderPage.checkBoxFemale.click();
        fillField(orderPage.idSeries, "1234");
        fillField(orderPage.idNumber, "123456");
        fillField(orderPage.issueDate, "01012010");
        fillField(orderPage.issuePlace, "01012010");
        orderPage.sendBtn.click();
        Assert.assertEquals("Заполнены не все обязательные поля", orderPage.errorMessage.getText());
    }
}
