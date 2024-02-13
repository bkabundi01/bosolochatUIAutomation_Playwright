package LocatorsAndActions.NavBar;

import LocatorsAndActions.CommonActions;
import com.microsoft.playwright.Page;

public class NavBarActions extends CommonActions {
    public NavBarActions(Page page) {
        super(page);
    }


//THESE METHODS WILL BE TO CLICK THE NAVBAR BUTTONS
    public void clickHomeButton(){clickOnElement(NavBarLocators.HOME_BTN);}

    public void clickCreateButton(){clickOnElement(NavBarLocators.CREATE_BTN);}
    public void typeInSearchBar(String searchText) {
        clickOnElement(NavBarLocators.SEARCH_BAR);
        writeInFields(NavBarLocators.SEARCH_BAR, searchText);
    }

    public void clickRequestsBtn() {
        clickOnElement(NavBarLocators.REQUESTS_BTN);
    }

    public void clickMessagesNotifsBtn() {
        clickOnElement(NavBarLocators.MESSAGES_NOTIFS_BTN);
    }

    public void clickNotificationsBtn() {
        clickOnElement(NavBarLocators.NOTIFICATIONS_BTN);
    }


//******************************************************************************************************************************
//THESE METHODS WILL BE TO INTERACT WITH THE PROFILE DROP DOWN ELEMENTS
    public void clickProfileDropDown() {
        page.locator(NavBarLocators.PROFILE_DROPDOWN).nth(0).click();
    }

    public void clickWalletBtn(){clickOnElement(NavBarLocators.WALLET_BTN);}
    public void clickPointsBtn(){clickOnElement(NavBarLocators.POINTS_BTN);}
    public void clickManageSubscriptionsBtn(){clickOnElement(NavBarLocators.MANAGE_SUBSCRIPTIONS_BTN);}
    public void clickEditProfileBtn(){clickOnElement(NavBarLocators.EDIT_PROFILE_BTN);}
    public void clickGeneralSettingsBtn(){clickOnElement(NavBarLocators.GENERAL_SETTING_BTN);}
    public void clickLogoutBtn() {
        clickOnElement(NavBarLocators.LOGOUT_BTN);
    }
    public void clickNightModeBtn(){clickOnElement(NavBarLocators.NIGHT_MODE_BTN);}


    public void logOutOfBosoloChat() {
        clickProfileDropDown();
        clickLogoutBtn();
    }


}
