package TestCases;

import Base.BaseTestSetup;
import org.testng.Assert;
import org.testng.annotations.Test;
import static Utilities.HelperMethods.takeScreenshot;

public class LoginPageTests extends BaseTestSetup {

    @Test ()
    public void bosolochatTitleTest() {
        actualPageTitle = loginPageActions.getPageTitle();
        Assert.assertEquals(actualPageTitle, "BosoloChat");
    }

    @Test (priority = 1)
    public void bosolochatUrlTest() {
        actualPageUrl = loginPageActions.getPageUrl();
        Assert.assertEquals(actualPageUrl, "https://bosolochat.com/welcome");
    }

    @Test (priority = 4)
    public void navigateToLoginWithTwitterPage() throws InterruptedException {
//        page.pause();
        loginPageActions.clickTwitterBtn();
        getPage().waitForLoadState();
        actualPageTitle = loginPageActions.getPageTitle();
        Assert.assertEquals(actualPageTitle, "Twitter / Authorize an application");
//        registerPageActions.navigateBackToLoginPage();
        Thread.sleep(5000);
    }

    @Test (priority = 3)
    public void navigateToSignUpPage() throws InterruptedException {
        loginPageActions.clickRegisterBtn();
        getPage().waitForLoadState();
        String createBosolochatAccountMessage = registerPageActions.readCreateYourBosoloChatAccountMessage();
        Assert.assertEquals(createBosolochatAccountMessage, "Create your BosoloChat Account!");
        registerPageActions.navigateBackToLoginPage();
        getPage().waitForLoadState();
        Thread.sleep(5000);
    }

    @Test (priority = 2)
    public void bosolochatLoginTest() throws InterruptedException {
//        getPage().pause();
        loginPageActions.writeUsername("TheDon");
        loginPageActions.writePassword("Tester@123");
        loginPageActions.clickLoginBtn();
        //wait for the page to load
//        getPage().waitForLoadState();
        Thread.sleep(3000);
        takeScreenshot("LoggedIn_" + browserName);
        actualPageTitle= loginPageActions.getPageTitle();
        actualPageUrl = loginPageActions.getPageUrl();

        //assertions
        Assert.assertEquals(actualPageTitle, "BosoloChat");
        //Assert.assertEquals(homePageUrl, "https://bosolochat.com/?cache=1706953760");
//        homePageActions.clickProfileDropDown();
//        getPage().waitForLoadState();
//        takeScreenshot("DropDownMenu_" + browserName);
//        Thread.sleep(5000);
//        homePageActions.clickLogoutBtn();
//        getPage().waitForLoadState();
//        takeScreenshot("LoggedOutSuccessfully_" + browserName);
//        Thread.sleep(5000);
    }
}
