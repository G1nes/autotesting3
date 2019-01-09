import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPage extends MainPage {
    //https://online.sberbankins.ru/store/vzr/index.html#/viewIn
    public OrderPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        (new WebDriverWait(driver, 1)).until(ExpectedConditions.visibilityOf(lNameInsured));
        this.driver=driver;
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
    WebElement sendBtn;

    @FindBy(xpath="//*[text()='Заполнены не все обязательные поля']")
    WebElement errorMessage;
}
