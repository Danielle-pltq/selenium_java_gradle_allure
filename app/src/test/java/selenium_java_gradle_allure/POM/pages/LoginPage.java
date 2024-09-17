package selenium_java_gradle_allure.POM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;

    @FindBy(css = "input[type='email']")
    private WebElement emailTextField;

    @FindBy(css = "input[type='password']")
    private WebElement passwordTextField;

    @FindBy(id = "submit-login")
    private WebElement loginButton;

    private By errorMessageBy = By.className("alert");

    public LoginPage fillUserName(String username) {
        emailTextField.sendKeys(username);
        return this;
    }

    public LoginPage fillPassword(String password) {
        passwordTextField.sendKeys(password);
        return this;
    }

    public Object clickLoginButton() {
        loginButton.click();
        if (IsInvalidLoginErrorPresent()) {
            return this; // Return the LoginPage if there's an error
        } else {
            return new HomePage(driver); // Return the HomePage if login is successful
        }
    }

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean IsInvalidLoginErrorPresent() {
        return driver.findElements(errorMessageBy).size() != 0;
    }
}
