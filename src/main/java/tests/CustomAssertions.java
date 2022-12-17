package tests;

import org.testng.Assert;

public class CustomAssertions extends Assert {
    public static void isElementDisplayedCategory(Boolean isElementDisplayed, String Category){
        String errorMessage = "The category '" + Category + "' is not displayed";
        Assert.assertTrue(isElementDisplayed, errorMessage);
    }
}
