package tests;

import org.testng.annotations.Test;
import steps.MainSteps;
import steps.ProductSteps;

public class SR_12120 extends BaseTest{
    MainSteps mainSteps = new MainSteps(driver);
    ProductSteps productSteps = new ProductSteps(driver);

    @Test(description = "SR-12120: Test to click any of the products in the catalog displayed in the homepage and look details", groups = "SR-12120")
    public void testClickProductDetails(){
        CustomAssertions.isElementDisplayed(mainSteps.getProductCatalog(), "FIRST PRODUCT");
        CustomAssertions.isDetailEmptyProduct(productSteps.getProductName(),"NAME");
        CustomAssertions.isDetailEmptyProduct(productSteps.getProductPrice(), "PRICE");
        CustomAssertions.isDetailEmptyProduct(productSteps.getProductDescription(), "DESCRIPTION");
        CustomAssertions.isElementDisplayed(productSteps.getProductImage(), "PRODUCT IMAGE");
        CustomAssertions.isElementDisplayed(productSteps.getProductCartButton(), "CART BUTTON");
    }
}
