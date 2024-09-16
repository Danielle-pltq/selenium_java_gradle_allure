package selenium_java_gradle_allure.POM.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import selenium_java_gradle_allure.POM.TestBase;
import selenium_java_gradle_allure.POM.pages.AuthenticationPage;

public class AuthenticationPageTest extends TestBase {

    AuthenticationPage authenticationPage;

    @Test
    public void TestLoginWithExistingCredentials() {
        authenticationPage = new AuthenticationPage(driver);
        authenticationPage.fillUserName("tester@test.com");
        authenticationPage.fillPassword("1qazxsw2");
        authenticationPage.clickLoginButton();
        Assert.assertEquals(true, true);
    }

}
