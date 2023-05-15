package stepdefs;

import io.cucumber.java.en.Then;
import pages.DashboardPage;

public class DashboardSteps {
    DashboardPage dashboardPage = new DashboardPage();
    @Then("verify user is on a dashboard page")
    public void verifyUserIsOnADashboardPage() {
        dashboardPage.verifyPage();
    }
}
