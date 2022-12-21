package steps;

import net.datafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObjects.CartPage;
import tests.CustomAssertions;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CartSteps extends BaseStep{
    CartPage cartPage = PageFactory.initElements(webDriver, CartPage.class);
    Faker faker = new Faker(); // Get Fake data to "Place Order" Form
    public CartSteps(WebDriver webDriver) {
        super(webDriver);
    }

    // Step to verify that table of cart list is displayed all the elements and get expected "Total price" for next assertion
    public Double tableProductCart() {
        List<WebElement> rows = new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfAllElements(cartPage.getTableCart()));
        List<WebElement> columns;
        double priceTotal = 0;

        for (WebElement row : rows) {
            System.out.println();
            columns = row.findElements(By.tagName("td"));

            for (int i = 0; i <= 3; i++) {
                switch (i) {
                    case 0:
                        WebElement img = columns.get(0).findElement(By.tagName("img"));
                        System.out.println("Link to image: " + img.getAttribute("src"));
                        CustomAssertions.isElementDisplayed(img.isDisplayed(), "IMAGE");
                        break;
                    case 1:
                        String title = columns.get(1).getText();
                        System.out.println("Product: " + title);
                        CustomAssertions.isDetailEmptyProduct(title.isEmpty(), "TITLE");
                        break;
                    case 2:
                        String price = columns.get(2).getText();
                        System.out.println("Price: $" + price);
                        priceTotal = priceTotal + Double.parseDouble(price);
                        CustomAssertions.isDetailEmptyProduct(price.isEmpty(), "PRICE");
                        break;
                    case 3:
                        WebElement deleteLink = columns.get(3).findElement(By.tagName("a"));
                        String delete = deleteLink.getText();
                        System.out.println("Button link: " + delete);
                        Assert.assertTrue(deleteLink.isDisplayed(), "Link to delete is not displayed");
                        CustomAssertions.isElementDisplayed(deleteLink.isDisplayed(), "DELETE LINK");
                        break;
                }
            }
        }
        return priceTotal;
    }

    // Step to get actual "Total price"
    public Double labelTotalCart() {
        WebElement total = new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(cartPage.getTotalCart()));
        String text = total.getText();
        double actualTotalPrice = Double.parseDouble(text);
        System.out.println("\nTotal: $" + actualTotalPrice);
        return actualTotalPrice;
    }

    // Step to know if "Place Order" is displayed.
    public Boolean btnPlaceOrder() {
        WebElement label = new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(cartPage.getBtnPlaceOrder()));
        String text = label.getText();
        System.out.println("\nButton " + text + " is displayed.");
        return cartPage.getBtnPlaceOrder().isDisplayed();
    }

    //Step to fill out form in "Place Order" and get successful purchase.
    public String finishPlaceOrder(){
        try {
            cartPage.getBtnPlaceOrder().click();
            WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOf(cartPage.getModalPurchase()));
            cartPage.getInputName().sendKeys(faker.name().fullName());
            cartPage.getInputCountry().sendKeys(faker.address().country());
            cartPage.getInputCity().sendKeys(faker.address().city());
            cartPage.getInputCard().sendKeys(faker.number().digits(16));
            cartPage.getInputMonth().sendKeys(faker.date().past(1, TimeUnit.HOURS, "MM"));
            cartPage.getInputYear().sendKeys(faker.date().past(1, TimeUnit.HOURS, "YYYY"));
            cartPage.getBtnPurchase().click();
            WebElement successTitle = new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(cartPage.getTitleSuccess()));
            String title = successTitle.getText();
            cartPage.getBtnOK().click();
            System.out.println("\nFinal Description: " + title);
            return title;
        }catch (Exception e){
            return "\nFinal Description: Purchase fail!";
        }

    }
}
