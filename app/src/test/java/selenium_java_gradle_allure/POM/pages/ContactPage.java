package selenium_java_gradle_allure.POM.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactPage {
    private WebDriver driver;

    @FindBy(xpath = "//select[@name='id_contact']")
    private WebElement subjectField;

    @FindBy(xpath = "//input[@name='from']")
    private WebElement emailField;

    @FindBy(xpath = "//textarea[@name='message']")
    private WebElement messageField;

    @FindBy(xpath = "//input[@name='submitMessage']")
    private WebElement sendButton;

    @FindBy(xpath = "//section[contains(@class, 'contact-form')]//ul/li")
    private WebElement verification;

    public ContactPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        isLoaded(subjectField);
    }

    public void isLoaded(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(element));
    }

    public ContactPage selectSubject(String subject) {
        Select selectSubject = new Select(subjectField);
        selectSubject.selectByVisibleText(subject);
        return this;
    }

    public ContactPage typeEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }

    public ContactPage typeMessage(String message) {
        messageField.sendKeys(message);
        return this;
    }

    public void SendContactForm() {
        sendButton.click();
        isLoaded(verification);
    }

    public String getVerficationText() {
        return verification.getText();
    }

}
