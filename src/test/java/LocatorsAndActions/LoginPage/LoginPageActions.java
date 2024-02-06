package LocatorsAndActions.LoginPage;

import LocatorsAndActions.CommonActions;
import com.microsoft.playwright.Page;


/**
 * This class requires the use of the locators found in its respective locator class
 */
public class LoginPageActions extends CommonActions {
    Page page;
    public LoginPageActions(Page page) {
        super(page);
        this.page = page;
    }

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
}
