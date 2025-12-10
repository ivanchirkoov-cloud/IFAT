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
    public void open() {
        driver.get(BASE_URL);
    }

    public void open(String url) {
        driver.get(BASE_URL + url);
    }

    @Step("Вход под учетной записью пользователя: логин ={user.email}, пароль = ******")
    public void login(User user) {
        enterLoginName(user.getEmail());
        driver.findElement(passwordField).sendKeys(user.getPassword());
        driver.findElement(loginBtn).click();
    }

    @Step("Вводим логин")
    public void enterLoginName(final String userName) {
        driver.findElement(userField).sendKeys(userName);
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
