package tests;

import org.testng.annotations.Test;

import static user.UserFactory.withAdminPermission;
import static org.testng.Assert.assertEquals;

/**
 * Страница проверки функционала товара
 */
public class ProductsTest extends BaseTest {
    @Test
    public void checkGoodsAdded() {
        loginPage.open();
        loginPage.login(withAdminPermission());

        productsPage.isPageLoaded("Products");
        productsPage.addToCart("Test.allTheThings() T-Shirt (Red)");
        productsPage.addToCart("Sauce Labs Onesie");
        productsPage.addToCart("Sauce Labs Fleece Jacket");
        productsPage.addToCart(1);
        assertEquals(productsPage.checkGoodsQuantity(), "4");
    }
}
