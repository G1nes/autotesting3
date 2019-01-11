package tests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TravelAndPurchasesPagee extends MainPagee {
    //https://www.sberbank.ru/ru/person/bank_inshure/insuranceprogram/travel_and_shopping
    public TravelAndPurchasesPagee(WebDriver driver){
        PageFactory.initElements(driver,this);
        (new WebDriverWait(driver,10)).until(ExpectedConditions.visibilityOf(issueOnline));
        this.driver = driver;
    }
    @FindBy(xpath="//*[contains(@href, 'vzr')]")
    public WebElement issueOnline;
    @FindBy(xpath="//*[text()='Страхование путешественников']")
    public WebElement travellerInsurance;
}
