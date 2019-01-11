package tests;

import org.junit.Test;
import tests.steps.*;

public class ReRefactoringTest extends TestPropertiess {
    MainSteps ms = new MainSteps();
    TravelStepss ts = new TravelStepss();
    CalculatorSteps cs = new CalculatorSteps();
    OrderSteps os = new OrderSteps();

    @Test
    public void insuranceTest(){
        ms.selectMenuItem("Страхование");
        ms.selectSubMenuItem("Путешествия и покупки");
    }
}
