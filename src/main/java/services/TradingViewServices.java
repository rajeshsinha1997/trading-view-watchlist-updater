package services;

import org.openqa.selenium.By;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TradingViewServices {

    private static String userEmail;
    private static String userPassword;
    private static String newWatchlistName;

    private static final String tradingViewPageURL = "https://in.tradingview.com/";

    private static final String userMenuButtonXpath = ".//div[@class='tv-header__area tv-header__area--user']//button[@class='tv-header__user-menu-button tv-header__user-menu-button--anonymous js-header-user-menu-button']";
    private static final String signInButtonXpath = ".//button[@data-name='header-user-menu-sign-in']";
    private static final String signInWithEmailButtonXpath = ".//span[@class='tv-signin-dialog__social tv-signin-dialog__toggle-email js-show-email']";
    private static final String signInEmailInputXpath = ".//input[@name='username']";
    private static final String signInPasswordInputXpath = ".//input[@name='password']";
    private static final String signInSubmitButtonXpath = ".//div[@class='tv-signin-dialog__footer-item tv-signin-dialog__footer-item--login']";
    private static final String userProfileIconXpath = ".//button[@aria-label='Open user menu']/img";
    private static final String watchListButtonXpath = ".//div[@data-name='watchlists-button']";
    private static final String createNewWatchListButtonXpath = ".//span[text()='Create new list…']";
    private static final String watchlistNameInputBox = ".//div[@data-name='rename-dialog']//input";
    private static final String saveButtonXpath = ".//button[@name='save']";
    private static final String signOutButtonXpath = ".//button[@data-name='header-user-menu-sign-out']";

    private static void acceptUserEmailPasswordWatchlistNameInput() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("ENTER TRADING VIEW EMAIL (PRESS ENTER TO SKIP): ");
            userEmail = reader.readLine().trim();
            System.out.print("ENTER TRADING VIEW PASSWORD (PRESS ENTER TO SKIP): ");
            userPassword = reader.readLine().trim();
            System.out.print("ENTER TRADING VIEW WATCH LIST NAME (PRESS ENTER TO SKIP): ");
            newWatchlistName = reader.readLine().trim();
        }
        catch (IOException e) {
            System.out.println("SOME ERROR OCCURRED!");
        }
    }

    public static void signInToTradingView() {
        acceptUserEmailPasswordWatchlistNameInput();
        SeleniumServices.initializeWebDriver("chrome", 120L);
        SeleniumServices.openWebPageFromURL(tradingViewPageURL);
        SeleniumServices.clickOnWebElement(By.xpath(userMenuButtonXpath));
        SeleniumServices.clickOnWebElement(By.xpath(signInButtonXpath));
        SeleniumServices.clickOnWebElement(By.xpath(signInWithEmailButtonXpath));
        SeleniumServices.enterTextIntoTextBox(By.xpath(signInEmailInputXpath), userEmail);
        SeleniumServices.enterTextIntoTextBox(By.xpath(signInPasswordInputXpath), userPassword);
        SeleniumServices.clickOnWebElement(By.xpath(signInSubmitButtonXpath));
    }

    public static void createNewWatchList() {
        SeleniumServices.clickOnWebElement(By.xpath(watchListButtonXpath));
        SeleniumServices.clickOnWebElement(By.xpath(createNewWatchListButtonXpath));
        SeleniumServices.enterTextIntoTextBox(By.xpath(watchlistNameInputBox), newWatchlistName);
        SeleniumServices.clickOnWebElement(By.xpath(saveButtonXpath));
    }

    public static void logoutOfTradingView() {
        SeleniumServices.refreshWebPage();
        SeleniumServices.clickOnWebElement(By.xpath(userProfileIconXpath));
        SeleniumServices.clickOnWebElement(By.xpath(signOutButtonXpath));
        SeleniumServices.quitWebDriver();
    }
}
