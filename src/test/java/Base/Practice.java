package Base;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Practice {
    public static void main(String[] args) throws InterruptedException {
        //create an instance
        Playwright playwright = Playwright.create();
        //create a browser context; this runs it in headed mode
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        //open a new page using the browser context
        Page page = browser.newPage();
        page.navigate("https://bosolochat.com");

        page.wait(5000);
        String title = page.title();
        System.out.println("This is the page title: " + title);

        String url = page.url();
        System.out.println("This is the url: " + url);

        browser.close();
        playwright.close();
    }
}
