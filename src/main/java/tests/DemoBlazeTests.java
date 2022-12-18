package tests;

import org.testng.annotations.Test;
import steps.DemoBlazeSteps;

public class DemoBlazeTests extends BaseTest {
    DemoBlazeSteps demoBlazeSteps = new DemoBlazeSteps(driver);

    @Test(description = "SR-12111: Test displayed category of products in main page", groups = "SmokeSuite")
    public void testCategories(){
        String actualTitle = demoBlazeSteps.getTitle();
        System.out.println(actualTitle);
        CustomAssertions.isElementDisplayedCategory(demoBlazeSteps.getCategoryPhone(), "Phone");
        CustomAssertions.isElementDisplayedCategory(demoBlazeSteps.getCategoryLaptop(), "Laptop");
        CustomAssertions.isElementDisplayedCategory(demoBlazeSteps.getCategoryMonitor(), "Monitor");
    }

    @Test(description = "SR-12120: Test to click any of the products in the catalog displayed in the homepage and look details", groups = "SmokeSuite")
    public void testClickProductDetails(){
        demoBlazeSteps.getProductCatalog(1);
        CustomAssertions.isDetailEmptyProduct(demoBlazeSteps.getProductName(),"NAME");
        CustomAssertions.isDetailEmptyProduct(demoBlazeSteps.getProductPrice(), "PRICE");
        CustomAssertions.isDetailEmptyProduct(demoBlazeSteps.getProductDescription(), "DESCRIPTION");
        CustomAssertions.isElementDisplayed(demoBlazeSteps.getProductImage(), "PRODUCT IMAGE");
        CustomAssertions.isElementDisplayed(demoBlazeSteps.getProductCartButton(), "CART BUTTON");
    }

    @Test(description = "SR-12121: Test to click add to cart button will display browser alert with below information", groups = "SmokeSuite")
    public void testAlertCartButton(){
        demoBlazeSteps.getProductCatalog(1);
        CustomAssertions.isAlertAccepted(demoBlazeSteps.alertCartButton());
    }

    @Test(description = "SR-12130: Test to click the cart link will display below information", groups = "SmokeSuite")
    public void testListCart(){
        demoBlazeSteps.tableProductCart();
    }
}
