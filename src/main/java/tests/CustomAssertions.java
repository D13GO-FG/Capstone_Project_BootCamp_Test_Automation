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

    public static void isAlertDescriptionValid(String actualDescription){
        String expectedDescription = "Product added";
        String errorMessage = "Alert description is not as expected. Expected: '"+ expectedDescription + "', got: '" + actualDescription;
        Assert.assertEquals(actualDescription, expectedDescription, errorMessage);
    }

    public static void isAlertAccepted(Boolean isAlertAccepted){
        String errorMessage = "Alert not present";
        Assert.assertTrue(isAlertAccepted, errorMessage);
    }

    public static void isTotalPriceCorrect(Double actualTotalPrice, Double expectedTotalPrice){
        String errorMessage = "Total price is not correct. Expected: " + expectedTotalPrice + ", got: " + actualTotalPrice;
        Assert.assertEquals(actualTotalPrice, expectedTotalPrice, "Total price is not correct");
    }
}
