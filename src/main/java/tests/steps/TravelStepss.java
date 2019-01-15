package tests.steps;

import org.junit.Assert;
import ru.yandex.qatools.allure.annotations.Step;
import tests.pages.TravelAndPurchasesPagee;

public class TravelStepss extends TestPropertiess {
    @Step ("Нажата кнопка \"Оформить онлайн\"")
    public void selectTravelInsuranceBtn(){
        new TravelAndPurchasesPagee(TestPropertiess.getDriver()).issueOnline.click();
    }
    @Step ("Прошла проверка наличия заголовка {0}")
    public void checkTitle(String expected){
        Assert.assertEquals(expected, new TravelAndPurchasesPagee(TestPropertiess.getDriver()).travellerInsurance.getText());
    }
}
