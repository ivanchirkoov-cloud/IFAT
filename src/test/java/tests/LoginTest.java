package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Страница тестирования функционала входа
 */
public class LoginTest extends BaseTest {

    @DataProvider(name = "invalidData")
    public Object[][] loginData() {
        return new Object[][]{
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."},
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"standard_user", "", "Epic sadface: Password is required"},
                {"", "","Epic sadface: Username is required"},
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."}
        };
    }

    @Test(description = "Проверка некорректного логина", priority = 1, dataProvider = "invalidData")
    public void checkIncorrectLogin(String user, String password, String errorMsg) {
        loginPage.open();
        loginPage.login(user, password);
        assertTrue(loginPage.isErrorMsgAppear(), "Error message does not appear");
        assertEquals(loginPage.errorMessageText(), errorMsg);
    }

    @Test(description = "Проверка корректного логина", priority = 2)
    public void checkCorrectLogin() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertTrue(productsPage.isPageLoaded("Products"), "Register btn is not visible");
    }
}
