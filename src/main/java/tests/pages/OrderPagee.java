package tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.HashMap;

public class OrderPagee extends MainPagee {
    //https://online.sberbankins.ru/store/vzr/index.html#/viewIn
    public OrderPagee(WebDriver driver){
        PageFactory.initElements(driver, this);
        (new WebDriverWait(driver, 1)).until(ExpectedConditions.visibilityOf(lNameInsured));
        this.driver=driver;
    }
    public void fillField(WebElement element, String value){
        element.clear();
        element.sendKeys(value);
    }
    public void fillInsuredFields (String field, String value){
        field = field.toLowerCase();
        field = field.replaceAll("\\s+","");
        switch (field){
            case "фамилия" : fillField(lNameInsured,value);
            case "имя" : fillField(fNameInsured,value);
            case "датарождения": fillField(birthDateInsured, value);
            default:
                System.out.println("Введите корректное название поля в разделе \"Застрахованные\"");
        }
    }
    public void fillInsurantFields (String field, String value){
        field = field.toLowerCase();
        field = field.replaceAll("\\s+","");
        checkBoxFemale.click();
        switch (field){
            case "фамилия" : fillField(sName,value);
            case "имя" : fillField(fName,value);
            case "отчество" : fillField(mName,value);
            case "датарождения": fillField(birthDate, value);
            case "серияпаспорта" : fillField(idSeries,value);
            case "номерпаспорта": fillField(idNumber, value);
            case "датавыдачи" : fillField(issueDate,value);
            case "кемвыдан": fillField(issuePlace, value);

            default:
                System.out.println("Введите корректное название поля в разделе \"Страхователь\"");
        }
    }

    @FindBy(name="insured0_surname")
    WebElement lNameInsured;

    @FindBy(xpath="//input[@name='insured0_name']")
    WebElement fNameInsured;

    @FindBy(name="insured0_birthDate")
    WebElement birthDateInsured;

    @FindBy(name="surname")
    WebElement sName;

    @FindBy(name="name")
    WebElement fName;

    @FindBy(name="middlename")
    WebElement mName;

    @FindBy(name="birthDate")
    WebElement birthDate;

    @FindBy(name="female")
    WebElement checkBoxFemale;

    @FindBy(name="passport_series")
    WebElement idSeries;

    @FindBy(name="passport_number")
    WebElement idNumber;

    @FindBy(name="issueDate")
    WebElement issueDate;

    @FindBy(name="issuePlace")
    WebElement issuePlace;

    @FindBy(xpath="//span[@ng-click='save()']")
    public WebElement sendBtn;

    @FindBy(xpath="//*[text()='Заполнены не все обязательные поля']")
    public WebElement errorMessage;
}
