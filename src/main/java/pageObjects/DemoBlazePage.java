package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DemoBlazePage extends BasePage {
    public DemoBlazePage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(how = How.XPATH, using = "(//a[normalize-space()='Phones'])[1]")
    private WebElement categoryPhone;

    @FindBy(how = How.XPATH, using = "(//a[normalize-space()='Laptops'])[1]")
    private WebElement categoryLaptop;

    @FindBy(how = How.XPATH, using = "(//a[normalize-space()='Monitors'])[1]")
    private WebElement categoryMonitor;

    @FindBy(how = How.XPATH, using = "(//div[@class='col-lg-4 col-md-6 mb-4'])[1]")
    private WebElement productCatalog;

    @FindBy(how = How.XPATH, using = "//h2[@class='name']")
    private WebElement productName;

    @FindBy(how = How.XPATH, using = "//h3[@class='price-container']")
    private WebElement productPrice;

    @FindBy(how = How.XPATH, using = "//div[@id='more-information']//p")
    private WebElement productDescription;

    @FindBy(how = How.XPATH, using = "//div[@class='item active']//img")
    private WebElement productImage;

    @FindBy(how = How.XPATH, using = "//a[text()='Add to cart']")
    private WebElement cartButton;

    public WebElement getCategoryPhone() {
        return categoryPhone;
    }

    public WebElement getCategoryLaptop() {
        return categoryLaptop;
    }

    public WebElement getCategoryMonitor() {
        return categoryMonitor;
    }

    public WebElement getProductCatalog() {
        return productCatalog;
    }

    public WebElement getProductName() {
        return productName;
    }

    public WebElement getProductPrice() {
        return productPrice;
    }

    public WebElement getProductDescription() {
        return productDescription;
    }

    public WebElement getProductImage() {
        return productImage;
    }

    public WebElement getCartButton() {
        return cartButton;
    }
}
