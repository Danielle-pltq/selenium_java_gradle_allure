package selenium_java_gradle_allure.POM.testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import selenium_java_gradle_allure.POM.TestBase;
import selenium_java_gradle_allure.POM.pages.ProductdetailPage;

public class ProductdetailPageTest extends TestBase {
    ProductdetailPage productdetailPage;

    @BeforeMethod
    public void LoginPageSetup() {
        driver.manage().deleteAllCookies();
        driver.get("https://testshop.polteq-testing.com/en/women/2-9-brown-bear-printed-sweater.html");
        productdetailPage = new ProductdetailPage(driver, "Hummingbird printed sweater");
    }

    @Test
    @Epic("Polteq testshop")
    @Feature("Productdetail Page")
    public void TestAddToCartAndValidatePrice() {
        productdetailPage
                .selectSize("L")
                .selectQuantity("2")
                .addToCart();
        Assert.assertEquals(productdetailPage.getProductPrice() * 2, productdetailPage.getSubtotalFromModel(), DELTA);
    }

}
