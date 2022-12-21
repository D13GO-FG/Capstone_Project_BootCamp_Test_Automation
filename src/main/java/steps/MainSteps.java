package steps;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.MainPage;

import java.time.Duration;
import java.util.List;

public class MainSteps extends BaseStep {
    MainPage mainPage = PageFactory.initElements(webDriver, MainPage.class);

    public MainSteps(WebDriver webDriver) {
        super(webDriver);
    }

    // Step to know if category "Phone" is displayed and click it.
    public Boolean getCategoryPhone() {
        try {
            Boolean value = mainPage.getCategoryPhone().isDisplayed();
            if (value) System.out.println("Category phone is displayed");
            mainPage.getCategoryPhone().click();
            return value;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    // Step to know if category "Laptop" is displayed and click it.
    public Boolean getCategoryLaptop() {
        try {
            Boolean value = mainPage.getCategoryLaptop().isDisplayed();
            if (value) System.out.println("Category laptop is displayed");
            mainPage.getCategoryLaptop().click();
            return value;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    // Step to know if category "Monitor" is displayed and click it.
    public Boolean getCategoryMonitor() {
        try {
            Boolean value = mainPage.getCategoryMonitor().isDisplayed();
            if (value) System.out.println("Category monitor is displayed");
            mainPage.getCategoryMonitor().click();
            return value;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    // Step to click the first product in Main Page
    public Boolean getProductCatalog() {
        try {
            boolean isDisplayed = mainPage.getProductCatalog().isDisplayed();
            mainPage.getProductCatalog().click();
            return isDisplayed;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    // Step to get list of multi-products in Main Page.
    public List<WebElement> listToAddMultipleProducts() {
        List<WebElement> products = new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfAllElements(mainPage.getListProducts()));
        return products;
    }

    // Step to click Cart Link
    public Boolean clickCartLink() {
        try {
            mainPage.getBtnCart().click();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
