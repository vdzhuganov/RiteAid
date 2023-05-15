package stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.RestAssured;
import utilities.CommonMethods;
import utilities.ConfigReader;
import utilities.DriverUtilities;

public class Hooks {




    @Before("@UI")
    public void setUpUI(Scenario scenario) {
        ConfigReader.initializeProperties();
        DriverUtilities.createDriver(scenario);
    }

    @Before("@API")
    public void setUpAPI(){
        ConfigReader.initializeProperties();
        RestAssured.baseURI = ConfigReader.getConfigProperty("api.host") + ConfigReader.getConfigProperty("api.ver");
    }

    @After("@UI")
    public void tearUp(Scenario scenario) {
        if(scenario.isFailed()) {
            scenario.attach(CommonMethods.takeScreenshot(), "image/png", scenario.getName());
        }
        CommonMethods.takeScreenshot(scenario);

        DriverUtilities.quitDriver(scenario);


    }


}
