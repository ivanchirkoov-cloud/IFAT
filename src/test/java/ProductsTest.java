import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Страница проверки функционала товара
 */
public class ProductsTest extends BaseTest {
    @Test
    public void checkGoodsAdded() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.isPageLoaded();
        productsPage.addToCart("Test.allTheThings() T-Shirt (Red)");
        productsPage.addToCart("Sauce Labs Onesie");
        productsPage.addToCart("Sauce Labs Fleece Jacket");

        assertEquals(productsPage.checkGoodsQuantity(), "3");
    }
}
