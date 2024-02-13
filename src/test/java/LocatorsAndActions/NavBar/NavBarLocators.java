package LocatorsAndActions.NavBar;

public interface NavBarLocators {

    //  THESE SELECTORS ARE FOR THE REST OF THE NAVBAR
    String HOME_BTN = "//ul[@class = 'nav navbar-nav']/li[1]/a[1]";
    String CREATE_BTN = "//ul[@class = 'nav navbar-nav']/li[2]/a[1]";
    String SEARCH_BAR = "//input[starts-with(@placeholder, 'Search')]";
    String REQUESTS_BTN = "//header/div[1]/nav[1]/div[1]/ul[2]/li[1]/a[1]";
    String MESSAGES_NOTIFS_BTN = "//li[@class = 'dropdown messages-notification-container']/a[1]";
    String NOTIFICATIONS_BTN = "//li[@class = 'dropdown notification-container']/a[1]";

    //******************************************************************************************************************************

    /**
     * THESE ELEMENTS WILL BE FOR THE PROFILE DROP DOWN
     */
    String PROFILE_DROPDOWN = "img[id = 'updateImage-135']";
    String WALLET_BTN = "//ul[@class = 'dropdown-menu ani-acc-menu']/li[1]/a[2]";
    String POINTS_BTN = "//ul[@class = 'dropdown-menu ani-acc-menu']/li[1]/a[3]";
    String MANAGE_SUBSCRIPTIONS_BTN = "//ul[@class = 'dropdown-menu ani-acc-menu']/li[2]/a[1]";
    String EDIT_PROFILE_BTN = "//ul[@class = 'dropdown-menu ani-acc-menu']/li[32]/a[1]";
    String GENERAL_SETTING_BTN = "//ul[@class = 'dropdown-menu ani-acc-menu']/li[33]/a[1]";
    String LOGOUT_BTN = "//ul[@class = 'dropdown-menu ani-acc-menu']/li[39]/a[1]";
    String NIGHT_MODE_BTN = "//a[@id='night_mode_toggle']";
}
