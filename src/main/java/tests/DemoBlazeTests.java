package tests;

import org.testng.annotations.Test;
import steps.DemoBlazeSteps;

public class DemoBlazeTests extends BaseTest {
    DemoBlazeSteps demoBlazeSteps = new DemoBlazeSteps(driver);

    @Test(description = "Test displayed category of products in main page", groups = "SmokeSuite")
    public void TestTitle(){
        String actualTitle = demoBlazeSteps.getTitle();
        System.out.println(actualTitle);
        CustomAssertions.isElementDisplayedCategory(demoBlazeSteps.getCategoryPhone(), "Phone");
        CustomAssertions.isElementDisplayedCategory(demoBlazeSteps.getCategoryLaptop(), "Laptop");
        CustomAssertions.isElementDisplayedCategory(demoBlazeSteps.getCategoryMonitor(), "Monitor");
    }
}
