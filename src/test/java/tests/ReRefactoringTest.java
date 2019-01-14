package tests;

import org.junit.Test;
import tests.steps.*;

public class ReRefactoringTest extends TestPropertiess {
    private MainSteps ms = new MainSteps();
    private TravelStepss ts = new TravelStepss();
    private CalculatorSteps cs = new CalculatorSteps();
    private OrderSteps os = new OrderSteps();

    @Test
    public void insuranceTest(){
        ms.selectMenuItem("Страхование");
        ms.selectSubMenuItem("Путешествия и покупки");
        ts.checkTitle();
        ts.selectTravelInsuranceBtn();
        ts.nextTab();
        cs.selectSumCheckBox();
        cs.selectIssueBtn();
        //Вводим данные застрахованного
        os.fillInsuredFields("Фамилия", "Kurumov");
        os.fillInsuredFields("Имя","Deni");
        os.fillInsuredFields("Дата рождения", "01011992");
        //Вводим данные страхователя
        os.fillInsurantFields("Фамилия", "Kurumova");
        os.fillInsurantFields("Имя","Madina");
        os.fillInsurantFields("Отчество","NeZnau");
        os.fillInsurantFields("Дата рождения","01011998");
        os.selectSexCheckBox();
        os.fillInsurantFields("Серия паспорта","1234");
        os.fillInsurantFields("Номер Паспорта", "123456");
        os.fillInsurantFields("Дата выдачи","01011");
        os.fillInsurantFields("Кем выдан","Washington");
        os.continueBtn();
        os.checkErrorMessage();
    }
}
