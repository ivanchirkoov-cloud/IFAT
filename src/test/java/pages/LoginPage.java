package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    By userField = By.cssSelector("[placeholder='Username']");
    By passwordField = By.cssSelector("[placeholder='Password']");
    By loginBtn = By.id("login-button");
    By error = By.xpath("//*[@data-test='error'] h3");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://www.saucedemo.com/");
    }

    public void login(final String username,final String passwordName) {
        driver.findElement(userField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(passwordName);
        driver.findElement(loginBtn).click();
    }

    public boolean isErrorMsgAppear(){
        return driver.findElement(error).isDisplayed();
    }
    public String errorMessageText(){
        return driver.findElement(error).getText();
    }
}