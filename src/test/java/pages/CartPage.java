package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Страница описывает функционал корзины
 */
public class CartPage extends BasePage {
    By cartPr = By.cssSelector(".inventory_item_name");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Step("Получаем список названий в корзине")
    public ArrayList<String> getProductsNames() {
        List<WebElement> allProductsNames = driver.findElements(cartPr);
        ArrayList<String> names = new ArrayList<>();
        for (WebElement product : allProductsNames) {
            names.add(product.getText());
        }

        return names;
    }
}
