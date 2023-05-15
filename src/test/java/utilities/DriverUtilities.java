package utilities;

import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.time.Duration;

public class DriverUtilities {
    static WebDriver driver;

    public static void createDriver(Scenario scenario) {

        if (ConfigReader.getConfigProperty("app.host").equalsIgnoreCase("localhost")) {
            switch (ConfigReader.getConfigProperty("app.browser")) {
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                default:
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--remote-allow-origins=*");
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(options);
            }
        } else if (ConfigReader.getConfigProperty("app.host").equalsIgnoreCase("saucelabs")) {
            MutableCapabilities sauceOptions = new MutableCapabilities();
            sauceOptions.setCapability("username", ConfigReader.getConfigProperty("sauce.username"));
            sauceOptions.setCapability("accesskey", ConfigReader.getConfigProperty("sauce.accesskey"));

            MutableCapabilities capabilities = new MutableCapabilities();
            capabilities.setCapability("browserName", ConfigReader.getConfigProperty("sauce.browserName"));
            capabilities.setCapability("browserVersion", ConfigReader.getConfigProperty("sauce.browserVersion"));
            capabilities.setCapability("platformName", ConfigReader.getConfigProperty("sauce.platformName"));
            capabilities.setCapability("sauce:options", sauceOptions);
            try {
                driver = new RemoteWebDriver(new URL(ConfigReader.getConfigProperty("sauce.urlWest")), capabilities);
                ((JavascriptExecutor) driver).executeScript("sauce:job-name=" + scenario.getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get(ConfigReader.getConfigProperty("app.baseurl"));
        driver.manage().deleteAllCookies();

    }
    public static void quitDriver(Scenario scenario) {
        if (ConfigReader.getConfigProperty("app.host").equalsIgnoreCase("saucelabs")) {
            ((JavascriptExecutor) driver).executeScript("sauce:job-result=" + (scenario.isFailed() ? "failed" : "passed"));
        }
        driver.quit();
    }
    public static WebDriver getDriver() {
        return driver;
    }
}
