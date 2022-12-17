package steps;

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
        return demoBlazePage.getCategoryPhone().isDisplayed();
    }

    public Boolean getCategoryLaptop() {
        return demoBlazePage.getCategoryLaptop().isDisplayed();
    }

    public Boolean getCategoryMonitor() {
        return demoBlazePage.getCategoryMonitor().isDisplayed();
    }
}
