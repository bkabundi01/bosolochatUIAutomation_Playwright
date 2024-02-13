package Base;

import LocatorsAndActions.HomePage.HomePageActions;
import LocatorsAndActions.LoginPage.LoginPageActions;
import LocatorsAndActions.NavBar.NavBarActions;
import LocatorsAndActions.ProfilePage.ProfilePageActions;
import LocatorsAndActions.RegisterPage.RegisterPageActions;
import LocatorsAndActions.TwitterPage.TwitterPageActions;
import com.microsoft.playwright.Page;

/**
 * This class serves as an efficient way to initialize and access all the action classes from one location
 * Then in BaseTestSetup, only this class need be initialized and implemented
 * Once the object of this class is initialized, the object can be used to access all of these below action classes
 */
public class ActionClasses_Initialization {
    private Page page;

    public ActionClasses_Initialization(Page page) {
        this.page = page;
    }

    public LoginPageActions loginPageActions() {
        return new LoginPageActions(page);
    }

    public HomePageActions homePageActions() {
        return new HomePageActions(page);
    }

    public RegisterPageActions registerPageActions() {
        return new RegisterPageActions(page);
    }

    public TwitterPageActions twitterPageActions() {
        return new TwitterPageActions(page);
    }

    public ProfilePageActions profilePageActions() {
        return new ProfilePageActions(page);
    }

    public NavBarActions navBarActions(){return new NavBarActions(page);}
}
