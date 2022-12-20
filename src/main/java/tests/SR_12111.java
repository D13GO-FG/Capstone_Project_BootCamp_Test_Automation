package tests;

import org.testng.annotations.Test;
import steps.MainSteps;

public class SR_12111 extends BaseTest{
    MainSteps mainSteps = new MainSteps(driver);

    @Test(description = "SR-12111: Test displayed category of products in main page", groups = "SR-12111")
    public void testCategories(){
        CustomAssertions.isElementDisplayedCategory(mainSteps.getCategoryPhone(), "Phone");
        CustomAssertions.isElementDisplayedCategory(mainSteps.getCategoryLaptop(), "Laptop");
        CustomAssertions.isElementDisplayedCategory(mainSteps.getCategoryMonitor(), "Monitor");
    }
}
