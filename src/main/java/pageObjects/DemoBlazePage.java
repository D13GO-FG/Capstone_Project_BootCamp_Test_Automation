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

    public WebElement getCategoryPhone() {
        return categoryPhone;
    }

    public WebElement getCategoryLaptop() {
        return categoryLaptop;
    }

    public WebElement getCategoryMonitor() {
        return categoryMonitor;
    }
}
