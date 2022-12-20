package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class MainPage extends BasePage{
    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }
    @FindBy(how = How.XPATH, using = "(//a[normalize-space()='Phones'])[1]")
    private WebElement categoryPhone;

    @FindBy(how = How.XPATH, using = "(//a[normalize-space()='Laptops'])[1]")
    private WebElement categoryLaptop;

    @FindBy(how = How.XPATH, using = "(//a[normalize-space()='Monitors'])[1]")
    private WebElement categoryMonitor;

    @FindBy(how = How.XPATH, using = "//*[@id='tbodyid']/div[1]/div/div/h4/a")
    private WebElement productCatalog;

    @FindBy(how = How.XPATH, using = "//div[@class='col-lg-4 col-md-6 mb-4']")
    private List<WebElement> listProducts;

    @FindBy(how = How.XPATH, using = "//a[normalize-space()='Cart']")
    private WebElement btnCart;

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

    public List<WebElement> getListProducts() {
        return listProducts;
    }

    public WebElement getBtnCart() {
        return btnCart;
    }
}
