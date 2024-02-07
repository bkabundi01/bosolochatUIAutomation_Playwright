package Utilities;

import Base.BaseTestSetup;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Properties;

public class HelperMethods extends BaseTestSetup {
    static Properties props;

    static {
        try {
            props = initializeProperties();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //initialize the properties to be able to read from the config.properties file
    public static Properties initializeProperties() throws IOException {
        FileReader fileReader = new FileReader(System.getProperty("user.dir") + "/src/test/resources/config.properties");
        Properties props = new Properties();
        props.load(fileReader);

        return props;
    }

    /**
     *
     * @param props
     * @return the browser connection
     *
     * This method helps in returning the correct browser connection based on what is passed in from the config.properties file
     * It keeps the browser connection type dynamic
     */
    public static Browser initializeBrowser(Properties props) {
        boolean headless = Boolean.parseBoolean(props.getProperty("headless"));
        String browserName = props.getProperty("browser");
        switch (browserName.toLowerCase()) {
            case "chromium": {
                browser = getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setHeadless(headless));
//                browser = BaseSetup.playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(headless));
//                browserThreadLocal.set(getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setHeadless(headless)));
                break;
            }
            case "chrome": {
                browser = getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(headless));
                break;
            }
            case "edge": {
                browser = getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(headless));
                break;
            }
            case "firefox": {
                browser = getPlaywright().firefox().launch(new BrowserType.LaunchOptions().setHeadless(headless));
                break;
            }
            case "safari": {
                browser = getPlaywright().webkit().launch(new BrowserType.LaunchOptions().setHeadless(headless));
                break;
            }
        }

        return browser;
    }

    public static String takeScreenshot(String fileName) {
        String path = testScreenshotPath + "/" + fileName + currentDateTime + ".png";

//        getPage().screenshot(new Page.ScreenshotOptions()
//                .setPath(Paths.get(path)));

        //now with base64 buffer image
        byte[] buffer = getPage().screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)));
        return Base64.getEncoder().encodeToString(buffer);
    }
}
