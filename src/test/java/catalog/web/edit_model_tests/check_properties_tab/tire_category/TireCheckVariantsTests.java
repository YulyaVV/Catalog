package catalog.web.edit_model_tests.check_properties_tab.tire_category;

import catalog.web.OpenURL;
import catalog.web.PropertiesPage_Variants;
import catalog.web.LocatorsTest;
import org.junit.Before;
import org.junit.Test;

public class TireCheckVariantsTests {

    private PropertiesPage_Variants pp = new PropertiesPage_Variants();
    private LocatorsTest lt = new LocatorsTest();
    private final static String URL_LOGIN = "https://farpost-catalog.kubernetes.bazadev.net/admin/login";
    private final static String TIRE_MODEL = "https://farpost-catalog.kubernetes.bazadev.net/admin/models/596437#properties";
    private final static String INCH_TIRE = "225/45R17 94Y XL";//"31x10.5R15";
    private final static String METRIC_TIRE = "205/60R15 91V";//"205/55R16";
    private final static String TIRE_TYPE_INCH = "Дюймовая";
    private final static String TIRE_TYPE_METRIC = "Метрическая";
    private final static String CANCEL_TITLE_MODAL_CONFIRM = "Точно отменить?";
    private final static String DELETE_TITLE_MODAL_CONFIRM = "Точно удалить?";

    @Before
    public void openBrowser() {
        new OpenURL(URL_LOGIN);
        new OpenURL(TIRE_MODEL);
    }

    @Test //если у модели нет вариантов то текст в блоке Маркировки должен быть "Данных пока нет"
    public void checkTextIfNoVariants() {
        pp.checkTextIfNoVariants();
    }

    @Test //проверяем отображение кнопки "Групповое добавление"
    public void checkDisplayingBulkAddBtn() {
        pp.checkBulkAddBtnIsDisplay();
    }

    @Test //проверяем отображение кнопки "Добавить вручную"
    public void checkDisplayingManualAddBtn() {
        pp.checkManuallAddBtnIsDisplay();
    }

    @Test //проверяем модальное окно Группового добавления маркировок-"Парсинг маркировок из таблиц"
    public void checkTitleOfModalGroupAdd() {
        pp.clickGroupAddBtn();
        pp.checkTitleGroupAddModal();
    }

    @Test //проверяем, что при добавлении маркировки корректный вариант подсвечивается
    public void checkBackgroundColorOfTrueVariant() {
        pp.clickGroupAddBtn();
        pp.setTireVariantViaGroupAdding(INCH_TIRE);
        pp.checkColorOfTrueVariant();
    }

    @Test // проверяем, что добавленный вариант отображается в таблице
    public void checkInchTireViaGroupAdding() {
        pp.clickGroupAddBtn();
        pp.setTireVariantViaGroupAdding(INCH_TIRE);
        pp.clickSaveVariant();
        pp.checkVisibleAddedVariant(INCH_TIRE);
    }

    @Test //проверяем, что у дюймовой  шины указан Тип Маркировки - дюймовая
    public void checkTypeTireInch() {
        pp.clickGroupAddBtn();
        pp.setTireVariantViaGroupAdding(INCH_TIRE);
        pp.clickSaveVariant();
        pp.checkVariantType(TIRE_TYPE_INCH);
        int a = 1;
    }


    @Test //проверяем, что у метрической  шины указан Тип Маркировки - метрическая
    public void checkTypeTireMetric() {
        pp.clickGroupAddBtn();
        pp.setTireVariantViaGroupAdding(METRIC_TIRE);
        pp.clickSaveVariant();
        pp.checkVariantType(TIRE_TYPE_METRIC);
    }

    @Test //проверяем, что при ручном добавлении марикровки кнопки добавления неактивные
    public void checkAddBtnsWhenClickManuallyBtn() {
        pp.clickManuallyAddBtn();
        pp.checkAddBtnsIsDisabled();
    }

    @Test //проверяем, при клике на кнопку "добавить вручную" добавляется пустая строка для ввода маркировки
    public void checkNewRowForAddVariant() {
        pp.clickManuallyAddBtn();
        pp.checkAddRowIsVisible();
    }

    @Test //проверяем отображение кнопок "Сохранить/Отменить" при добавлении вручную
    public void checkSaveCancelBtnsIsDisplayWhenAddingManually() {
        pp.clickManuallyAddBtn();
        pp.checkSaveCancelBtnsIsDisplay();
    }

    @Test //проверяем отображение окна подтверждения при нажатии Отменить добавление шины
    public void checkModalConfirmIsDisplayed() {
        pp.clickManuallyAddBtn();
        pp.clickCancelBtn();
        pp.checkConfirmModalIsAppear(CANCEL_TITLE_MODAL_CONFIRM);
    }

    @Test //проверяем строка удаляется, при нажатии "Да" в модалке "Точно отменить?"
    public void checkRowIsDisappearAfterConfirmCancel() {
        pp.clickManuallyAddBtn();
        pp.clickCancelBtn();
        pp.clickYesBtnConfirmModal();
        pp.checkRowIsHideAfterConfirmCancel();
    }

    @Test
    //проверяем строка не удаляется, при нажатии "Нет" в модалке "Точно отменить?"
    public void checkRowIsVisibleAfterUnconfirmCancel() {
        pp.clickManuallyAddBtn();
        pp.clickCancelBtn();
        pp.clickNoBtnConfirmModal();
        pp.checkAddRowIsVisible();
        pp.checkAddBtnsIsDisabled();
    }

    @Test //проверяем текст сообщения об ошибке при сохранении пустой шины
    public void checkErrorMessage() {
        pp.clickManuallyAddBtn();
        pp.clickSaveBtn();
        lt.checkErrorMessage();
        int a = 2;
    }

    @Test //проверяем, что поле Название варианта - обязательное, если не заполнено - подсвечивается красным
    public void emptyTireVariantNameBorderColorIsRed() {
        pp.clickManuallyAddBtn();
        pp.clickSaveBtn();
        pp.checkEmptyTireVariantNameBorderColor();
    }

    @Test //проверяем, что поле Диаметр - обязательное, если не заполнено - подсвечивается красным
    public void emptyTireDiameterBorderColorIsRed() {
        pp.clickManuallyAddBtn();
        pp.clickSaveBtn();
        pp.checkEmptyTireDiameterBorderColor();
    }

    @Test //проверяем, что поле Ширина протектора - обязательное, если не заполнено - подсвечивается красным
    public void emptyTireWidthBorderColorIsRed() {
        pp.clickManuallyAddBtn();
        pp.clickSaveBtn();
        pp.checkEmptyTireWidthBorderColor();
    }

    @Test //проверяем, что поле Ширина протектора - обязательное, если не заполнено - подсвечивается красным
    public void emptyTireVariantTypeBorderColorIsRed() {
        pp.clickManuallyAddBtn();
        pp.clickSaveBtn();
        pp.checkEmptyTireVariantTypeBorderColor();
        int a =1;
    }

}
