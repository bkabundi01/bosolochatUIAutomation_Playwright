package LocatorsAndActions.HomePage;

import LocatorsAndActions.CommonActions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class HomePageActions extends CommonActions {
    public HomePageActions(Page page) {
        super(page);
    }

    public void clickProfileDropDown() {
        page.locator(HomePageLocators.PROFILE_DROPDOWN).nth(0).click();
    }

    public void clickLogoutBtn() {
        page.locator(HomePageLocators.LOGOUT_BTN).click();
    }

    public void logOutOfBosoloChat() {
        clickProfileDropDown();
        clickLogoutBtn();
    }


}
