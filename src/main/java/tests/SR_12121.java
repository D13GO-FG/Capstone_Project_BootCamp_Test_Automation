package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import steps.MainSteps;
import steps.ProductSteps;

public class SR_12121 extends BaseTest{
    private MainSteps mainSteps;
    private ProductSteps productSteps;

    @BeforeClass
    private void beforeClass() {
        mainSteps = new MainSteps(driver);
        productSteps = new ProductSteps(driver);
    }

    @Test(description = "SR-12121: Test to click on the first product displayed and click on “Add to cart” to view alert", groups = "SR-12121")
    public void testAlertCartButton(){
        CustomAssertions.isElementDisplayed(mainSteps.getProductCatalog(), "FIRST PRODUCT");
        CustomAssertions.isAlertAccepted(productSteps.alertCartButton());
    }
}
