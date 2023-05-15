package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage{

    @FindBy(xpath = "//span[@test-automation-id='hmPg-hiUser-lnk-00008']")
    WebElement createAccountBtn;
    @FindBy(xpath = "//h1[contains (text(), 'Dashboard')]")
    WebElement dashBoardText;

    public void verifyPage() {
        Assert.assertTrue("Dashboard page is not displayed", dashBoardText.isDisplayed());

    }
}
