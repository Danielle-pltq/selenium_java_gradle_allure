package selenium_java_gradle_allure.POM.testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;

import selenium_java_gradle_allure.POM.TestBase;
import selenium_java_gradle_allure.POM.pages.HomePage;
import selenium_java_gradle_allure.POM.pages.LoginPage;

public class LoginPageTest extends TestBase {

    LoginPage loginPage;

    @BeforeMethod
    public void LoginPageSetup() {
        driver.get("https://testshop.polteq-testing.com/en/login?back=my-account");
        loginPage = new LoginPage(driver);
    }

    @Test
    @Epic("Polteq testshop")
    @Feature("Login Page")
    public void TestLoginValidCredentials() {
        Object page = loginPage
                .fillUserName("tester@test.com")
                .fillPassword("1qazxsw2")
                .clickLoginButton();
        Assert.assertEquals(page instanceof HomePage, true);
        Assert.assertEquals(driver.getTitle(), "My account");
    }

    @Test
    @Epic("Polteq testshop")
    @Feature("Login Page")
    public void TestLoginInvalidCredentials() {
        Object page = loginPage
                .fillUserName("notanemailadress@test.com")
                .fillPassword("hallo")
                .clickLoginButton();

        Assert.assertEquals(page instanceof LoginPage, true);
        Assert.assertEquals(driver.getTitle(), "Login");
    }

}
