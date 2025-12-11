package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;

import static enums.TitleNaming.CARTS;
import static enums.TitleNaming.PRODUCTS;
import static org.testng.Assert.*;
import static user.UserFactory.withAdminPermission;


public class CartTest extends BaseTest {

    @Epic("Работа с корзиной")
    @Feature("Просмотр содержимого")
    @Story("Проверка добавленных товаров в корзине")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("IFAT")
    @Issue("IFAT")
    @Owner("Chirkov Ivan ivan_chirkov@list.ru")
    @Test
    public void checkGoodsInCart() {
        loginPage
                .open()
                .login(withAdminPermission());
        productsPage.isPageLoaded(PRODUCTS.getDisplayName());
        productsPage
                .addToCart("Test.allTheThings() T-Shirt (Red)")
                .addToCart("Sauce Labs Onesie")
                .addToCart("Sauce Labs Fleece Jacket");
        loginPage
                .open("cart.html")
                .isPageLoaded(CARTS.getDisplayName());

        assertEquals(cartPage.getProductsNames().size(), 3);
        assertFalse(cartPage.getProductsNames().isEmpty());
        assertTrue(cartPage.getProductsNames().contains("Sauce Labs Onesie"));
        assertTrue(cartPage.getProductsNames().contains("Test.allTheThings() T-Shirt (Red)"));
        assertTrue(cartPage.getProductsNames().contains("Sauce Labs Fleece Jacket"));
    }
}
