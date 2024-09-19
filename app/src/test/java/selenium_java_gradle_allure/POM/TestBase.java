package selenium_java_gradle_allure.POM;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import selenium_java_gradle_allure.GenericTestHelpers;

public class TestBase {
    public static final double DELTA = 1e-15;

    public static WebDriver driver;

    @BeforeTest
    public void Setup() {
        driver = GenericTestHelpers.getHeadlessDriver("chrome");
        // driver = GenericTestHelpers.getDriver("chrome", false);
    }

    @AfterTest
    public void TearDown() {
        driver.quit();
    }
}
