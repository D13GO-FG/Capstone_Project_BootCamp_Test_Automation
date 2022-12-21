package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class BaseTest {
    public WebDriver driver = getDriver();
    private WebDriver getDriver(){
        setupDriver("edge"); // The change will depend on the browser you are using.
        driver.get("https://www.demoblaze.com/");
        driver.manage().window().maximize();
        return driver;
    }

    // Select for different type of driver.
    private void setupDriver(String browserName) {
        switch(browserName) {
            case "edge":
                System.setProperty("webdriver.edge.driver", "src/main/resources/browserDrivers/msedgedriver.exe");
                driver = new EdgeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "src/main/resources/browserDrivers/geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            case "chrome":
                System.setProperty("webdriver.edge.driver", "src/main/resources/browserDrivers/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            default:
                System.out.println("Web Driver was not found in directory");
        }
    }

    @AfterClass
    public void afterTest() {
        System.out.println("Closing test ...");
        driver.quit();
    }
}
