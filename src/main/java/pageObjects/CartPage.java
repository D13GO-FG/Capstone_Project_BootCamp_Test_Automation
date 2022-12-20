package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class CartPage extends BasePage {
    public CartPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(how = How.XPATH, using = "//h3[@id='totalp']")
    private WebElement totalCart;

    @FindBy(how = How.XPATH, using = "//button[normalize-space()='Place Order']")
    private WebElement btnPlaceOrder;

    @FindBy(how = How.XPATH, using = "//tbody/tr")
    private List<WebElement> tableCart;

    @FindBy(how = How.XPATH, using = "//a[normalize-space()='Cart']")
    private WebElement btnCart;

    @FindBy(how = How.XPATH, using = "//div[@id='orderModal']//div[@class='modal-content']")
    private WebElement modalPurchase;

    @FindBy(how = How.ID, using = "name")
    private WebElement inputName;

    @FindBy(how = How.ID, using = "country")
    private WebElement inputCountry;

    @FindBy(how = How.ID, using = "city")
    private WebElement inputCity;

    @FindBy(how = How.ID, using = "card")
    private WebElement inputCard;

    @FindBy(how = How.ID, using = "month")
    private WebElement inputMonth;

    @FindBy(how = How.ID, using = "year")
    private WebElement inputYear;

    @FindBy(how = How.XPATH, using = "//button[normalize-space()='Purchase']")
    private WebElement btnPurchase;

    @FindBy(how = How.XPATH, using = "//h2[normalize-space()='Thank you for your purchase!']")
    private WebElement titleSuccess;

    @FindBy(how = How.XPATH, using = "//button[normalize-space()='OK']")
    private WebElement btnOK;

    public WebElement getTotalCart() {
        return totalCart;
    }

    public WebElement getBtnPlaceOrder() {
        return btnPlaceOrder;
    }

    public List<WebElement> getTableCart() {
        return tableCart;
    }

    public WebElement getBtnCart() {
        return btnCart;
    }

    public WebElement getInputName() {
        return inputName;
    }

    public WebElement getInputCountry() {
        return inputCountry;
    }

    public WebElement getInputCity() {
        return inputCity;
    }

    public WebElement getInputCard() {
        return inputCard;
    }

    public WebElement getInputMonth() {
        return inputMonth;
    }

    public WebElement getInputYear() {
        return inputYear;
    }

    public WebElement getBtnPurchase() {
        return btnPurchase;
    }

    public WebElement getTitleSuccess() {
        return titleSuccess;
    }

    public WebElement getBtnOK() {
        return btnOK;
    }

    public WebElement getModalPurchase() {
        return modalPurchase;
    }
}
