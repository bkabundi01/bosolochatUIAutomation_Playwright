package LocatorsAndActions.HomePage;

public interface HomePageLocators {
    //RIGHT SIDEBAR
    String PROFILE_PIC_STATUS = "//img[@class = 'seen_story see_all_stories']";
    String PROFILE_PAGE_BTN = "//a[@id = 'user-full-name']";
    String POSTS_BTN = "//ul[@class = 'wo_user_side_info']/li[1]/a[1]";
    String FOLLOWING_BTN = "//ul[@class = 'wo_user_side_info']/li[2]/a[1]";
    String FOLLOWERS_BTN = "//ul[@class = 'wo_user_side_info']/li[3]/a[1]";
    String INVITE_YOUR_FRIENDS_FIELD = "//input[@name = 'email']";
    String INVITE_YOUR_FRIENDS_BTN = "//button[@title = 'Send Invitation']";
    String LATEST_PRODUCTS_LINK = "//a[contains(text(),'Latest Products')]";
    String RIGHT_SIDE_BLANK_SPACE = "//div[@class = 'online-content-toggler']";
}
