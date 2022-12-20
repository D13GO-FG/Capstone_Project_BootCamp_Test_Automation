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

    public Boolean getCategoryPhone() {
        try {
            Boolean value = demoBlazePage.getCategoryPhone().isDisplayed();
            if (value) System.out.println("Category phone is displayed");
            demoBlazePage.getCategoryPhone().click();
            return value;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public Boolean getCategoryLaptop() {
        try {
            Boolean value = demoBlazePage.getCategoryLaptop().isDisplayed();
            if (value) System.out.println("Category laptop is displayed");
            demoBlazePage.getCategoryLaptop().click();
            return value;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public Boolean getCategoryMonitor() {
        try {
            Boolean value = demoBlazePage.getCategoryMonitor().isDisplayed();
            if (value) System.out.println("Category monitor is displayed");
            demoBlazePage.getCategoryMonitor().click();
            return value;
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
            Boolean isEmptyTest = valueProduct.getText().isEmpty();
            if (!isEmptyTest) System.out.println(valueProduct.getText());
            return isEmptyTest;
        } catch (NoSuchElementException e) {
            System.out.println("Element NAME not found");
            return true;
        }
    }

    public Boolean getProductPrice() {
        try {
            WebElement valueProduct = new WebDriverWait(webDriver, Duration.ofSeconds(50)).until(ExpectedConditions.visibilityOf(demoBlazePage.getProductPrice()));
            Boolean isEmptyText = valueProduct.getText().isEmpty();
            if (!isEmptyText) System.out.println(valueProduct.getText());
            return isEmptyText;
        } catch (NoSuchElementException e) {
            System.out.println("Element PRICE not found");
            return true;
        }
    }

    public Boolean getProductDescription() {
        try {
            WebElement valueProduct = new WebDriverWait(webDriver, Duration.ofSeconds(50)).until(ExpectedConditions.visibilityOf(demoBlazePage.getProductDescription()));
            Boolean isEmptyText = valueProduct.getText().isEmpty();
            if (!isEmptyText) System.out.println(valueProduct.getText());
            return isEmptyText;
        } catch (NoSuchElementException e) {
            System.out.println("Element DESCRIPTION not found");
            return true;
        }
    }

    public Boolean getProductImage() {
        try {
            WebElement valueProduct = new WebDriverWait(webDriver, Duration.ofSeconds(50)).until(ExpectedConditions.visibilityOf(demoBlazePage.getProductImage()));
            Boolean isImgDisplayed = valueProduct.isDisplayed();
            if (isImgDisplayed) System.out.println(valueProduct.getAttribute("src"));
            return isImgDisplayed;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public Boolean getProductCartButton() {
        try {
            Boolean isBtnDisplayed = demoBlazePage.getCartButton().isDisplayed();
            if (isBtnDisplayed) System.out.println("Button displayed");
            return isBtnDisplayed;
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
            System.out.println(demoBlazePage.getProductName().getText() + " was added to cart list.");
            //System.out.println("Description: " + actualDescription);
            //System.out.println("Alert clicked");
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

    public Double tableProductCart() {
        addAllProductMainPage();

        demoBlazePage.getBtnCart().click();

        List<WebElement> rows = new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfAllElements(demoBlazePage.getTableCart()));
        List<WebElement> columns;
        double priceTotal = 0;

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
                        priceTotal = priceTotal + Double.parseDouble(price);
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
        return priceTotal;
    }

    public Boolean labelTotalCart(Double expectedTotalPrice) {
        WebElement total = new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(demoBlazePage.getTotalCart()));
        String text = total.getText();
        double actualTotalPrice = Double.parseDouble(text);
        CustomAssertions.isTotalPriceCorrect(actualTotalPrice,expectedTotalPrice);
        System.out.println("Total: $" + actualTotalPrice + " is correct.");
        return text.isEmpty();
    }

    public Boolean btnPlaceOrder() {
        WebElement label = new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(demoBlazePage.getBtnPlaceOrder()));
        String text = label.getText();
        System.out.println("Button label: " + text);
        return demoBlazePage.getBtnPlaceOrder().isDisplayed();
    }
}
