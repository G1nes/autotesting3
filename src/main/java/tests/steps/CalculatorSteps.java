package tests.steps;

import ru.yandex.qatools.allure.annotations.Step;
import tests.pages.CalculatorForm;

public class CalculatorSteps extends TestPropertiess {
    @Step
    public void selectSumCheckBox(){
        new CalculatorForm(TestPropertiess.getDriver()).priceBox.click();
    }
    @Step
    public void selectIssueBtn(){
        new CalculatorForm(TestPropertiess.getDriver()).orderBtn.click();
    }
}
