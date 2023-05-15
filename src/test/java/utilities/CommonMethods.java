package utilities;

import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class CommonMethods {
    public static byte[] takeScreenshot(){
        TakesScreenshot takesScreenshot = (TakesScreenshot) DriverUtilities.getDriver();
        byte[] screenshot = takesScreenshot.getScreenshotAs(OutputType.BYTES);
        return screenshot;
    }
    public static void takeScreenshot(Scenario scenario){
        try {
            if (scenario.isFailed()) {
                File screenshot = ((TakesScreenshot) DriverUtilities.getDriver()).getScreenshotAs(OutputType.FILE);
                try {
                    FileUtils.copyFile(screenshot, new File("target/automation/screenshots/" + scenario.getName() + ".png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            System.err.println("The error happened while taking screenshot and cleaning up after the test");
            e.getMessage();
        }
    }
}
