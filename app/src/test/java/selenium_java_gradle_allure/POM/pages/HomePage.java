package selenium_java_gradle_allure.POM.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import selenium_java_gradle_allure.POM.TestBase;;

public class HomePage extends TestBase {

    @FindBy(xpath = "//h1[contains(text(),'Your account')]")
    private WebElement homePageTitle;

    public HomePage() {
        // this.driver = driver;
        PageFactory.initElements(driver, this);
        isLoaded();
    }

    public void isLoaded() throws Error {
        waitForVisibility(homePageTitle);
    }

}
