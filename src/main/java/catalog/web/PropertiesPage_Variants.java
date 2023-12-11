package catalog.web;

import com.codeborne.selenide.Condition;

import static catalog.web.LocatorsTest.*;
import static com.codeborne.selenide.Selenide.$x;
import static org.junit.Assert.assertEquals;

public class PropertiesPage_Variants {

    //Ожидаемый результат - переменные
    private String GROUP_ADDING_MODAL_NAME = "Парсинг маркировок из таблиц";
    private String SAVE_CANCEL_BTNS_NAME = "СохранитьОтменить";
    private String NO_VARIANTS_TEXT = "Данных пока нет";

    //Общие селекторы блока Варианты маркировок
    private final static String NO_VARIANTS = "//*[@class='ant-table-expanded-row-fixed']";
    private final static String BULK_ADD_BTN = "//*[@aria-label='table']/ancestor-or-self::button[@type='button']";
    private final static String MANUALLY_ADD_BTN = "//*[@aria-label='plus']/ancestor-or-self::button[@type='button']";
    private final static String ROW = "//*[@data-row-key='0']";
    private final static String FILLED_VARIANT_TYPE = "//*[@data-row-key='0']/td[position()=5]";
    private final static String EMPTY_VARIANT_TYPE = "//*[@data-row-key='0']/td[position()=5]/div//*[contains(@class, 'ant-select-selector')]";
    private final static String ACTION_BTNS = "//*[@data-row-key='0']//td[last()]";
    private final static String CANCEL_DEL_BTN = "//*[@data-row-key='0']//td[last()]//a[2]";
    private final static String SAVE_CHANGE_BTN = "//*[@data-row-key='0']//td[last()]//a[1]";
    private final static String MODAL_CONFIRM = "//*[contains(@class,'ant-popconfirm')]";
    private final static String TITLE_MODAL_CONFIRM = "//*[@class='ant-popover-message-title']";

    //Селекторы модального окна группового добавления
    private final static String GROUP_ADD_MODAL_WINDOW = "//*[@class='ant-modal-content']//div[@class='ant-modal-title']";
    private final static String MODAL_TITLE = "//*[@class='ant-modal-title']";
    private final static String TEXTAREA_GROUP_ADD_MOD_WIND = "//*[@id='textarea']";
    private final static String SAVE_BTN_GROUP_ADD_MOD_WIND = "//*[@class='ant-modal-footer']/button[@type='button']";
    private final static String VARIANT = "//*[@class='variant']/span";
    private final static String COLOR_CORRECT_VARIANT ="rgba(217, 247, 190, 1)";

    //Селекторы вариантов маркировки при групповом добавлении
    private final static String ADDED_VARIANT = "//*[@data-row-key='0']/td[contains(@class,'ant-table-cell-fix-left-last')]";
    private final static String YES_BTN_CONFIRM_NODAL = "//*[contains(@class,'ant-popconfirm')]//div//*[contains(@class,'ant-btn-primary')]";
    private final static String NO_BTN_CONFIRM_NODAL = "//*[contains(@class,'ant-popconfirm')]//div//*[contains(@class,'ant-btn-default')]";
    private final static String TIRE_VARIANT_NAME = "//*[contains(@class, 'ant-table-cell')]//input[@id='name']";
    private final static String TIRE_DIAMETER = "//*[contains(@class, 'ant-table-cell')]//input[@id='attributes_wheelDiameter_value']";
    private final static String TIRE_WIDTH = "//*[contains(@class, 'ant-table-cell')]//input[@id='attributes_width_value']";

    //Отображение кнопки Групповое добавление
    public void checkBulkAddBtnIsDisplay() {$x(BULK_ADD_BTN).shouldBe(Condition.visible);}

    //Отображение кнопки Добавить вручную
    public void checkManuallAddBtnIsDisplay() {$x(MANUALLY_ADD_BTN).shouldBe(Condition.visible);}

    //Метод клика в кнопку "Групповое добавление" маркировки
    public void clickGroupAddBtn() {
        $x(BULK_ADD_BTN).click();
    }

    //Метод клика в кнопку "Добавить вручную"
    public void clickManuallyAddBtn() {
        $x(MANUALLY_ADD_BTN).click();
    }

    //Метод проверки заголовка модального окна группового добавления маркировки
    public  void checkTitleGroupAddModal() {
        String titleName = $x(GROUP_ADD_MODAL_WINDOW).shouldBe(Condition.visible).getText();
        assertEquals(GROUP_ADDING_MODAL_NAME, titleName);
    }

