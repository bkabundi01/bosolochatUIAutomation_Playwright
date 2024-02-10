package LocatorsAndActions;

import com.microsoft.playwright.Page;

public class CommonActions {
    protected Page page;

    public CommonActions(Page page) {
        this.page = page;
    }

    public String getPageTitle() {
        String title = page.title();
        System.out.println("Page Title: " + title);
        return title;
    }

    public String getPageUrl() {
        String pageUrl = page.url();
        System.out.println("Page URL: " + pageUrl);
        return pageUrl;
    }

    /**
     * Write in a single field using the selector and the text to be written
     * @param selector
     * @param text
     */
    public void writeInFields(String selector, String text) {
        page.fill(selector, text);
    }

    /**
     * Write in two fields, method is overloading the previous one
     * @param selector1
     * @param selector2
     * @param text1
     * @param text2
     */
    public void writeInFields(String selector1, String selector2, String text1, String text2) {
        page.fill(selector1, text1);
        page.fill(selector2, text2);
    }

    public void clickOnElement(String locator) {
        page.click(locator);
    }
}
