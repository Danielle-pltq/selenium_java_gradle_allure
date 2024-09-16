package selenium_java_gradle_allure;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import org.testng.Assert;

public class CoffeeTest {

    WebDriver driver;

    @BeforeTest
    public void SetUp() {
        driver = GenericTestHelpers.getHeadlessDriver("edge");
    }

    @Test
    public void TestNavigateToSite() {
        String title = CoffeeTestHelpers.NavigateToSite(driver, "https://coffee-cart.app/");
        Assert.assertEquals(title, "Coffee cart");
    }

    @Test
    public void AddOneToCartAndVerifyPrice() {
        CoffeeTestHelpers.NavigateToSite(driver, "https://coffee-cart.app/");
        CoffeeTestHelpers.AddToCart(driver, "Espresso");
        Assert.assertEquals(CoffeeTestHelpers.GetCartTotal(driver), 10.00);
    }

    @Test
    public void AddThreeToCartAndVerifyPrice() {
        CoffeeTestHelpers.NavigateToSite(driver, "https://coffee-cart.app/");
        CoffeeTestHelpers.AddToCart(driver, "Cappuccino");
        CoffeeTestHelpers.AddToCart(driver, "Americano");
        CoffeeTestHelpers.AddToCart(driver, "Cafe_Breve");
        Assert.assertEquals(CoffeeTestHelpers.GetCartTotal(driver), 41.00);
    }

    @AfterTest
    public void TearDown() {
        driver.quit();
    }

}
