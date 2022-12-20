package tests;

import org.testng.annotations.Test;
import steps.MainSteps;
import steps.ProductSteps;

public class SR_12121 extends BaseTest{
    MainSteps mainSteps = new MainSteps(driver);
    ProductSteps productSteps = new ProductSteps(driver);

    @Test(description = "SR-12121: Test to click add to cart button will display browser alert with below information", groups = "SR-12121")
    public void testAlertCartButton(){
        CustomAssertions.isElementDisplayed(mainSteps.getProductCatalog(), "FIRST PRODUCT");
        CustomAssertions.isAlertAccepted(productSteps.alertCartButton());
    }
}
