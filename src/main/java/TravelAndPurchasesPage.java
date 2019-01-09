import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TravelAndPurchasesPage extends MainPage {
    //https://www.sberbank.ru/ru/person/bank_inshure/insuranceprogram/travel_and_shopping
    public TravelAndPurchasesPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        (new WebDriverWait(driver,10)).until(ExpectedConditions.visibilityOf(issueOnline));
        this.driver = driver;
    }
    @FindBy(xpath="//*[contains(@href, 'vzr')]")
    WebElement issueOnline;
    @FindBy(xpath="//*[text()='Страхование путешественников']")
    WebElement travellerInsurance;
}
