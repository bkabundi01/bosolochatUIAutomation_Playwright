package Base;

import LocatorsAndActions.HomePage.HomePageActions;
import LocatorsAndActions.LoginPage.LoginPageActions;
import LocatorsAndActions.RegisterPage.RegisterPageActions;
import Utilities.HelperMethods;
import com.aventstack.extentreports.ExtentTest;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.*;

import java.awt.*;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

public class BaseTestSetup {
    //Global variables
    public static Browser browser;
    public static Properties props;
    public static String currentDateTime = java.time.LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss"));
    public static String testScreenshotPath = System.getProperty("user.dir") + "/src/test/resources/TestScreenshots" ;

    //creating the objects of the action classes
    protected LoginPageActions loginPageActions;
    protected HomePageActions homePageActions;
    protected RegisterPageActions registerPageActions;
    protected String actualPageTitle;
    protected String actualPageUrl;
    public String browserName;
//******************************************************************************************************************************************************************

    /*
    Here will the initialization of the ThreadLocal variants of all the playwright objects needed to run a context
    This will help for better management, as each scenario will run with its own local copy of the objects
     */
    protected static ThreadLocal<Playwright> playwrightThreadLocal = new ThreadLocal<>();
    protected static ThreadLocal<Browser> browserThreadLocal = new ThreadLocal<>();
    protected static ThreadLocal<BrowserContext> browserContextThreadLocal = new ThreadLocal<>();
    protected static ThreadLocal<Page> pageThreadLocal = new ThreadLocal<>();
    protected static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();

    //getters for the thread local variables
    public static Playwright getPlaywright() {
        return playwrightThreadLocal.get();
    }

    public static Browser getBrowser() {
        return browserThreadLocal.get();
    }

    public static BrowserContext getBrowserContext() {
        return browserContextThreadLocal.get();
    }

    public static Page getPage() {
        return pageThreadLocal.get();
    }
    public static ExtentTest getExtentTest() {return test.get();}
//*******************************************************************************************************************************************************************

    /**
     *
     * @return a new page context
     *
     * This method helps in setting up the new page context which will then be used for the later tests
     */
    @Parameters({"browser"}) //this will grab the parameter from the testng.xml file; parameter preference will be given to that over the config.properties file
    @BeforeTest
    public Page pageSetUpFactory(String browser) throws IOException {
        props = HelperMethods.initializeProperties();
        String baseUrl = props.getProperty("baseUrl");
        //these next few lines is to grab the width and height of whatever screen is being used
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = dimension.width;
        int screenHeight = dimension.height;

        //create a connection to the playwright server
        playwrightThreadLocal.set(Playwright.create());
        //create a browser connection using
        // the helper method based on the browser given in the properties file
        browserName = browser;
        System.out.println("Browser Name: " + browserName);
        if (browser != null) { //if it's not null, it means it's the browser coming from testng
            props.setProperty("browser", browser);
        }

        browserThreadLocal.set(HelperMethods.initializeBrowser(props));
        browserContextThreadLocal.set(getBrowser().newContext());
        pageThreadLocal.set(getBrowserContext().newPage());
        getPage().navigate(baseUrl);
        //maximize the page window in proportion to the current screen size
        getPage().setViewportSize(screenWidth, screenHeight);

        //initialize the actions
        loginPageActions = new LoginPageActions(getPage());
        homePageActions = new HomePageActions(getPage());
        registerPageActions = new RegisterPageActions(getPage());
        return getPage();
    }

    @AfterTest
    public void tearDown() {
        getPage().context().browser().close();
    }
}
