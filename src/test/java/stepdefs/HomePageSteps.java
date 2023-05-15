package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.HomePage;

public class HomePageSteps {
    HomePage homePage = new HomePage();
    @Given("Verify user is on a home page")
    public void verifyUserIsOnAHomePage() {
        homePage.verifyLogoIsDisplayed();
    }

    @Then("User clicks on account")
    public void userClicksOnAccount() {
        homePage.userClicksOnAccount();
    }

    @And("User clicks on create account")
    public void userClicksOnCreateAccount() {
        homePage.userClicksOnCreateAccount();
    }
}
