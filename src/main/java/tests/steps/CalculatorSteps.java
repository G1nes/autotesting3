package tests.steps;


import io.qameta.allure.Step;
import tests.pages.CalculatorForm;

public class CalculatorSteps extends TestPropertiess {
    @Step("Выбран чек-бокс с минимальной суммой")
    public void selectSumCheckBox(){
        new CalculatorForm(TestPropertiess.getDriver()).priceBox.click();
    }
    @Step ("Нажата кнопка \"Оформить\"")
    public void selectIssueBtn(){
        new CalculatorForm(TestPropertiess.getDriver()).orderBtn.click();
    }
}
