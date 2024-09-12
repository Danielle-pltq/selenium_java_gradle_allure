package selenium_java_gradle_allure;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CoffeeTest {

    WebDriver driver;
    String Url = "https://coffee-cart.app/";

    @BeforeTest
    public void SetUp() {
        // setting the driver executable
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-search-engine-choice-screen");
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
    }

    @Test
    public void TestNavigateToSite() {
        String title = TestHelpers.NavigateToSite(driver, "https://coffee-cart.app/");
        Assert.assertEquals(title, "Coffee cart");
    }

    @Test
    public void AddOneToCartAndVerifyPrice() {
        TestHelpers.NavigateToSite(driver, "https://coffee-cart.app/");
        TestHelpers.AddToCart(driver, "Espresso");
        Assert.assertEquals(TestHelpers.GetCartTotal(driver), 10.00);
    }

    @Test
    public void AddThreeToCartAndVerifyPrice() {
        TestHelpers.NavigateToSite(driver, "https://coffee-cart.app/");
        TestHelpers.AddToCart(driver, "Cappuccino");
        TestHelpers.AddToCart(driver, "Americano");
        TestHelpers.AddToCart(driver, "Cafe_Breve");
        Assert.assertEquals(TestHelpers.GetCartTotal(driver), 41.00);
    }

    @AfterTest
    public void TearDown() {
        driver.quit();
    }

}
