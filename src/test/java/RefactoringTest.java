import org.junit.Assert;
import org.junit.Test;

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
