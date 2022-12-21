package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import steps.MainSteps;
import steps.ProductSteps;

public class SR_12120 extends BaseTest{
    private MainSteps mainSteps;
    private ProductSteps productSteps;

    @BeforeClass
    private void beforeClass() {
        mainSteps = new MainSteps(driver);
        productSteps = new ProductSteps(driver);
    }

    @Test(description = "SR-12120: Test to click on a displayed product and verify that the product elements are displayed", groups = "SR-12120")
    public void testProductDetails(){
        CustomAssertions.isElementDisplayed(mainSteps.getProductCatalog(), "FIRST PRODUCT");
        CustomAssertions.isDetailEmptyProduct(productSteps.getProductName(),"NAME");
        CustomAssertions.isDetailEmptyProduct(productSteps.getProductPrice(), "PRICE");
        CustomAssertions.isDetailEmptyProduct(productSteps.getProductDescription(), "DESCRIPTION");
        CustomAssertions.isElementDisplayed(productSteps.getProductImage(), "PRODUCT IMAGE");
        CustomAssertions.isElementDisplayed(productSteps.getProductCartButton(), "CART BUTTON");
    }
}
