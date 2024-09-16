package selenium_java_gradle_allure.POM;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import selenium_java_gradle_allure.GenericTestHelpers;

public class TestBase {

    protected static WebDriver driver;

    @BeforeTest
    public void Setup() {
        driver = GenericTestHelpers.getHeadlessDriver("chrome");
        // driver = GenericTestHelpers.getDriver("chrome", false);
    }

    @AfterTest
    public void TearDown() {
        driver.quit();
    }

    public void waitForVisibility(WebElement element) throws Error {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(element));
    }
}
