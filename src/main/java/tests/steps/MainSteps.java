package tests.steps;

import tests.pages.MainPagee;
import ru.yandex.qatools.allure.annotations.Step;

public class MainSteps extends TestPropertiess {
    @Step("Выбран пункт главного меню {0}")
    public void selectMenuItem(String menuItem) {
        new MainPagee(TestPropertiess.getDriver()).selectMenuItem(menuItem);
    }

    @Step("Выбран пункт подменю {0}")
    public void selectSubMenuItem(String subMenuItem){
        new MainPagee().selectSubMenu(subMenuItem);
    }
}
