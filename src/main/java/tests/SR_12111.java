package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import steps.MainSteps;

public class SR_12111 extends BaseTest{
    private MainSteps mainSteps;

    @BeforeClass
    private void beforeClass() {
        mainSteps = new MainSteps(driver);
    }

    @Test(description = "SR-12111: Test to verify that the three categories appear on the left on the home page", groups = "SR-12111")
    public void testCategories(){
        CustomAssertions.isElementDisplayedCategory(mainSteps.getCategoryPhone(), "Phone");
        CustomAssertions.isElementDisplayedCategory(mainSteps.getCategoryLaptop(), "Laptop");
        CustomAssertions.isElementDisplayedCategory(mainSteps.getCategoryMonitor(), "Monitor");
    }
}
