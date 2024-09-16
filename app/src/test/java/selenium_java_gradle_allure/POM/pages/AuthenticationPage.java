package selenium_java_gradle_allure.POM.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthenticationPage {
    @FindBy(css = "input[type='email']")
    private WebElement emailTextField;

    @FindBy(css = "input[type='password']")
    private WebElement passwordTextField;

    @FindBy(id = "submit-login")
    private WebElement loginButton;

    public void fillUserName(String username) {
        emailTextField.sendKeys(username);
    }

    public void fillPassword(String password) {
        passwordTextField.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public AuthenticationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
