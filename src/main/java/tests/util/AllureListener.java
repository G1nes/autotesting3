package tests.util;

import org.junit.runner.notification.Failure;
import ru.yandex.qatools.allure.junit.AllureRunListener;
import tests.steps.MainSteps;
import tests.steps.TestPropertiess;

public class AllureListener extends AllureRunListener {
    @Override
    public void testFailure (Failure failure){
        TestPropertiess.takeScreenshot();
        super.testFailure(failure);
    }
}
