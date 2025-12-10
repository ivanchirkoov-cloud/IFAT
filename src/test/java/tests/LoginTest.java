package tests;


import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import user.User;

import static enums.TitleNaming.PRODUCTS;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static user.UserFactory.*;

/**
 * Страница тестирования функционала входа
 */
public class LoginTest extends BaseTest {

    @DataProvider(name = "invalidData")
    public Object[][] loginData() {
        return new Object[][]{
                {withAdminPermission(), "Epic sadface: Sorry, this user has been locked out."},
                {withNullUserPermission(), "Epic sadface: Username is required"},
                {withNullPasswordPermission(), "Epic sadface: Password is required"},
                {withNullNullPermission(), "Epic sadface: Username is required"},
        };
    }

    @Epic("Авторизация")
    @Feature("Негативные сценарии")
    @Story("Попытка входа заблокированным пользователем")
    @Severity(SeverityLevel.BLOCKER)
    @TmsLink("IFAT")
    @Issue("IFAT")
    @Owner("Chirkov Ivan ivan_chirkov@list.ru")
    @Test(description = "Проверка некорректного логина", priority = 1, dataProvider = "invalidData")
    public void checkIncorrectLogin(User user, String expectedMessage) {
        loginPage.open();
        loginPage.login(withLockedUserPermission());

        assertTrue(loginPage.isErrorMsgAppear(), "Error message does not appear");
        assertEquals(loginPage.errorMessageText(), "Epic sadface: Sorry, this user has been locked out.");
    }

    @Epic("Авторизация")
    @Feature("Позитивные сценарии")
    @Story("Попытка входа администратором")
    @Test(description = "Проверка корректного логина", priority = 2)
    public void checkCorrectLogin() {
        loginPage.open();
        loginPage.login(withAdminPermission());

        assertTrue(productsPage.isPageLoaded(PRODUCTS.getDisplayName()), "Register btn is not visible");
    }
}
