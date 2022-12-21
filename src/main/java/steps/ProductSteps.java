package steps;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.ProductPage;
import tests.CustomAssertions;

import java.time.Duration;

public class ProductSteps extends BaseStep{
    ProductPage productPage = PageFactory.initElements(webDriver, ProductPage.class);

    public ProductSteps(WebDriver webDriver) {
        super(webDriver);
    }

    // Step to find out if the product name is empty.
    public Boolean getProductName() {
        try {
            WebElement valueProduct = new WebDriverWait(webDriver, Duration.ofSeconds(50)).until(ExpectedConditions.visibilityOf(productPage.getProductName()));
            Boolean isEmptyTest = valueProduct.getText().isEmpty();
            if (!isEmptyTest) System.out.println(valueProduct.getText());
            return isEmptyTest;
        } catch (NoSuchElementException e) {
            System.out.println("Element NAME not found");
            return true;
        }
    }

    //// Step to find out if the product price is empty.
    public Boolean getProductPrice() {
        try {
            WebElement valueProduct = new WebDriverWait(webDriver, Duration.ofSeconds(50)).until(ExpectedConditions.visibilityOf(productPage.getProductPrice()));
            Boolean isEmptyText = valueProduct.getText().isEmpty();
            if (!isEmptyText) System.out.println(valueProduct.getText());
            return isEmptyText;
        } catch (NoSuchElementException e) {
            System.out.println("Element PRICE not found");
            return true;
        }
    }

    // Step to find out if the product description is empty.
    public Boolean getProductDescription() {
        try {
            WebElement valueProduct = new WebDriverWait(webDriver, Duration.ofSeconds(50)).until(ExpectedConditions.visibilityOf(productPage.getProductDescription()));
            Boolean isEmptyText = valueProduct.getText().isEmpty();
            if (!isEmptyText) System.out.println(valueProduct.getText());
            return isEmptyText;
        } catch (NoSuchElementException e) {
            System.out.println("Element DESCRIPTION not found");
            return true;
        }
    }

    // Step to find out if the product image is displayed.
    public Boolean getProductImage() {
        try {
            WebElement valueProduct = new WebDriverWait(webDriver, Duration.ofSeconds(50)).until(ExpectedConditions.visibilityOf(productPage.getProductImage()));
            Boolean isImgDisplayed = valueProduct.isDisplayed();
            if (isImgDisplayed) System.out.println(valueProduct.getAttribute("src"));
            return isImgDisplayed;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    // Step to find out if Cart Button is displayed.
    public Boolean getProductCartButton() {
        try {
            Boolean isBtnDisplayed = productPage.getCartButton().isDisplayed();
            if (isBtnDisplayed) System.out.println("Button displayed");
            return isBtnDisplayed;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    // Step to click cart button of specific product and check if alter poop up is correct.
    public Boolean alertCartButton() {
        try {
            WebElement isButtonEnable = new WebDriverWait(webDriver, Duration.ofSeconds(50)).until(ExpectedConditions.visibilityOf(productPage.getCartButton()));
            isButtonEnable.click();
            WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            String actualDescription = alert.getText();
            CustomAssertions.isAlertDescriptionValid(actualDescription);
            alert.accept();
            System.out.println(productPage.getProductName().getText() + " was added to cart list.");
            return true;
        } catch (Exception e) {
            return false;
        }
    }


}
