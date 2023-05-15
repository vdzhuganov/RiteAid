package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.ConfigReader;

public class EmailVerificationPage extends BasePage {
    static String invalidRegistrationEmail;

    @FindBy(xpath = "//p[text()='Let’s get started!']")
    WebElement letsGetStarted;

    @FindBy(id = "signup-email")
    WebElement signupEmail;

    @FindBy(id = "email-signup-continue-btn")
    WebElement continueBtn;

    @FindBy(xpath = "//p[text()='Please enter a valid email address.']")
    WebElement invalidEmailErrorMessage;
    @FindBy(xpath = "//p[contains(text(), 'Looks like you already have an account!')]")
    WebElement accountExistsMessage;

    public void letsGetStartedIsDisplayed() {


        Assert.assertTrue("Email verification page is not displayed", letsGetStarted.isDisplayed());
    }

    public void enterRegistrationEmail(String email) {

        signupEmail.sendKeys(ConfigReader.getConfigProperty(email));
    }

    public void clickContinueBtn() {
        continueBtn.click();
    }

    public void enterInvalidEmail() {
        invalidRegistrationEmail = faker.internet().emailAddress();
        signupEmail.sendKeys(invalidRegistrationEmail);
        System.out.println(invalidRegistrationEmail);

    }

    public void verifyInvalidEmailMessage() {
        Assert.assertTrue("Invalid email message is not displayed", invalidEmailErrorMessage.isDisplayed());
    }

    public void accountAlreadyExistsErrorMessage() {
        Assert.assertTrue("Account exists message is not displayed", accountExistsMessage.isDisplayed());
    }
}
