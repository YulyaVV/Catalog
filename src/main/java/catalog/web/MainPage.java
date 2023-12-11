package catalog.web;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.Keys;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static catalog.web.LocatorsTest.*;
import static com.codeborne.selenide.Selenide.$x;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MainPage {

    //Переменные
    private String ERROR_MSG_EXIST_MODEL = "уже существует в разделе";
    private ArrayList<String> TABS_NAME = new ArrayList<>(Arrays.asList("Основное", "Свойства модели", "Фото", "Отзывы"));

    //Селектор названия страницы
    private final static String PAGE_TITLE  = "//h1[@class='title']";

    //Селекторы навигационной панели
    private final static String NAV_LIST_TABS = "//*[@class='ant-tabs-nav-list']";
    private final static String TAB_VALUES = ".ant-tabs-tab";

    //Селекторы полей ввода
    private final static String NAME_FIELD = "//*[contains(@class,'name-input')]"; //*[@id='name']";
    private final static String CATEGORY_FIELD = "//*[@class='ant-select-selector']";  //"//*[@id='create-model_category']";
    private final static String SELECT_CATEGORY = "//*[@class='rc-virtual-list-holder-inner']";//"//*[contains(@class,'ant-select-item')]";
    private final static String DESC_FIELD = "//*[contains(@class,'description-input')]"; //"//*[@id='create-model_description']";

    //Селектор активации модели
    private final static String SWITCH_ACTIVE_BTN = "//*[@class='ant-switch-inner']";


    //Метод ввода названия модели
    public String setName(String name) {
        $x(NAME_FIELD).setValue((name));
        return name;
    }

    //Метод получения названия модели
    public String getName() {
        return  $x(NAME_FIELD).getValue();
    }

    //Метод клика в поле Категория модели
    public void clickCategoryField() {
        $x(CATEGORY_FIELD).click();
    }

    //Метод выбора категории (первой)
    public void selectCategory() {
        $x(SELECT_CATEGORY).click();
    }

    //Метод получения текста в поле Описание
    public String getDescription() {
        return  $x(DESC_FIELD).getText();
    }

    //Метод ввода нового описания модели
    public String setDescription(String desc) {
        $x(DESC_FIELD).setValue(desc);
        return desc;
    }

    //Метод получения названия всех вкладок
    public List getTabsInNavList() {
        return  $x(NAV_LIST_TABS).findAll(TAB_VALUES).texts();
    }

    //Метод сравнения названий вкладок в навигационной панеле
    public void checkTabsNameInNavPanel() {
        $x(NAV_LIST_TABS).shouldBe(Condition.visible);
        assertEquals(TABS_NAME, getTabsInNavList());
    }

    //Метод получения названия страницы
    public String getPageTitleName() {
        return  $x(PAGE_TITLE).getText();
    }

    //в тесте не надо запоминать в переменную значение getPageTitleName, в отличии от метода ниже assertTitle2
    public void checkTitle() {
        $x(PAGE_TITLE).shouldHave(Condition.text(getPageTitleName()));
    }

//    public boolean assertTitle2(String expectedResult) {
//       $x(PAGE_TITLE).shouldHave(Condition.text(expectedResult));
//       return true;
//    }

    //Метод получения текста у бегунка Активации
    public String getActivationBtnText() {
        return  $x(SWITCH_ACTIVE_BTN).getText();
    }

    //Метод проверки текста у бегунка Активации
    public void checkActivationBtnText(String button_text) {
        $x(SWITCH_ACTIVE_BTN).shouldBe(Condition.visible);
        String actualText = getActivationBtnText();
        assertEquals(button_text, actualText);
    }

    //Метод клика кнопки Активации
    public void clickIsActiveButton(){
        $x(SWITCH_ACTIVE_BTN).click();
    }

    //Метод очистки поля Название
    public void clearName() {
        $x(NAME_FIELD).click();
        $x(NAME_FIELD).sendKeys(Keys.CONTROL + "A");
        $x(NAME_FIELD).sendKeys(Keys.BACK_SPACE);
    }

    //Метод очистки поля Описание
    public void clearDescription() {
        $x(DESC_FIELD).setValue("");
    }

      //exaсtText - полное совпадение
//    public boolean assertTitle(String expectedResult) {
//        $x(PAGE_TITLE).shouldHave(Condition.exactText(expectedResult));
//        return true;
//    }


    public void checkNewName(String name) {
        $x(NAME_FIELD).shouldHave(Condition.value(getName()));
        assertTrue(name, true);
    }

    public void checkNewDesc(String desc) {
        $x(DESC_FIELD).shouldHave(Condition.value(getDescription()));
        assertTrue(desc, true);
    }

   public void checkColorBorderWithoutName() {
        $x(NAME_FIELD).shouldHave(Condition.cssValue("border-color",COLOR_BORDER_ERROR_FIELD ));
   }

    public void checkColorBorderWithoutName1() {
        $x(NAME_FIELD).shouldHave(Condition.cssValue("border-color", COLOR_BORDER_ERROR_FIELD ));
    }

   public void checkColorBorderWithoutCategory() {
        $x(CATEGORY_FIELD).shouldHave(Condition.cssValue("border-color",COLOR_BORDER_ERROR_FIELD ));
   }



}
