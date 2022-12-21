package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import steps.CartSteps;
import steps.MainSteps;
import steps.ProductSteps;

import java.util.List;

public class SR_12130 extends BaseTest {
    private MainSteps mainSteps;
    private ProductSteps productSteps;
    private CartSteps cartSteps;

    @BeforeClass
    private void beforeClass() {
        mainSteps = new MainSteps(driver);
        productSteps = new ProductSteps(driver);
        cartSteps = new CartSteps(driver);
    }

    @Test(description = "SR-12130: Test to click the cart link will display below information about all products added", groups = "SR_12130", priority = 1)
    public void testListCart() {
        for (int i = 0; i < mainSteps.listToAddMultipleProducts().size(); i++) {
            List<WebElement> product = mainSteps.listToAddMultipleProducts();
            product.get(i).findElement(By.tagName("a")).click();
            CustomAssertions.isAlertAccepted(productSteps.alertCartButton());
            driver.get("https://www.demoblaze.com/");
        }
        CustomAssertions.isClicked(mainSteps.clickCartLink(), "BUTTON CART");
        CustomAssertions.isTotalPriceCorrect(cartSteps.labelTotalCart(), cartSteps.tableProductCart());
        CustomAssertions.isElementDisplayed(cartSteps.btnPlaceOrder(), "PLACE ORDER");
    }

    @Test(description = "SR_12131: Test to finish purchase successfully", groups = "SR_12131", priority = 2)
    public void testFinishPurchase() {
        CustomAssertions.isSuccessPurchase(cartSteps.finishPlaceOrder());
    }
}
