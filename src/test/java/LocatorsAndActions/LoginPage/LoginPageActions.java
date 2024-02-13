package LocatorsAndActions.LoginPage;

import LocatorsAndActions.CommonActions;
import com.microsoft.playwright.Page;


/**
 * This class requires the use of the locators found in its respective locator class
 */
public class LoginPageActions extends CommonActions {
    public LoginPageActions(Page page) {
        super(page);
    }

//***********************************************************************************************************************
//These methods are for interacting with the individual elements of the page
    public void writeUsername(String userName) {
        page.fill(LoginPageLocators.USERNAME_FIELD, userName);
    }

    public void writePassword(String password) {
        page.fill(LoginPageLocators.PASSWORD_FIELD, password);
    }

    public void clickLoginBtn() {
        page.click(LoginPageLocators.LOGIN_BTN);
    }
    public void clickTwitterBtn() {page.click(LoginPageLocators.TWITTER_BTN);}
    public void clickRegisterBtn() {page.click(LoginPageLocators.REGISTER);}
    public void clickForgotPasswordBtn() {page.click(LoginPageLocators.FORGOT_PASSWORD_BTN);}

//**********************************************************************************************************************
//These will be methods to navigate to different pages from the LoginPage. It can be used by other pages

    /**
     * This method is to log into BosoloChat
     * @param username
     * @param password
     */
    public void loginAndNavigateToHomePage(String username, String password) {
        writeUsername(username);
        writePassword(password);
        clickLoginBtn();
    }
}
