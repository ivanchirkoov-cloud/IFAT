package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Страница описывает функционал витрины с товарами
 */
public class ProductsPage extends BasePage {
    By pageTitle = By.xpath("//*[@data-test='title']");
    private static final String ADD_TO_CARD_BUTTON_PATTERN =
            "//div[text()='%s']//ancestor::div[@class='inventory_item']//button";

    By cartBadge = By.xpath("//*[@data-test='shopping-cart-link']");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageLoaded() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitle));
        return driver.findElement(pageTitle).isDisplayed();
    }

    public void addToCart(final String goodsName) {
        By addGoodsToCart = By.xpath(String.format(ADD_TO_CARD_BUTTON_PATTERN, goodsName));
        driver.findElement(addGoodsToCart).click();
    }

    public String checkGoodsQuantity() {
        return  driver.findElement(cartBadge).getText();
    }
}
