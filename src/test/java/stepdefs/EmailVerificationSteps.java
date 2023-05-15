package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.EmailVerificationPage;

public class EmailVerificationSteps {
    EmailVerificationPage emailVerificationPage = new EmailVerificationPage();

    @Then("verify user is on email verification page")
    public void verifyUserIsOnEmailVerificationPage() {
        emailVerificationPage.letsGetStartedIsDisplayed();

    }

    @And("User enters a {string} address and clicks a continue button")
    public void userEntersAddressAndClicksAContinueButton(String email) {
        emailVerificationPage.enterRegistrationEmail(email);
        emailVerificationPage.clickContinueBtn();
    }

    @When("User enters invalid email and clicks continue")
    public void userEntersInvalidEmailAndClicksContinue() {
        emailVerificationPage.enterInvalidEmail();
        emailVerificationPage.clickContinueBtn();
    }


    @Then("Verify invalid email error message is displayed")
    public void verifyInvalidEmailErrorMessageIsDisplayed() {
        emailVerificationPage.verifyInvalidEmailMessage();
    }

    @Then("Verify account already exists error message is displayed")
    public void verifyAccountAlreadyExistsErrorMessageIsDisplayed() {
        emailVerificationPage.accountAlreadyExistsErrorMessage();
    }
}
