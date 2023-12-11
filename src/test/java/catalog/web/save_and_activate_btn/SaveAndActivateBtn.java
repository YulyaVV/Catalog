package catalog.web.save_and_activate_btn;

import catalog.web.LoginPage;
import catalog.web.MainPage;
import catalog.web.OpenURL;
import catalog.web.LocatorsTest;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class SaveAndActivateBtn {

    private MainPage mp = new MainPage();
    private LocatorsTest lt = new LocatorsTest();
    private final static String URL_LOGIN = "https://farpost-catalog.kubernetes.bazadev.net/admin/login";
    private final static String INACTIVE_MODEL = "https://farpost-catalog.kubernetes.bazadev.net/admin/models/38440#main"; //неактивная модель
    private final static  String BTN_YES = "ДА";
    private final static String NAME = new String(String.valueOf(System.currentTimeMillis()));

    @Before
    public void openBrowser() {
        new OpenURL(URL_LOGIN);
    }

    @Test //проверяем на неактивной модели - с дебагом отрабатывает, а без дебага валится тест. не успевает видимо отработать. поставила ожидание - так работает.
    public void checkSaveAndActivateButton() throws InterruptedException {
        new OpenURL(INACTIVE_MODEL);
        Thread.sleep(2000);
            lt.clickSaveAndActivatedButton();
            mp.checkActivationBtnText(BTN_YES);
    }

    @Test
    public void checkSaveButton() {
        new OpenURL(INACTIVE_MODEL);
        String NEW_NAME = mp.setName(NAME);
            lt.clickSaveButton();
            mp.checkNewName(NEW_NAME);
    }
}
