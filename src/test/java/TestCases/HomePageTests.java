package TestCases;

import Base.BaseTestSetup;
import org.testng.annotations.Test;

public class HomePageTests extends BaseTestSetup {
    @Test
    public void navigateToHomePage() {
        allActionClasses.loginPageActions().loginAndNavigateToHomePage("TheDon", "Tester@123");
    }
}
