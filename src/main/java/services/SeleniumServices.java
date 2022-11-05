package services;

import exceptions.UnsupportedBrowserException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumServices {

    private static WebDriver driver;
    private static WebDriverWait wait;

    /**
     * function to initialize instance of web driver
     * @param browserName: name of the browser
     * @param waitTimeoutDurationInSeconds: duration of seconds to wait
     */
    public static void initializeWebDriver(String browserName, Long waitTimeoutDurationInSeconds) {
        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\drivers\\chrome\\chromedriver_windows_107.exe");
            driver = new ChromeDriver();
        } else throw new UnsupportedBrowserException("Unsupported Browser: " + browserName);
        initializeWait(waitTimeoutDurationInSeconds);
    }

    /**
     * function to initialize instance of web driver wait
     * @param waitTimeoutDurationInSeconds: duration of seconds to wait
     */
    public static void initializeWait(Long waitTimeoutDurationInSeconds) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(waitTimeoutDurationInSeconds));
    }

    /**
     * function to get web-page opened on browser window
     * @param url: url to navigate
     */
    public static void openWebPageFromURL(String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }

    /**
     * function to click on a web element
     * @param selector: selector to find the web element
     */
    public static void clickOnWebElement(By selector) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
        driver.findElement(selector).click();
    }

    /**
     * function to enter text into text box
     * @param selector: selector to find the input element
     * @param text: text value to enter into the text box
     */
    public static void enterTextIntoTextBox(By selector, String text) {
        clickOnWebElement(selector);
        driver.findElement(selector).clear();
        driver.findElement(selector).sendKeys(text);
    }

    /**
     * function to reload a web page
     */
    public static void refreshWebPage() {
        driver.navigate().refresh();
    }

    /**
     * function to quit web driver
     */
    public static void quitWebDriver() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
