package catalog.web.edit_model_tests.check_properties_tab.tire_category;

import catalog.web.LocatorsTest;
import catalog.web.OpenURL;
import catalog.web.PropertiesPage_Attributes;
import org.junit.Before;
import org.junit.Test;

//проверять на пустой шине...как-будто не верный подход
public class TireCheckAttributesTests {

    private final static String URL_LOGIN = "https://farpost-catalog.kubernetes.bazadev.net/admin/login";
    private final static String TIRE_MODEL = "https://farpost-catalog.kubernetes.bazadev.net/admin/models/596437#properties";
    private final static String TAB_NAME = "Свойства модели";


    @Before
    public void openBrowser() {
        new OpenURL(URL_LOGIN);
        new OpenURL(TIRE_MODEL);
    }


    @Test // проверяем, что вкладка называется - Свойства модели
    public void checkTabName() {
        LocatorsTest lt = new LocatorsTest();
            lt.checkTextActiveTab(TAB_NAME);
    }

    @Test // цвет текста активной вкладки - синий
    public void activeTabTextColorIsBlue() {
        LocatorsTest lt = new LocatorsTest();
            lt.checkColorTextActiveTab();
    }

    @Test //проверяем название и отображение поля Протектор
    public void checkWheelSeasonFieldName() {
        PropertiesPage_Attributes pp = new PropertiesPage_Attributes();
        pp.checkWheelSeasonFieldName();
    }

    @Test //проверяем название и отображение поля Шипы
    public void checkWheelSpikeFieldName() {
        PropertiesPage_Attributes pp = new PropertiesPage_Attributes();
        pp.checkWheelSpikeFieldName();
    }

    @Test //проверяем название и отображение поля Тип шины
    public void checkPredestinationFieldName() {
        PropertiesPage_Attributes pp = new PropertiesPage_Attributes();
        pp.checkPredestinationFieldName();
    }

    @Test //проверяем, что выпадающий список содержит все наименования протектора
    public void checkListOfWheelSeasonInDropDownList() {
        PropertiesPage_Attributes pp = new PropertiesPage_Attributes();
        pp.clickSelectorWheelSeason();
        pp.checkWheelSeasonValuesInDropDownList();
    }

    @Test //проверяем, что в поле Протектор отображается атрибут, выбранный из списка
    public void checkSelectedWheelSeasonIsDisplayedInField() {
        PropertiesPage_Attributes pp = new PropertiesPage_Attributes();
        pp.clickSelectorWheelSeason();
        pp.selectValues();
        pp.checkSelectedAttributes();
    }

    @Test //проверяем, что выпадающий список содержит все наименования шипов
    public void checkListOfWheelSpikeInDropDownList() {
        PropertiesPage_Attributes pp = new PropertiesPage_Attributes();
        pp.clickSelectorWheelSpike();
        pp.checkWheelSpikeValuesInDropDownList();
    }

    @Test //проверяем, что в поле Шипы отображается атрибут, выбранный из списка
    public void checkSelectedWheelSpikeIsDisplayedInField() {
        PropertiesPage_Attributes pp = new PropertiesPage_Attributes();
        pp.clickSelectorWheelSpike();
        pp.selectValues();
        pp.checkSelectedAttributes();
    }

    @Test //проверяем, что выпадающий список содержит все наименования типов шин
    public void checkListOfPredestinationInDropDownList() {
        PropertiesPage_Attributes pp = new PropertiesPage_Attributes();
        pp.clickSelectorPredestination();
        pp.checkPredestinationValuesInDropDownList();
    }

    @Test //проверяем, что в поле Тип шин отображается атрибут, выбранный из списка
    public void checkSelectedPredestinationIsDisplayedInField() {
        PropertiesPage_Attributes pp = new PropertiesPage_Attributes();
        pp.clickSelectorPredestination();
        pp.selectValues();
        pp.checkSelectedAttributes();
    }




}
