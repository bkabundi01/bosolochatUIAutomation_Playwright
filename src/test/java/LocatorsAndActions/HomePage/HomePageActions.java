package LocatorsAndActions.HomePage;

import LocatorsAndActions.CommonActions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class HomePageActions extends CommonActions {
    Page page;
    public HomePageActions(Page page) {
        super(page);
        this.page = page;
    }

    public void clickProfileDropDown() {
        page.locator(HomePageLocators.PROFILE_DROPDOWN).nth(0).click();
    }

    public void clickLogoutBtn() {
        page.locator(HomePageLocators.LOGOUT_BTN).click();
//        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(HomePageLocators.LOGOUT_BTN)).click();
    }


}
