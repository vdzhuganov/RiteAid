package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(css = ".cx-header-menu__logo")
    WebElement logo;

    @FindBy(xpath = "//em[@class='ra-icon ra-icon-cx-account']")
    WebElement account;

    @FindBy(xpath = "//span[text()='Create Account']")
    WebElement createAccount;


    public void verifyLogoIsDisplayed() {

        Assert.assertTrue("Logo is not displayed",logo.isDisplayed());
    }

    public void userClicksOnAccount() {
        account.click();
    }

    public void userClicksOnCreateAccount() {
        createAccount.click();
    }
}
