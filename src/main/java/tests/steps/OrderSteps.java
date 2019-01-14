package tests.steps;

import org.junit.Assert;
import ru.yandex.qatools.allure.annotations.Step;
import tests.pages.OrderPagee;

public class OrderSteps extends TestPropertiess {
    @Step
    public void fillInsuredFields (String field, String value){
        field = field.toLowerCase();
        field = field.replaceAll("\\s+","");
        OrderPagee orderPagee = new OrderPagee(TestPropertiess.getDriver());
        switch (field){
            case "фамилия" : orderPagee.fillField(orderPagee.lNameInsured,value);
            case "имя" : orderPagee.fillField(orderPagee.fNameInsured,value);
            case "датарождения": orderPagee.fillField(orderPagee.birthDateInsured, value);
            default:
                System.out.println("Введите корректное название поля в разделе \"Застрахованные\"");
        }
    }
    @Step
    public void fillInsurantFields (String field, String value){
        OrderPagee orderPagee = new OrderPagee(TestPropertiess.getDriver());
        field = field.toLowerCase();
        field = field.replaceAll("\\s+","");
        switch (field){
            case "фамилия" : orderPagee.fillField(orderPagee.sName,value);
            case "имя" : orderPagee.fillField(orderPagee.fName,value);
            case "отчество" : orderPagee.fillField(orderPagee.mName,value);
            case "датарождения": orderPagee.fillField(orderPagee.birthDate, value);
            case "серияпаспорта" : orderPagee.fillField(orderPagee.idSeries,value);
            case "номерпаспорта": orderPagee.fillField(orderPagee.idNumber, value);
            case "датавыдачи" : orderPagee.fillField(orderPagee.issueDate,value);
            case "кемвыдан": orderPagee.fillField(orderPagee.issuePlace, value);

            default:
                System.out.println("Введите корректное название поля в разделе \"Страхователь\"");
        }
    }
    @Step
    public void selectSexCheckBox(){
        new OrderPagee(TestPropertiess.getDriver()).checkBoxFemale.click();
    }
    @Step
    public void checkErrorMessage (){
        Assert.assertEquals("Заполнены не все обязательные поля",new OrderPagee(TestPropertiess.getDriver()).errorMessage.getText());
    }
    @Step
    public void continueBtn(){
        new OrderPagee(TestPropertiess.getDriver()).sendBtn.click();
    }
}
