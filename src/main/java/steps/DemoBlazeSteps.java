package steps;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.DemoBlazePage;
import tests.CustomAssertions;

import java.time.Duration;

public class DemoBlazeSteps extends BaseStep {
    DemoBlazePage demoBlazePage = PageFactory.initElements(webDriver, DemoBlazePage.class);

    public DemoBlazeSteps(WebDriver webDriver) {
        super(webDriver);
    }

    public String getTitle() {
        return webDriver.getTitle();
    }

    public Boolean getCategoryPhone() {
        try {
            return demoBlazePage.getCategoryPhone().isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public Boolean getCategoryLaptop() {
        try {
            return demoBlazePage.getCategoryLaptop().isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public Boolean getCategoryMonitor() {
        try {
            return demoBlazePage.getCategoryMonitor().isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void getProductCatalog(){
        demoBlazePage.getProductCatalog().click();
    }

    public Boolean getProductName(){
        try {
            WebElement valueProduct = new WebDriverWait(webDriver, Duration.ofSeconds(50)).until(ExpectedConditions.visibilityOf(demoBlazePage.getProductName()));
            Boolean value = valueProduct.getText().isEmpty();
            return value;
        }catch (NoSuchElementException e){
            System.out.println("Element NAME not found");
            return true;
        }
    }

    public Boolean getProductPrice(){
        try {
            WebElement valueProduct = new WebDriverWait(webDriver, Duration.ofSeconds(50)).until(ExpectedConditions.visibilityOf(demoBlazePage.getProductPrice()));
            Boolean value = valueProduct.getText().isEmpty();
            return value;
        }catch (NoSuchElementException e){
            System.out.println("Element PRICE not found");
            return true;
        }
    }

    public Boolean getProductDescription(){
        try {
            WebElement valueProduct = new WebDriverWait(webDriver, Duration.ofSeconds(50)).until(ExpectedConditions.visibilityOf(demoBlazePage.getProductDescription()));
            Boolean value = valueProduct.getText().isEmpty();
            return value;
        }catch (NoSuchElementException e){
            System.out.println("Element DESCRIPTION not found");
            return true;
        }
    }

    public Boolean getProductImage() {
        try {
            return demoBlazePage.getProductImage().isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public Boolean getProductCartButton() {
        try {
            return demoBlazePage.getCartButton().isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public Boolean alertCartButton(){
        try {
            WebElement isButtonEnable = new WebDriverWait(webDriver, Duration.ofSeconds(50)).until(ExpectedConditions.visibilityOf(demoBlazePage.getCartButton()));
            isButtonEnable.click();
            WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            String actualDescription = alert.getText();
            CustomAssertions.isAlertDescriptionValid(actualDescription);
            alert.accept();
            return true;
        }catch (Exception e){
            return false;
        }
    }

}
