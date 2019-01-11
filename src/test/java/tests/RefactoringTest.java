package tests;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import tests.pages.CalculatorForm;
import tests.pages.MainPagee;
import tests.pages.OrderPagee;
import tests.pages.TravelAndPurchasesPagee;

import java.util.ArrayList;

public class RefactoringTest extends TestLauncher {
    @Test
    @Ignore
    public void insuranceTest (){
        driver.get(url);
        MainPagee mainPagee = new MainPagee(driver);
        mainPagee.insuranceBtn.click();
        mainPagee.travelAndPurchases.click();
        TravelAndPurchasesPagee travelAndPurchasesPage = new TravelAndPurchasesPagee(driver);
        travelAndPurchasesPage.issueOnline.click();
        Assert.assertEquals("Страхование путешественников", travelAndPurchasesPage.travellerInsurance.getText());
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        CalculatorForm calculatorForm = new CalculatorForm(driver);
        calculatorForm.priceBox.click();
        calculatorForm.orderBtn.click();
        OrderPagee orderPage = new OrderPagee(driver);
        orderPage.fillFields();
        orderPage.sendBtn.click();
        Assert.assertEquals("Заполнены не все обязательные поля", orderPage.errorMessage.getText());
        mainPagee =null;
        travelAndPurchasesPage=null;
        tabs=null;
        calculatorForm=null;
        orderPage=null;
    }
}
