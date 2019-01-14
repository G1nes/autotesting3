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
            break;
            case "имя" : orderPagee.fillField(orderPagee.fNameInsured,value);
            break;
            case "датарождения": orderPagee.fillField(orderPagee.birthDateInsured, value);
            break;
            default:
                System.out.println("Введите корректное название поля в разделе \"Застрахованные\"");
                break;
        }
    }
    @Step
    public void fillInsurantFields (String field, String value){
        OrderPagee orderPagee = new OrderPagee(TestPropertiess.getDriver());
        field = field.toLowerCase();
        field = field.replaceAll("\\s+","");
        switch (field){
            case "фамилия" : orderPagee.fillField(orderPagee.sName,value);
            break;
            case "имя" : orderPagee.fillField(orderPagee.fName,value);
                break;
            case "отчество" : orderPagee.fillField(orderPagee.mName,value);
                break;
            case "датарождения": orderPagee.fillField(orderPagee.birthDate, value);
                break;
            case "серияпаспорта" : orderPagee.fillField(orderPagee.idSeries,value);
                break;
            case "номерпаспорта": orderPagee.fillField(orderPagee.idNumber, value);
                break;
            case "датавыдачи" : orderPagee.fillField(orderPagee.issueDate,value);
                break;
            case "кемвыдан": orderPagee.fillField(orderPagee.issuePlace, value);
                break;

            default:
                System.out.println("Введите корректное название поля в разделе \"Страхователь\"");
                break;
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
