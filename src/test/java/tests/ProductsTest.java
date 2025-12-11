package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;

import static enums.TitleNaming.PRODUCTS;
import static org.testng.Assert.assertEquals;
import static user.UserFactory.withAdminPermission;

/**
 * Страница проверки функционала товара
 */
public class ProductsTest extends BaseTest {
    @Epic("Работа с корзиной")
    @Feature("Добавление товаров")
    @Story("Добавление нескольких товаров разными способами")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("IFAT")
    @Issue("IFAT")
    @Owner("Chirkov Ivan ivan_chirkov@list.ru")
    @Test
    public void checkGoodsAdded() {
        loginPage
                .open()
                .login(withAdminPermission());
        productsPage.isPageLoaded(PRODUCTS.getDisplayName());
        productsPage
                .addToCart("Test.allTheThings() T-Shirt (Red)")
                .addToCart("Sauce Labs Onesie")
                .addToCart("Sauce Labs Fleece Jacket")
                .addToCart(1);

        assertEquals(productsPage.checkGoodsQuantity(), "4");
    }
}
