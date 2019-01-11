package tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.steps.TestPropertiess;

public class MainPagee {
    WebDriver driver=TestPropertiess.getDriver();
    //https://www.sberbank.ru/ru/person
    public MainPagee(){
    }
    public MainPagee(WebDriver driver){
        PageFactory.initElements(TestPropertiess.getDriver(), this);
        (new WebDriverWait(driver,20)).until(ExpectedConditions.visibilityOf(insuranceBtn));
        //this.driver=driver;
    }

    @FindBy(xpath = "//ul[@class='lg-menu__list']")
    public WebElement insuranceBtn;

    @FindBy(xpath = "//*[text()='Путешествия и покупки']")
    public WebElement travelAndPurchases;

    public void selectMenuItem (String menuPoint){
        insuranceBtn.findElement(By.xpath(".//li[@class='lg-menu__item']/*/span[contains(text(),'"+menuPoint+"')]")).click();

    }
    public void selectSubMenu (String subMenuPoint){
        travelAndPurchases.findElement(By.xpath(".//*[text()='"+subMenuPoint+"']")).click();
    }
}
