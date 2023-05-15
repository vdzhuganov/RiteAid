package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CreateAccountPage;

import java.util.List;
import java.util.Map;

public class CreateAccountSteps {
    CreateAccountPage createAccountPage = new CreateAccountPage();

    @Then("Verify user is on a create account page")
    public void verifyUserIsOnACreateAccountPage() {
        createAccountPage.verifyPage();

    }

    @And("User sends request to create user with following fields:")
    public void userSendsRequestToCreateUserWithFollowingFields(List<Map<String, String>> registerValues) {

        Map<String, String> preparedUser = registerValues.get(0);
        createAccountPage.createUser(preparedUser);
    }

    @When("User enters{string} and {string} and wrong format {string}")
    public void userEntersAndAndWrongFormat(String firstName, String lastName, String password) {
        createAccountPage.createUserWithWrongFormatPassword(firstName, lastName, password);

    }

    @Then("Verify wrong format password error message is displayed")
    public void verifyWrongFormatPasswordErrorMessageIsDisplayed() {
        createAccountPage.verifyWrongPasswordFormatErrorMessage();
    }
}
