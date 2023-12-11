package catalog.web;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {

    private final static String LOGIN = "//*[@id='login-form_username']"; // локатор поля Логин
    private final static String PASSWORD = "//*[@id='login-form_password']"; // локатор поля Пароль
    private final static String SUBMIT_BTN = "//button[@type='submit']"; // Локатор кнопки Войти

    public void setLoginInput(String login) {
        $x(LOGIN).setValue(login);
    } // Метод ввода Логина

    // Метод ввода Пароля
    public void setPasswordInput(String password) {
        $x(PASSWORD).setValue(password);
    }

    //Метод клика на кнопку Войти
    public void clickSubmitButton() {
        $x(SUBMIT_BTN).click();
    }


};



