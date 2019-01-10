import org.junit.Assert;
import org.junit.Test;
import pages.CalculatorForm;
import pages.MainPage;
import pages.OrderPage;
import pages.TravelAndPurchasesPage;

import java.util.ArrayList;

public class RefactoringTest extends TestLauncher{
    @Test
    public void insuranceTest (){
        driver.get(url);
        MainPage mainPage = new MainPage(driver);
        mainPage.insuranceBtn.click();
        mainPage.travelAndPurchases.click();
        TravelAndPurchasesPage travelAndPurchasesPage = new TravelAndPurchasesPage(driver);
        travelAndPurchasesPage.issueOnline.click();
        Assert.assertEquals("Страхование путешественников", travelAndPurchasesPage.travellerInsurance.getText());
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        CalculatorForm calculatorForm = new CalculatorForm(driver);
        calculatorForm.priceBox.click();
        calculatorForm.orderBtn.click();
        OrderPage orderPage = new OrderPage(driver);
        orderPage.fillFields();
        orderPage.sendBtn.click();
        Assert.assertEquals("Заполнены не все обязательные поля", orderPage.errorMessage.getText());
        mainPage=null;
        travelAndPurchasesPage=null;
        tabs=null;
        calculatorForm=null;
        orderPage=null;
    }
}
