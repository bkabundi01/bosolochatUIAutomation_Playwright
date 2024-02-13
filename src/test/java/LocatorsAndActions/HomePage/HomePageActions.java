package LocatorsAndActions.HomePage;

import LocatorsAndActions.CommonActions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class HomePageActions extends CommonActions {
    public HomePageActions(Page page) {
        super(page);
    }

    public void clickProfileStatus() {
        clickOnElement(HomePageLocators.PROFILE_PIC_STATUS);
    }

    public void clickProfileNameToProfilePage() {
        clickOnElement(HomePageLocators.PROFILE_PAGE_BTN);
    }

    public void clickNumberOfPosts() {
        clickOnElement(HomePageLocators.POSTS_BTN);
    }

    public void clickNumberOfFollowers() {
        clickOnElement(HomePageLocators.FOLLOWERS_BTN);
    }

    public void clickNumberOfFollowing() {
        clickOnElement(HomePageLocators.FOLLOWING_BTN);
    }

    public void writeInviteYourFriendsEmailField(String email) {
        writeInFields(HomePageLocators.INVITE_YOUR_FRIENDS_FIELD, email);
    }

    public void clickInviteYourFriendsBtn() {
        clickOnElement(HomePageLocators.INVITE_YOUR_FRIENDS_BTN);
    }

    public void clickLatestProducts() {
        clickOnElement(HomePageLocators.LATEST_PRODUCTS_LINK);
    }
}
