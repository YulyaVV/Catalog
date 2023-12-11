package catalog.web;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;


public abstract class SetBrowser {

    public void setUpBrowser(){

        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome"; //можнр указать firefox
        //Configuration.driverManagerEnabled = true;
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false; //будем ли мы видеть браузер при выполнении тестов
        //Configuration.timeout = 2000;
    }

    @Before
    public void init() {
        setUpBrowser();
    }

    @After
    public void tearDown() {
        Selenide.closeWebDriver();
    }


}
