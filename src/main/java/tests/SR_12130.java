package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import steps.CartSteps;
import steps.MainSteps;
import steps.ProductSteps;

import java.util.List;

public class SR_12130 extends BaseTest{
    MainSteps mainSteps = new MainSteps(driver);
    ProductSteps productSteps = new ProductSteps(driver);
    CartSteps cartSteps = new CartSteps(driver);

    @Test(description = "SR-12130: Test to click the cart link will display below information", groups = "SR-12130")
    public void testListCart(){
        for (int i = 0; i < mainSteps.listToAddMultipleProducts().size(); i++) {
            List<WebElement> product = mainSteps.listToAddMultipleProducts();
            product.get(i).findElement(By.tagName("a")).click();
            CustomAssertions.isAlertAccepted(productSteps.alertCartButton());
            driver.get("https://www.demoblaze.com/");
        }
        CustomAssertions.isClicked(mainSteps.clickCartLink(), "BUTTON CART");
        CustomAssertions.isTotalPriceCorrect(cartSteps.labelTotalCart(), cartSteps.tableProductCart());
        CustomAssertions.isElementDisplayed(cartSteps.btnPlaceOrder(), "PLACE ORDER");
        // Positive SR-12131
        CustomAssertions.isSuccessPurchase(cartSteps.finishPlaceOrder());
    }


}
