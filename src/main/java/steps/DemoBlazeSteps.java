package steps;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObjects.DemoBlazePage;
import tests.CustomAssertions;

import java.time.Duration;
import java.util.List;

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

    public Boolean getProductCatalog() {
        try {
            boolean isDisplayed = demoBlazePage.getProductCatalog().isDisplayed();
            demoBlazePage.getProductCatalog().click();
            return isDisplayed;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public Boolean getProductName() {
        try {
            WebElement valueProduct = new WebDriverWait(webDriver, Duration.ofSeconds(50)).until(ExpectedConditions.visibilityOf(demoBlazePage.getProductName()));
            return valueProduct.getText().isEmpty();
        } catch (NoSuchElementException e) {
            System.out.println("Element NAME not found");
            return true;
        }
    }

    public Boolean getProductPrice() {
        try {
            WebElement valueProduct = new WebDriverWait(webDriver, Duration.ofSeconds(50)).until(ExpectedConditions.visibilityOf(demoBlazePage.getProductPrice()));
            return valueProduct.getText().isEmpty();
        } catch (NoSuchElementException e) {
            System.out.println("Element PRICE not found");
            return true;
        }
    }

    public Boolean getProductDescription() {
        try {
            WebElement valueProduct = new WebDriverWait(webDriver, Duration.ofSeconds(50)).until(ExpectedConditions.visibilityOf(demoBlazePage.getProductDescription()));
            return valueProduct.getText().isEmpty();
        } catch (NoSuchElementException e) {
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

    public Boolean alertCartButton() {
        try {
            WebElement isButtonEnable = new WebDriverWait(webDriver, Duration.ofSeconds(50)).until(ExpectedConditions.visibilityOf(demoBlazePage.getCartButton()));
            isButtonEnable.click();
            WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            String actualDescription = alert.getText();
            CustomAssertions.isAlertDescriptionValid(actualDescription);
            alert.accept();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void addAllProductMainPage(){
        int n = demoBlazePage.getListProducts().size();
        for (int i = 0; i < n; i++) {
            List<WebElement> product = new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfAllElements(demoBlazePage.getListProducts()));
            product.get(i).findElement(By.tagName("a")).click();
            alertCartButton();
            webDriver.get("https://www.demoblaze.com/");
        }
    }

    public void tableProductCart() {
        addAllProductMainPage();

        demoBlazePage.getBtnCart().click();

        WebElement table = new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(demoBlazePage.getTableCart()));
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        List<WebElement> columns;
        for (WebElement row : rows) {
            System.out.println();
            columns = row.findElements(By.tagName("td"));

            for (int i = 0; i <= 3; i++) {
                switch (i) {
                    case 0:
                        WebElement img = columns.get(0).findElement(By.tagName("img"));
                        System.out.println(img.getAttribute("src"));
                        Assert.assertTrue(img.isDisplayed(), "Image is not displayed");
                        break;
                    case 1:
                        String title = columns.get(1).getText();
                        System.out.println(title);
                        Assert.assertFalse(title.isEmpty(), "Title is empty");
                        break;
                    case 2:
                        String price = columns.get(2).getText();
                        System.out.println(price);
                        Assert.assertFalse(price.isEmpty(), "Price is empty");
                        break;
                    case 3:
                        WebElement deleteLink = columns.get(3).findElement(By.tagName("a"));
                        String delete = deleteLink.getText();
                        System.out.println(delete);
                        Assert.assertTrue(deleteLink.isDisplayed(), "Link to delete is not displayed");
                        break;
                }
            }
        }
    }

    public Boolean labelTotalCart() {
        WebElement total = new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(demoBlazePage.getTotalCart()));
        String text = total.getText();
        System.out.println(text);
        return text.isEmpty();
    }

    public Boolean btnPlaceOrder() {
        WebElement label = new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(demoBlazePage.getBtnPlaceOrder()));
        String text = label.getText();
        System.out.println(text);
        return demoBlazePage.getBtnPlaceOrder().isDisplayed();
    }
}
