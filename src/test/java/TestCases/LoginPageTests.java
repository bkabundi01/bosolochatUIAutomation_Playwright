package TestCases;

import Base.BaseTestSetup;
import LocatorsAndActions.LoginPage.LoginPageLocators;
import org.testng.Assert;
import org.testng.annotations.Test;
import static Utilities.HelperMethods.takeScreenshot;

public class LoginPageTests extends BaseTestSetup {

    /**
     * This method will test if the title of the page is correct
     */
    @Test ()
    public void bosolochatTitleTest() {
        actualPageTitle = allActionClasses.loginPageActions().getPageTitle();
        Assert.assertEquals(actualPageTitle, "BosoloChat");

    }

    /**
     * This method tests if the page is at the proper url
     */
    @Test (priority = 1)
    public void bosolochatUrlTest() {
        actualPageUrl = allActionClasses.loginPageActions().getPageUrl();
        Assert.assertEquals(actualPageUrl, "https://bosolochat.com/welcome");
    }

    /**
     * This method will test whether the logging in and log out functionality will work
     * @throws InterruptedException
     */
    @Test (priority = 2)
    public void bosolochatLoginTest() throws InterruptedException {
        allActionClasses.loginPageActions().loginAndNavigateToHomePage("TheDon", "Tester@123");
        Thread.sleep(3000);
        takeScreenshot("LoggedIn_" + browserName);
        actualPageTitle = allActionClasses.loginPageActions().getPageTitle();
        actualPageUrl = allActionClasses.loginPageActions().getPageUrl();

        //assertions
        Assert.assertEquals(actualPageTitle, "BosoloChat");
        //Assert.assertEquals(homePageUrl, "https://bosolochat.com/?cache=1706953760");
        allActionClasses.homePageActions().logOutOfBosoloChat();
        getPage().waitForLoadState();
        takeScreenshot("LoggedOutSuccessfully_" + browserName);
//        Assert.assertEquals(actualPageUrl, "https://bosolochat.com/welcome");
        Thread.sleep(5000);
    }

    /**
     * Testing the navigation to the Register page
     * @throws InterruptedException
     */
    @Test (priority = 3)
    public void navigateToSignUpPage() throws InterruptedException {
        allActionClasses.loginPageActions().clickOnElement(LoginPageLocators.REGISTER);
        getPage().waitForLoadState();
        String createBosolochatAccountMessage = allActionClasses.registerPageActions().readCreateYourBosoloChatAccountMessage();
        Assert.assertEquals(createBosolochatAccountMessage, "Create your BosoloChat Account!");
        allActionClasses.registerPageActions().navigateBackToLoginPage();
        getPage().waitForLoadState();
        Thread.sleep(5000);
    }

    /**
     * Testing the navigation to the sign-up with Twitter page
     * @throws InterruptedException
     */
    @Test (priority = 4)
    public void navigateToLoginWithTwitterPage() throws InterruptedException {
//        page.pause();
        allActionClasses.loginPageActions().clickOnElement(LoginPageLocators.TWITTER_BTN);
        getPage().waitForLoadState();
        actualPageTitle = allActionClasses.loginPageActions().getPageTitle();
        Assert.assertEquals(actualPageTitle, "Twitter / Authorize an application");
//        registerPageActions.navigateBackToLoginPage();
        Thread.sleep(5000);
    }
}