    //Метод ввода маркировки в модальном окне Группового добавления.
    public void setTireVariantViaGroupAdding(String tire) {
        $x(TEXTAREA_GROUP_ADD_MOD_WIND).setValue(tire);
    }

    //Метод клика по кнопке "Сохранить маркировки" в модальном окне Группового добавления
    public void clickSaveVariant() {
        $x(SAVE_BTN_GROUP_ADD_MOD_WIND).click();
    }

    //Метод проверки цвета правильной маркировки - сомнительная проверка: у такой маркировки будет и зеленая и голубая подсветка 205/60R15 91V
    public void checkColorOfTrueVariant() {
        $x(VARIANT).shouldHave(Condition.cssValue("background-color",COLOR_CORRECT_VARIANT ));
    }

    //Метод проверки, что добавленный вариант отображается в таблице
    public void checkVisibleAddedVariant(String tire) {
        String addedVariantName = $x(ADDED_VARIANT).getText();
        assertEquals(tire, addedVariantName);
    }

    //Метод проверки типа шины
    public void checkVariantType(String type) {
        String variantType = getVariantType();//$x(VARIANT_TYPE).getText();
        assertEquals(type, variantType);
    }

    //Метод получения типа добавленной маркиовки
    public String getVariantType() {
        return $x(FILLED_VARIANT_TYPE).getText();
    }

    //Метод проверки отображения пустой строки для ввода маркировки при ручном добавлении
    public void checkAddRowIsVisible() {
        $x(ROW).shouldBe(Condition.visible);
    }

    //Метод проверки, что кнопки "Групповое добавление"/"добавить вручную" задизаблнены при добавлении новой маркировки вручную
    public void checkAddBtnsIsDisabled() {
        $x(BULK_ADD_BTN).shouldHave(Condition.disabled);
        $x(MANUALLY_ADD_BTN).shouldHave(Condition.disabled);
        //$x(ADD_BTNS).shouldHave(Condition.disabled);
    }

    //Метод проверки кнопок "Сохранить"/"отменить" при ручном добавлении маркировки
    public void checkSaveCancelBtnsIsDisplay() {
        $x(ACTION_BTNS).shouldBe(Condition.visible);
        String btns_name = $x(ACTION_BTNS).getText();
        assertEquals(SAVE_CANCEL_BTNS_NAME, btns_name);
    }

    public void clickCancelBtn() {
        $x(CANCEL_DEL_BTN).click();
    }

    public void checkConfirmModalIsAppear(String expected_title) {
        $x(MODAL_CONFIRM).shouldBe(Condition.visible);
        String title = $x(TITLE_MODAL_CONFIRM).getText();
        assertEquals(expected_title, title);
    }

    public void checkRowIsHideAfterConfirmCancel() {
        $x(ROW).shouldNotBe(Condition.visible);
        $x(ACTION_BTNS).shouldNotBe(Condition.visible);
    }

    public void clickYesBtnConfirmModal() {
        $x(YES_BTN_CONFIRM_NODAL).click();
    }

    public void clickNoBtnConfirmModal() {
        $x(NO_BTN_CONFIRM_NODAL).click();
    }

    public void clickSaveBtn() {
        $x(SAVE_CHANGE_BTN).click();
    }

    public String setVariantTireName(String tire) {
        $x(TIRE_VARIANT_NAME).setValue(tire).pressTab();
        return tire;
    }

    public void checkEmptyTireVariantNameBorderColor() {
        $x(TIRE_VARIANT_NAME).shouldHave(Condition.cssValue("border-color", COLOR_BORDER_ERROR_FIELD));
    }

    public void checkEmptyTireDiameterBorderColor() {
        $x(TIRE_DIAMETER).shouldHave(Condition.cssValue("border-color", COLOR_BORDER_ERROR_FIELD));
    }


    public void checkEmptyTireWidthBorderColor() {
        $x(TIRE_WIDTH).shouldHave(Condition.cssValue("border-color", COLOR_BORDER_ERROR_FIELD));
    }

    public void checkEmptyTireVariantTypeBorderColor() {
        $x(EMPTY_VARIANT_TYPE).shouldHave(Condition.cssValue("border-color", COLOR_BORDER_ERROR_FIELD));
    }

    public void checkTextIfNoVariants() {
        String text = $x(NO_VARIANTS).getText();
        assertEquals(NO_VARIANTS_TEXT, text);
    }

}
