package LocatorsAndActions.SideBars;

import LocatorsAndActions.CommonActions;
import com.microsoft.playwright.Page;

public class SideBarsActions extends CommonActions {
    public SideBarsActions(Page page) {
        super(page);
    }

    //ACTIONS FOR THE LEFT SIDEBAR
    public void clickNewsFeedBtn() {
        clickOnElement(SideBarLocators.NEWSFEED_BTN);
    }

    public void clickNewsFeedDropDown() {
        clickOnElement(SideBarLocators.NEWSFEED_DROPDOWN);
    }

    public void clickAlbumBtm() {
        clickOnElement(SideBarLocators.ALBUM_BTN);
    }

    public void clickSavedPostsBtn() {
        clickOnElement(SideBarLocators.SAVED_POSTS_BTN);
    }

    public void clickPopularPostsBtn() {
        clickOnElement(SideBarLocators.POPULAR_POSTS_BTN);
    }

    public void clickMemoriesBtn() {
        clickOnElement(SideBarLocators.MEMORIES_BTN);
    }

    public void clickPokesBtn() {
        clickOnElement(SideBarLocators.POKES_BTN);
    }

    public void clickMyGroupsBtn() {
        clickOnElement(SideBarLocators.MY_GROUPS_BTN);
    }

    public void clickMyPagesBtn() {
        clickOnElement(SideBarLocators.MY_PAGES_BTN);
    }

    public void clickBlogBtn() {
        clickOnElement(SideBarLocators.BLOG_BTN);
    }

    public void clickMarketBtn() {
        clickOnElement(SideBarLocators.MARKET_BTN);
    }

    public void clickEventsBtn() {
        clickOnElement(SideBarLocators.EVENTS_BTN);
    }

    public void clickGamesBtn() {
        clickOnElement(SideBarLocators.GAMES_BTN);
    }

    public void clickForumsBtn() {
        clickOnElement(SideBarLocators.FORUMS_BTN);
    }

    public void clickMoviesBtn() {
        clickOnElement(SideBarLocators.MOVIES_BTN);
    }

    public void clickJobsBtn(){
        clickOnElement(SideBarLocators.JOBS_BTN);
    }

    public void clickOffersBtn() {
        clickOnElement(SideBarLocators.OFFERS_BTN);
    }

    public void clickFindFriendsBtn() {
        clickOnElement(SideBarLocators.FIND_FRIENDS_BTN);
    }

    public void clickCommonThings() {
        clickOnElement(SideBarLocators.COMMON_THINGS_BTN);
    }

    public void clickFundingBtn() {
        clickOnElement(SideBarLocators.FUNDING_BTN);
    }
}
