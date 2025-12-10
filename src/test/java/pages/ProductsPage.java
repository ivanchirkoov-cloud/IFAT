package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


/**
 * Страница описывает функционал витрины с товарами
 */
public class ProductsPage extends BasePage {
    private static final String ADD_TO_CARD_BUTTON_PATTERN =
            "//div[text()='%s']//ancestor::div[@class='inventory_item']//button";

    By cartBadge = By.xpath("//*[@data-test='shopping-cart-link']");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Получаем сисок товаров")
    public void addToCart(final String goodsName) {
        By addGoodsToCart = By.xpath(ADD_TO_CARD_BUTTON_PATTERN.formatted(goodsName));
        driver.findElement(addGoodsToCart).click();
    }

    @Step("Добавляем в корзину товар из списка")
    public void addToCart(final int goodsOrder) {
        driver.findElements(By.xpath(TEXT_LOCATOR_PATTERN.formatted("Add to cart"))).get(goodsOrder).click();
    }

    @Step("Получаем количество товаров в корзине")
    public String checkGoodsQuantity() {
        return driver.findElement(cartBadge).getText();
    }

}
