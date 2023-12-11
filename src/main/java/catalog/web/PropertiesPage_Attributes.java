package catalog.web;

import com.codeborne.selenide.Condition;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertEquals;
import static catalog.web.LocatorsTest.*;


public class PropertiesPage_Attributes {

    //Переменные
    private String PROTECTOR_NAME = "Протектор";
    private String SPIKE_NAME = "Шипы";
    private String PREDESTINATION_NAME = "Тип шины";
    private ArrayList<String> WHEELSEASON_VALUES = new ArrayList<>(Arrays.asList("Всесезонный", "Летняя", "Зимняя", "Грязь АТ", "Грязь МТ"));
    private ArrayList<String> WHEELSPIKE_VALUES = new ArrayList<>(Arrays.asList("Без шипов", "Шипованная"));
    private ArrayList<String> PREDESTINATION_VALUES = new ArrayList<>(Arrays.asList("Легковая", "Грузовая и LT", "Спецтехника"));


    //Селекторы общие
    private final static String ATTRIBUTES_VALUES = ".ant-select-item";
    private final static String SELECTION_FIELD = "//*[@class='ant-select-selection-item']";
    private final static String LISTBOX = "//*[@class='rc-virtual-list-holder-inner']";
    private final static String SELECTED_ATTRIBUTES = "//*[contains(@class,'ant-select-item-option-selected')]";

    //Селекторы атрибутов категории "Шины" - поле Протектор
    private final static String WHEELSEASON_NAME_FIELD  = "//*[@data-row-key='wheelSeason']/td[position()=1]";
    private final static String WHEELSEASON_SELECTOR_FIELD = "//*[@data-row-key='wheelSeason']/td[position()=2]";

    //Селекторы атрибутов категории "Шины" - поле Шипы
    private final static String WHEELSPIKE_NAME_FIELD = "//*[@data-row-key='wheelSpike']/td[position()=1]";
    private final static String WHEELSPIKE_SELECTOR_FIELD = "//*[@data-row-key='wheelSpike']/td[position()=2]";

    //Селекторы атрибутов категории "Шины" - поле Тип шины
    private final static String PREDESTINATION_NAME_FIELD = "//*[@data-row-key='predestination']/td[position()=1]";
    private final static String PREDESTINATION_SELECTOR_FIELD = "//*[@data-row-key='predestination']/td[position()=2]";


    //Метод проверки названия поля "Протектор"
    public void checkWheelSeasonFieldName() {
        $x(WHEELSEASON_NAME_FIELD).shouldBe(Condition.visible);
        String actualName = $x(WHEELSEASON_NAME_FIELD).getText();
        assertEquals(PROTECTOR_NAME, actualName);
    }

    //Метод поверки названия поля "Шипы"
    public void checkWheelSpikeFieldName() {
        $x(WHEELSPIKE_NAME_FIELD).shouldBe(Condition.visible);
        String actualName = $x(WHEELSPIKE_NAME_FIELD).getText();
        assertEquals(SPIKE_NAME, actualName);
    }

    //Метод проверки названия поля "Тип шины"
    public void checkPredestinationFieldName() {
        $x(PREDESTINATION_NAME_FIELD).shouldBe(Condition.visible);
        String actualName = $x(PREDESTINATION_NAME_FIELD).getText();
        assertEquals(PREDESTINATION_NAME, actualName);
    }

    //Метод клика в поле "Протектор"
    public void clickSelectorWheelSeason() {
        $x(WHEELSEASON_SELECTOR_FIELD).click();
    }

    //Метод клика в поле "Шипы"
    public void clickSelectorWheelSpike() {
        $x(WHEELSPIKE_SELECTOR_FIELD).click();
    }

    //Метод клика в поле "Тип шины"
    public void clickSelectorPredestination() {
        $x(PREDESTINATION_SELECTOR_FIELD).click();
    }

    //Метод получения атрибутов в выпадающем списке
    public List getAttributesInDropDownList() {
        return  $x(LISTBOX).findAll(ATTRIBUTES_VALUES).texts();
    }

    //Метод сравнения атрибутов в списке Потектор
    public void checkWheelSeasonValuesInDropDownList() {
        $x(LISTBOX).shouldBe(Condition.visible);
        assertEquals(WHEELSEASON_VALUES, getAttributesInDropDownList());
    }

    //Метод сравнения атрибутов в списке Шипы
    public void checkWheelSpikeValuesInDropDownList() {
        $x(LISTBOX).shouldBe(Condition.visible);
        assertEquals(WHEELSPIKE_VALUES, getAttributesInDropDownList());
    }

    //Метод сравнения атрибутов в списке Тип шины
    public void checkPredestinationValuesInDropDownList() {
        $x(LISTBOX).shouldBe(Condition.visible);
        assertEquals(PREDESTINATION_VALUES, getAttributesInDropDownList());
    }

    //Метод выбора аттрибута из выпадающего списка
    public void selectValues() {
        $x(LISTBOX).click();
    }

    //Метод проверки выбранного атрибута с атрибутом в поле
    //Сработает только на Шине с пустыми атрибутами
    public void checkSelectedAttributes() {
        String SelectValueFromList = $x(SELECTED_ATTRIBUTES).attr("title");
        String ValueInSelectField = $x(SELECTION_FIELD).attr("title");
        assertEquals(SelectValueFromList, ValueInSelectField);
    }


}
