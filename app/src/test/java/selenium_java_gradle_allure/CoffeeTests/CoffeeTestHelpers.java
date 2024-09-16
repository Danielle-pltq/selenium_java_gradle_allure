package selenium_java_gradle_allure.CoffeeTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CoffeeTestHelpers {
    public static By CartTotal = By.xpath("//button[contains(@data-test, 'checkout')]");

    public static String NavigateToSite(WebDriver drv, String url) {
        drv.get(url);
        return drv.getTitle();
    }

    public static void AddToCart(WebDriver drv, String coffee) {
        By CoffeeElement = By.xpath("//div[contains(@data-test, '" + coffee + "')]");
        WaitUntillClickableAndClick(drv, CoffeeElement);
    }

    public static void WaitUntillClickableAndClick(WebDriver drv, By element) {
        WebDriverWait wait = new WebDriverWait(drv, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        drv.findElement(element).click();
    }

    public static float GetCartTotal(WebDriver drv) {
        String text = drv.findElement(CartTotal).getText();
        String[] parts = text.split(" ", 2);
        String total = parts[1].substring(1, parts[1].length());
        return Float.valueOf(total);
    }
}
