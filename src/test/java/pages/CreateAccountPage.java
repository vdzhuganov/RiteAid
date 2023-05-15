package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Map;

public class CreateAccountPage extends BasePage {

    @FindBy(xpath = "//p[text()='Let’s create your account']")
    WebElement letsCreateYourAccount;
    @FindBy(id = "create-account-fname")
    WebElement firstNameField;
    @FindBy(id = "create-account-lname")
    WebElement lastNameField;
    @FindBy(id = "create-account-password")
    WebElement createAPasswordField;
    @FindBy(xpath = "//button[@id='create-account']")
    WebElement createAccountBtn;
    @FindBy(xpath = "//label[@class='formErrorMsg userAccountInputError']")
    WebElement errorMessage;


    public void verifyPage() {
        Assert.assertTrue("Create account Page is not displayed", letsCreateYourAccount.isDisplayed());
    }

    public void createUser(Map<String, String> preparedUser) {

        firstNameField.sendKeys(preparedUser.get("firstName"));
        lastNameField.sendKeys(preparedUser.get("lastName"));
        createAPasswordField.sendKeys(preparedUser.get("password"));
        driverWait.until(ExpectedConditions.elementToBeClickable(createAccountBtn));
        createAccountBtn.click();
    }

    public void createUserWithWrongFormatPassword(String firstName, String lastName, String password) {
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        createAPasswordField.sendKeys(password);
        createAccountBtn.click();

    }

    public void verifyWrongPasswordFormatErrorMessage() {
        Assert.assertTrue("Wrong password error message is not displayed", errorMessage.isDisplayed());

    }
}
