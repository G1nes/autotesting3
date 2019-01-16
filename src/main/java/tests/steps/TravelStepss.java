package tests.steps;

import io.qameta.allure.Step;
import org.junit.Assert;
import tests.pages.TravelAndPurchasesPagee;

public class TravelStepss extends TestPropertiess {
    @Step("Нажата кнопка \"Оформить онлайн\"")
    public void selectTravelInsuranceBtn(){
        new TravelAndPurchasesPagee(TestPropertiess.getDriver()).issueOnline.click();
    }
    @Step ("Прошла проверка наличия заголовка {expected}")
    public void checkTitle(String expected){
        Assert.assertEquals(expected, new TravelAndPurchasesPagee(TestPropertiess.getDriver()).travellerInsurance.getText());
    }
}
