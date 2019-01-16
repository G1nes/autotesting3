package tests.steps;

import io.qameta.allure.Step;
import org.junit.Assert;

import tests.pages.OrderPagee;

public class OrderSteps extends TestPropertiess {
    @Step("Поле {field} застрахованного заполнено значением {value}")
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
    @Step ("Поле {field} страхователя заполнено значением {value}")
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
    @Step ("Выбран женский пол")
    public void selectSexCheckBox(){
        new OrderPagee(TestPropertiess.getDriver()).checkBoxFemale.click();
    }
    @Step ("Появилось сообщение об ошибке {0}")
    public void checkErrorMessage (String expected){
        Assert.assertEquals(expected,new OrderPagee(TestPropertiess.getDriver()).errorMessage.getText());
    }
    @Step ("Нажата кнопка \"Продолжить\"")
    public void continueBtn(){
        new OrderPagee(TestPropertiess.getDriver()).sendBtn.click();
    }
}
