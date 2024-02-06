package LocatorsAndActions.RegisterPage;

import LocatorsAndActions.LoginPage.LoginPageLocators;

public interface RegisterPageLocators {
    String CREATE_YOUR_ACCOUNT_MESSAGE = "//p[@class = 'desc']";
    String USERNAME_FIELD = LoginPageLocators.USERNAME_FIELD;
    String EMAIL_FIELD = "input[id = 'email']";
    String PASSWORD_FIELD = LoginPageLocators.PASSWORD_FIELD;
    String CONFIRM_PASSWORD_FIELD = "input[id = 'confirm_password']";
    String GENDER_DROPDOWN = "select[id = 'gender']";
    String TERMS_AND_POLICY_CHECKBOX = "input[name = 'accept_terms']";
    String LETS_GO_BTN = "button[id = 'sign_submit']";
    String ALREADY_HAVE_ACCOUNT_LOGIN_BTN = "//a[contains(text(),'Login')]";
}
