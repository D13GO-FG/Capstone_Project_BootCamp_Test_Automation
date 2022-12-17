package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    public WebDriver driver = getDriver();
    private WebDriver getDriver(){
        setupDriver("edge");
        driver.get("https://www.demoblaze.com/");
        driver.manage().window().maximize();
        return driver;
    }

    private void setupDriver(String browserName) {
        switch(browserName) {
            case "edge":
                System.setProperty("webdriver.edge.driver", "D:/2022/Selemiun Driver and jars/edgedriver/msedgedriver.exe");
                driver = new EdgeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "D:/2022/Selemiun Driver and jars/FireFoxDriver/geckodriver-v0.32.0-win64/geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            default:
                System.out.println("Web Driver was not found in directory");
        }
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() {
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        driver.quit();
    }
}
