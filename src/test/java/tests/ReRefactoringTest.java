package tests;

import org.junit.Test;
import tests.pages.MainPagee;
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
        
    }
}
