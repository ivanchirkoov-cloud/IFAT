package tests;

import org.testng.annotations.Test;

import static user.UserFactory.withAdminPermission;

import static org.testng.Assert.*;


public class CartTest extends BaseTest {

    @Test
    public void checkGoodsInCart() {
        loginPage.open();
        loginPage.login(withAdminPermission());
        productsPage.isPageLoaded("Products");
        productsPage.addToCart("Test.allTheThings() T-Shirt (Red)");
        productsPage.addToCart("Sauce Labs Onesie");
        productsPage.addToCart("Sauce Labs Fleece Jacket");
        loginPage.open("cart.html");

        assertEquals(cartPage.getProductsNames().size(), 3);
        assertFalse(cartPage.getProductsNames().isEmpty());
        assertTrue(cartPage.getProductsNames().contains("Sauce Labs Onesie"));
        assertTrue(cartPage.getProductsNames().contains("Test.allTheThings() T-Shirt (Red)"));
        assertTrue(cartPage.getProductsNames().contains("Sauce Labs Fleece Jacket"));
    }
}
