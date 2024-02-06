package LocatorsAndActions.HomePage;

import com.microsoft.playwright.Locator;

public interface HomePageLocators {
    //for this dropdown, it is the first index of the nth element
    String PROFILE_DROPDOWN = "img[id = 'updateImage-135']";
    String LOGOUT_BTN = "//ul[@class = 'dropdown-menu ani-acc-menu']/li[39]/a[1]";
}
