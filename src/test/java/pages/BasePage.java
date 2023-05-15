package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.DriverUtilities;

import java.time.Duration;

public class BasePage {
    Faker faker = new Faker();
    WebDriver driver = DriverUtilities.getDriver();
    WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
    public BasePage(){

        PageFactory.initElements(driver, this);
    }

}
