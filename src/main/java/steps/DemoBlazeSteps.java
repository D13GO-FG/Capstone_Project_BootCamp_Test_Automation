package steps;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.DemoBlazePage;

public class DemoBlazeSteps extends BaseStep {
    DemoBlazePage demoBlazePage = PageFactory.initElements(webDriver, DemoBlazePage.class);

    public DemoBlazeSteps(WebDriver webDriver) {
        super(webDriver);
    }

    public String getTitle() {
        return webDriver.getTitle();
    }

    public Boolean getCategoryPhone() {
        try {
            return demoBlazePage.getCategoryPhone().isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public Boolean getCategoryLaptop() {
        try {
            return demoBlazePage.getCategoryLaptop().isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public Boolean getCategoryMonitor() {
        try {
            return demoBlazePage.getCategoryMonitor().isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
