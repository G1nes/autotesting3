package tests.steps;

import io.qameta.allure.Step;
import tests.pages.MainPagee;

public class MainSteps extends TestPropertiess {
    @Step("Выбран пункт главного меню {menuItem}")
    public void selectMenuItem(String menuItem) {
        new MainPagee(TestPropertiess.getDriver()).selectMenuItem(menuItem);
    }

    @Step("Выбран пункт подменю {subMenuItem}")
    public void selectSubMenuItem(String subMenuItem){
        new MainPagee(TestPropertiess.getDriver()).selectSubMenu(subMenuItem);
    }
}
