package LocatorsAndActions.RegisterPage;

import LocatorsAndActions.CommonActions;
import com.microsoft.playwright.Page;

public class RegisterPageActions extends CommonActions {
    public RegisterPageActions(Page page) {
        super(page);
//        this.page = page;
    }

    public String readCreateYourBosoloChatAccountMessage() {
        String textContent = page.locator(RegisterPageLocators.CREATE_YOUR_ACCOUNT_MESSAGE).textContent();
        System.out.println("Text Content: " + textContent);
        return textContent;
    }

    public void writeUsername(String username) {
        page.fill(RegisterPageLocators.USERNAME_FIELD, username);
    }

    public void writePassword(String password) {
        page.fill(RegisterPageLocators.PASSWORD_FIELD, password);
    }

    public void writeConfirmPassword(String confirmPassword) {
        page.fill(RegisterPageLocators.CONFIRM_PASSWORD_FIELD, confirmPassword);
    }

    public void clickGenderDropdown() {
        page.click(RegisterPageLocators.GENDER_DROPDOWN);
    }

    public void clickTermsAndPolicyCheckBox() {
        page.click(RegisterPageLocators.TERMS_AND_POLICY_CHECKBOX);
    }

    public void clickLetsGoBtn() {
        page.click(RegisterPageLocators.LETS_GO_BTN);
    }

    public void navigateBackToLoginPage() {
        page.click(RegisterPageLocators.ALREADY_HAVE_ACCOUNT_LOGIN_BTN);
    }
}
