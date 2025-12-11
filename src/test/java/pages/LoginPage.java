package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import user.User;

/**
 * Страница описывает функционал входа
 */
public class LoginPage extends BasePage {

    By userField = By.cssSelector("[placeholder='Username']");
    By passwordField = By.cssSelector("[placeholder='Password']");
    By loginBtn = By.id("login-button");
    By error = By.xpath("//*[@data-test='error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие страницы")
    public LoginPage  open() {
        driver.get(BASE_URL);
        return this;
    }

    public LoginPage open(String url) {
        driver.get(BASE_URL + url);
        return this;
    }

    @Step("Вход под учетной записью пользователя: логин ={user.email}, пароль = ******")
    public LoginPage login(User user) {
        enterLoginName(user.getEmail());
        driver.findElement(passwordField).sendKeys(user.getPassword());
        driver.findElement(loginBtn).click();
        return this;
    }

    @Step("Вводим логин")
    public LoginPage enterLoginName(final String userName) {
        driver.findElement(userField).sendKeys(userName);
        return this;
    }

    @Step("Отображение сообщения об ошибке")
    public boolean isErrorMsgAppear() {
        return driver.findElement(error).isDisplayed();
    }

    @Step("Поучаем текст сообщения об ошибке")
    public String errorMessageText() {
        return driver.findElement(error).getText();
    }
}
