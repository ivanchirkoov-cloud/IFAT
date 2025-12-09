package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

    public void open() {
        driver.get(BASE_URL);
    }

    public void open(String url) {
        driver.get(BASE_URL + url);
    }

    public void login(final String userName, final String passwordName) {
        driver.findElement(userField).sendKeys(userName);
        driver.findElement(passwordField).sendKeys(passwordName);
        driver.findElement(loginBtn).click();

    }

    public boolean isErrorMsgAppear() {
        return driver.findElement(error).isDisplayed();
    }

    public String errorMessageText() {
        return driver.findElement(error).getText();
    }
}
