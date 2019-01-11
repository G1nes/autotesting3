package tests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalculatorForm extends MainPagee {
    //https://online.sberbankins.ru/store/vzr/index.html#/viewCalc
    public CalculatorForm(WebDriver driver){
        PageFactory.initElements(driver,this);
        (new WebDriverWait(driver,20)).until(ExpectedConditions.visibilityOf(orderBtn));
        this.driver=driver;
    }
    @FindBy(xpath="//SPAN[@ng-click='save()']")
    public WebElement orderBtn;
    @FindBy(xpath="//div[@ng-click='setProdProg(prodProg)']")
    public WebElement priceBox;
}
