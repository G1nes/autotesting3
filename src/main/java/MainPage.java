import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    WebDriver driver;
    //https://www.sberbank.ru/ru/person
    public MainPage(){
    }
    public MainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        (new WebDriverWait(driver,10)).until(ExpectedConditions.visibilityOf(insuranceBtn));
        this.driver=driver;
    }

    @FindBy(xpath = "//li [@class='lg-menu__item']/*/span[text()='Страхование']")
    WebElement insuranceBtn;

    @FindBy(xpath = "//*[text()='Путешествия и покупки']")
    WebElement travelAndPurchases;
}
