package selenium_java_gradle_allure.POM.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductdetailPage {
    private WebDriver driver;
    private String itemName;

    @FindBy(id = "product")
    private WebElement productPage;

    @FindBy(id = "group_1")
    private WebElement sizeSelector;

    @FindBy(id = "quantity_wanted")
    private WebElement quantitySelector;

    @FindBy(xpath = "//button[@data-button-action='add-to-cart']")
    private WebElement addtocartButton;

    @FindBy(xpath = "//*[@itemprop='price']")
    private WebElement itemPrice;

    @FindBy(className = "modal-dialog")
    private WebElement modelDialog;

    @FindBy(xpath = "//*[contains(@class, 'modal-dialog')]//*[contains(text(), 'shopping cart')]")
    private WebElement modelDialogTextShoppingCart;

    @FindBy(xpath = "//*[contains(@class, 'modal-dialog')]//*[contains(@class,'modal-title')]")
    private WebElement modelDialogText;

    @FindBy(xpath = "//*[contains(@class, 'modal-dialog')]//*[contains(@class,'subtotal')]")
    private WebElement modelDialogSubtotal;

    @FindBy(xpath = "//*[contains(@class, 'modal-dialog')]//a[contains(@class,'btn')]")
    private WebElement modelDialogProceedToCheckoutButton;

    public ProductdetailPage(WebDriver driver, String item) {
        this.driver = driver;
        this.itemName = item;
        PageFactory.initElements(driver, this);
        isLoaded(productPage);
    }

    public void isLoaded(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(element));
    }

    public float getProductPrice() {
        String stringprice = itemPrice.getText();
        String price = stringprice.substring(1, stringprice.length());
        return Float.valueOf(price);
    }

    public ProductdetailPage selectSize(String size) {
        Select selectSize = new Select(sizeSelector);
        selectSize.selectByVisibleText(size);
        return this;
    }

    public ProductdetailPage selectQuantity(String quantity) {
        quantitySelector.clear();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        quantitySelector.sendKeys(quantity);
        return this;
    }

    public void addToCart() {
        addtocartButton.click();
        isLoaded(modelDialogTextShoppingCart);
    }

    public float getSubtotalFromModel() {
        String stringprice = modelDialogSubtotal.getText();
        String price = stringprice.substring(1, stringprice.length());
        return Float.valueOf(price);
    }

}
