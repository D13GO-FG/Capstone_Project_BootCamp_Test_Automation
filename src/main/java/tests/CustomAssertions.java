package tests;

import org.testng.Assert;

public class CustomAssertions extends Assert {
    public static void isElementDisplayedCategory(Boolean isElementDisplayed, String Category){
        String errorMessage = "The category '" + Category + "' is not displayed";
        Assert.assertTrue(isElementDisplayed, errorMessage);
    }

    public static void isDetailEmptyProduct(Boolean isDetailEmpty, String Detail){
        String errorMessage = "The '" + Detail + "' is empty";
        Assert.assertFalse(isDetailEmpty, errorMessage);
    }

    public static void isElementDisplayed(Boolean isElementDisplayed, String Element){
        String errorMessage = "Element '" + Element + "' is not displayed";
        Assert.assertTrue(isElementDisplayed, errorMessage);
    }
}
