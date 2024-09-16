package selenium_java_gradle_allure.POM;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import selenium_java_gradle_allure.GenericTestHelpers;

public class TestBase {

    protected WebDriver driver;

    @BeforeMethod
    public void Setup() {
        driver = GenericTestHelpers.getHeadlessDriver("chrome");
        driver.get("https://testshop.polteq-testing.com/en/login");
    }

    @AfterMethod
    public void TearDown() {
        driver.quit();
    }

}
