package selenium_java_gradle_allure.POM.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium_java_gradle_allure.POM.TestBase;;

public class HomePage {

    private WebDriver driver;

    @FindBy(xpath = "//h1[contains(text(),'Your account')]")
    private WebElement homePageTitle;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(TestBase.driver, this);
        isLoaded();
    }

    public void isLoaded() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(homePageTitle));
    }

}
