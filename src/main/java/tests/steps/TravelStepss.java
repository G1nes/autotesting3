package tests.steps;

import org.junit.Assert;
import ru.yandex.qatools.allure.annotations.Step;
import tests.pages.TravelAndPurchasesPagee;

public class TravelStepss extends TestPropertiess {
    @Step
    public void selectTravelInsuranceBtn(){
        new TravelAndPurchasesPagee(TestPropertiess.getDriver()).issueOnline.click();
    }
    @Step
    public void checkTitle(){
        Assert.assertEquals("Страхование путешественников", new TravelAndPurchasesPagee(TestPropertiess.getDriver()).travellerInsurance.getText());
    }
}
