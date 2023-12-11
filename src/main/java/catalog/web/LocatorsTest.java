package catalog.web;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$x;
import static org.junit.Assert.assertEquals;

public class LocatorsTest {

    //Переменные
    private String ERROR_TEXT = "Не заполнены важные поля";

    //Селекторы кнопок сохранения: Сохранить/Сохранить и активировать
    public final static String SAVE_DEFAULT_BTN = "//*[contains(@class,'ant-btn-default')]";
    public final static String SAVE_PRIMARY_BTN = "//*[contains(@class,'ant-btn-primary')]"; //*[contains(@class, 'ant-btn-primary')]";

    //Селекторы ошибок
    private final static String ERROR = "//*[contains(@class,'ant-message-error')]"; //"//*[@class='ant-message']";
    public final static String COLOR_BORDER_ERROR_FIELD = "rgb(255, 77, 79)";

    //Селекторы навигационной панели
    public final static String ACTIVE_TAB = "//*[@aria-selected='true']"; //
    public final static String COLOR_TEXT_ACTIVE_TAB = "rgba(24, 144, 255, 1)"; //



    //Метод проверки цвета активной вкладки
    public void checkColorTextActiveTab() {
        $x(ACTIVE_TAB).shouldHave(Condition.cssValue("color",COLOR_TEXT_ACTIVE_TAB ));
    }

    //Метод проверки названия активной вкладки
    public void checkTextActiveTab(String tabName) {
        String actualName = $x(ACTIVE_TAB).innerText();
        assertEquals(tabName, actualName);
    }

    //Метод клика в кнопку "Сохранить"
    public void clickSaveButton() {
        $x(SAVE_DEFAULT_BTN).shouldBe(Condition.visible)
                .click();
    }

    //Метод клика по кнопку "Сохранить и активировать"
    public void clickSaveAndActivatedButton() {
        $x(SAVE_PRIMARY_BTN).shouldHave(Condition.cssValue("color", "#fff"))
                .click();
    }

    public void checkErrorMessage() {
        $x(ERROR).shouldBe(Condition.visible);
        String actualErrorMessage = $x(ERROR).innerText();
        assertEquals(ERROR_TEXT, actualErrorMessage);
    }
}
