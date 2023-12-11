package catalog.web.create_new_model_tests;

import catalog.web.MainPage;
import catalog.web.OpenURL;
import catalog.web.SetBrowser;
import catalog.web.LocatorsTest;
import org.junit.Before;
import org.junit.Test;

public class CreateNewModel_Tests extends SetBrowser {

    private MainPage mp = new MainPage();
    private LocatorsTest lt = new LocatorsTest();
    private final static String URL_LOGIN = "https://farpost-catalog.kubernetes.bazadev.net/admin/login";
    private final static String URL_CREATE_MODEL = "http://farpost-catalog.kubernetes.bazadev.net/admin/models/create";
    private final static String NAME = new String(String.valueOf(System.currentTimeMillis()));
    private final static String EXIST_NAME = "Mann-Filter W719";
    private final static String DESC = new String(String.valueOf(System.currentTimeMillis()));


    @Before
    public void openBrowser() {
        new OpenURL(URL_LOGIN);
        new OpenURL(URL_CREATE_MODEL);
    }


    @Test //Проверка названия страницы - Новая модель
    public void checkTitleCreateNewModePage() {
            mp.checkTitle();
    }

    @Test //После создания модели у страницы новый заголовок - установленное название модели, вместо "Новая модель"
    public void tryToCreateModelWithMainFields() {
            mp.setName(NAME);
            mp.clickCategoryField();
            mp.selectCategory();
            mp.setDescription(DESC);
            lt.clickSaveButton();
            mp.checkTitle();
    }

   @Test //после создания модели в навигационной панели отображаются новые вкладки
        //P.S. в категории Автозапчасти нет вкладки "Свойства модели", в остальных -есть
        //проверку делаю по названию вкладок, возможно это неверное решение и лучше сделать, что кол-во вкладок после сохранение > 1
    public void allTabsIsDisplayedAfterSaveNewModel() throws InterruptedException {
        MainPage mp = new MainPage();
        LocatorsTest lt = new LocatorsTest();
            mp.setName(NAME);
            mp.clickCategoryField();
            mp.selectCategory();
            mp.setDescription(DESC);
            lt.clickSaveButton();
            Thread.sleep(3000); //не понимаю как от этого избавиться?
            mp.checkTabsNameInNavPanel();
            //int a = 2;
   }

   @Test //нельзя создать модель без имени - сообщение об ошибке
    public  void tryToCreateModelWithoutName() throws InterruptedException {
            mp.clickCategoryField();
            mp.selectCategory();
            mp.setDescription(DESC);
            lt.clickSaveButton();
            Thread.sleep(2000);
            mp.checkColorBorderWithoutName(); //проверяем, что обводка у поля название красная
            lt.checkErrorMessage(); // проверяем текст ошибки
    }

    @Test //нельзя создать модель без категории - сообщение об ошибке
    public void tryToCreateModelWithoutCategory() throws InterruptedException {
            mp.setName(NAME);
            mp.setDescription(DESC);
            lt.clickSaveButton();
            Thread.sleep(2000); //не понимаю как это обойти
            mp.checkColorBorderWithoutCategory(); //проверяем, что обводка у поля категория красная
            lt.checkErrorMessage(); // проверяем текст ошибки
    }

    // недописан тест, не знаю как обращаться к поп-апу с ошибкой и кнопкой Ок
    @Test //нельзя создать модель с существующим именем и категорией - сообщение об ошибке "Модель ХХХ уже есть в категории УУУ"
    public void tryToCreateModelWithExistNameAndCategory() {
            mp.setName(EXIST_NAME);
            mp.clickCategoryField();
            mp.selectCategory();
            lt.clickSaveButton();
            //mp.checkErrorMessageForExistModel();
    }

    @Test // поле Описание - необязательное, можно создать модель без Описания.
    public void tryToCreateModelWithoutDescription() {
            mp.setName(NAME);
            mp.clickCategoryField();
            mp.selectCategory();
            lt.clickSaveButton();
            mp.checkTitle();
    }

}
