package selenium_java_gradle_allure.POM.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import selenium_java_gradle_allure.POM.TestBase;

public class LandingPage extends TestBase {

    @FindBy(id = "carousel")
    private WebElement carousel;

    public LandingPage() {
        PageFactory.initElements(driver, this);
        isLoaded();
    }

    public void isLoaded() throws Error {
        waitForVisibility(carousel);
    }

}
