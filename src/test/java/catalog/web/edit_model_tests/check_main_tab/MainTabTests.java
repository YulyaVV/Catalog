package catalog.web.edit_model_tests.check_main_tab;

import catalog.web.*;
import org.junit.Before;
import org.junit.Test;

public class MainTabTests extends SetBrowser {

    private MainPage mp = new MainPage();
    private LocatorsTest lt = new LocatorsTest();

    private final static String URL_LOGIN = "https://farpost-catalog.kubernetes.bazadev.net/admin/login";
    private final static String URL_MODEL = "https://farpost-catalog.kubernetes.bazadev.net/admin/models/34301#main";
    private final static String URL_ACTIVE_MODEL = "https://farpost-catalog.kubernetes.bazadev.net/admin/models/28305#main"; //не нравится такой подход.. а как надо??
    private final static String URL_INACTIVE_MODEL = "https://farpost-catalog.kubernetes.bazadev.net/admin/models/28357#main"; //не нравится такой подход.. а как надо??
    private final static String NAME = new String(String.valueOf(System.currentTimeMillis()));
    private final static String DESC = new String(String.valueOf(System.currentTimeMillis()));
    private final static String TAB_NAME = "Основное";
    private final static String BTN_YES = "ДА";
    private final static String BTN_NO = "НЕТ";

    @Before
    public void openBrowser() {
        new OpenURL(URL_LOGIN);
    }

    @Test // проверяем, что вкладка называется - Основное
    public void checkTabName() {
        new OpenURL(URL_MODEL);
            lt.checkTextActiveTab(TAB_NAME);
    }

    @Test // Проверяем, что цвет текста активной вкладки "Основное" - синий
    public void activeTabTextColorIsBlue() {
        new OpenURL(URL_MODEL);
            lt.checkColorTextActiveTab();
    }

    @Test //Проверяем редактирование имени модели
    public void checkNewName()  {
        new OpenURL(URL_MODEL);
        mp.clearName(); // не очищается..
            String NEW_NAME = mp.setName(NAME);
            lt.clickSaveButton();
            mp.checkNewName(NEW_NAME);
    }

//    @Test
//    public void checkNewName_2() {
//        new OpenURL(URL_INACTIVE_MODEL);
//        ModelPage mp = new ModelPage();
//        String OLD_NAME = mp.getName();
//        mp.clearName();
//        mp.setName(NEW_NAME);
//        String EDIT_NAME = mp.getName();
//        mp.clickSaveDefaultButton();
//        Assert.assertNotEquals(OLD_NAME, EDIT_NAME);
//    }

    @Test //Проверяем, что заголовок страницы изменился после редактирования названия модели
    public void checkNewTitle() {
        new OpenURL(URL_MODEL);
            mp.clearName();
            mp.setName(NAME);
            lt.clickSaveButton();
            mp.checkTitle(); // проверяем, что title содержит новое название модели
    }

//    @Test
//    public void checkNewTitle_2() {
//        new OpenURL(URL_INACTIVE_MODEL);
//        ModelPage mp = new ModelPage();
//        String OLD_TITLE = mp.getPageTitleName();
//        mp.clearName();
//        mp.setName(NEW_NAME);
//        String NEW_TITLE = mp.getPageTitleName();
//        mp.clickSaveDefaultButton();
//        Assert.assertNotEquals(OLD_TITLE, NEW_TITLE);
//    }


    @Test // проверяем редактирование Описания.
    public void editDesc() {
        new OpenURL(URL_MODEL);
            mp.clearDescription();
            String NEW_DESC = mp.setDescription(DESC);
            lt.clickSaveButton();
            mp.checkNewDesc(NEW_DESC);
    }

//    @Test
//    public void editDesc_2() {
//        MainPage mp = new MainPage();
//        String OLD_DESC = mp.getDescription();
//        mp.clearDescription();
//        String NEW_DESC = mp.setDescription(DESC);
//        mp.clickSaveDefaultButton();
//        Assert.assertNotEquals(OLD_DESC, NEW_DESC);
//    }

    @Test // у активной модели кнопка активации называется "ДА"
    public void textActivationButtonForActiveModel() throws InterruptedException {
        new OpenURL(URL_ACTIVE_MODEL);
            Thread.sleep(2000);
            mp.checkActivationBtnText(BTN_YES);
    }

    @Test // Дезактивация активной модели, после дезактивации кнопка называется "НЕТ"
    public void inactivatedModel() {
        new OpenURL(URL_ACTIVE_MODEL);
            mp.clickIsActiveButton();
            mp.checkActivationBtnText(BTN_NO);
    }

    @Test // у неактивной модели кнопка активации называется "НЕТ"
    public void textActivationButtonForInactiveModel() {
        new OpenURL(URL_INACTIVE_MODEL);
            mp.checkActivationBtnText(BTN_NO);
    }

    @Test // Активация неактивной модели, после активации кнопка называется "ДА"
    public void activatedModel() {
        new OpenURL(URL_INACTIVE_MODEL);
            mp.clickIsActiveButton();
            mp.checkActivationBtnText(BTN_YES);
    }

}
