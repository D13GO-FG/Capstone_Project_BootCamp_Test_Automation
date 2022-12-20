package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver webDriver) {
        super(webDriver);
    }

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
