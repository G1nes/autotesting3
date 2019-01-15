package tests.steps;

import io.qameta.allure.Step;
import tests.pages.MainPagee;

public class MainSteps extends TestPropertiess {
    @Step("Выбран пункт главного меню {0}")
    public void selectMenuItem(String menuItem) {
        new MainPagee(TestPropertiess.getDriver()).selectMenuItem(menuItem);
    }

    @Step("Выбран пункт подменю {0}")
    public void selectSubMenuItem(String subMenuItem){
        new MainPagee(TestPropertiess.getDriver()).selectSubMenu(subMenuItem);
    }
}
