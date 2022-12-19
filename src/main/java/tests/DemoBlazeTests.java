package tests;

import org.testng.annotations.Test;
import steps.DemoBlazeSteps;

public class DemoBlazeTests extends BaseTest {
    DemoBlazeSteps demoBlazeSteps = new DemoBlazeSteps(driver);

    @Test(description = "SR-12111: Test displayed category of products in main page", groups = "SR-12111")
    public void testCategories(){
        CustomAssertions.isElementDisplayedCategory(demoBlazeSteps.getCategoryPhone(), "Phone");
        CustomAssertions.isElementDisplayedCategory(demoBlazeSteps.getCategoryLaptop(), "Laptop");
        CustomAssertions.isElementDisplayedCategory(demoBlazeSteps.getCategoryMonitor(), "Monitor");
    }

    @Test(description = "SR-12120: Test to click any of the products in the catalog displayed in the homepage and look details", groups = "SR-12120")
    public void testClickProductDetails(){
        CustomAssertions.isElementDisplayed(demoBlazeSteps.getProductCatalog(), "FIRST PRODUCT");
        CustomAssertions.isDetailEmptyProduct(demoBlazeSteps.getProductName(),"NAME");
        CustomAssertions.isDetailEmptyProduct(demoBlazeSteps.getProductPrice(), "PRICE");
        CustomAssertions.isDetailEmptyProduct(demoBlazeSteps.getProductDescription(), "DESCRIPTION");
        CustomAssertions.isElementDisplayed(demoBlazeSteps.getProductImage(), "PRODUCT IMAGE");
        CustomAssertions.isElementDisplayed(demoBlazeSteps.getProductCartButton(), "CART BUTTON");
    }

    @Test(description = "SR-12121: Test to click add to cart button will display browser alert with below information", groups = "SR-12121")
    public void testAlertCartButton(){
        CustomAssertions.isElementDisplayed(demoBlazeSteps.getProductCatalog(), "FIRST PRODUCT");
        CustomAssertions.isAlertAccepted(demoBlazeSteps.alertCartButton());
    }

    @Test(description = "SR-12130: Test to click the cart link will display below information", groups = "SR-12130")
    public void testListCart(){
        demoBlazeSteps.tableProductCart();
        CustomAssertions.isDetailEmptyProduct(demoBlazeSteps.labelTotalCart(), "TOTAL CART");
        CustomAssertions.isElementDisplayed(demoBlazeSteps.btnPlaceOrder(), "PLACE ORDER");
    }
}
