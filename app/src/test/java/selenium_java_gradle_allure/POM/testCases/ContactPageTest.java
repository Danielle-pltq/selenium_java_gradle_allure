package selenium_java_gradle_allure.POM.testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import selenium_java_gradle_allure.POM.TestBase;
import selenium_java_gradle_allure.POM.pages.ContactPage;

public class ContactPageTest extends TestBase {
    ContactPage contactPage;

    @BeforeMethod
    public void ContactPageSetup() {
        driver.manage().deleteAllCookies();
        driver.get("https://testshop.polteq-testing.com/en/contact-us");
        contactPage = new ContactPage(driver);
    }

    @Test
    @Epic("Polteq testshop")
    @Feature("Contact Page")
    public void TestFillInContactForm() {
        contactPage
                .selectSubject("Customer service")
                .typeEmail("test@test.com")
                .typeMessage("This is the automatic test message, filled in by selenium.")
                .SendContactForm();
        Assert.assertEquals(contactPage.getVerficationText(), "Your message has been successfully sent to our team.");
    }
}
