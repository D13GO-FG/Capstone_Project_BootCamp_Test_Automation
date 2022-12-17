package steps;

import org.openqa.selenium.WebDriver;

public class BaseStep {
    WebDriver webDriver;

    public BaseStep(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
}
