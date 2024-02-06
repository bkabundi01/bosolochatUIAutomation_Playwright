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
}
