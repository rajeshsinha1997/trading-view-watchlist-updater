package com.example.twu.services;

import com.example.twu.constants.BrowserConstants;
import com.example.twu.helper.SeleniumHelper;
import com.example.twu.helper.UserInputHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TradingViewServices {

    private static String userEmail;
    private static String userPassword;
    private static String newWatchlistName;

    private static final String TRADING_VIEW_PAGE_URL = "https://in.tradingview.com/";

    private static final String USER_MENU_BUTTON_XPATH = ".//div[@class='tv-header__area tv-header__area--user']//button[@class='tv-header__user-menu-button tv-header__user-menu-button--anonymous js-header-user-menu-button']";
    private static final String SIGN_IN_BUTTON_XPATH = ".//button[@data-name='header-user-menu-sign-in']";
    private static final String SIGN_IN_WITH_EMAIL_BUTTON_XPATH = ".//span[@class='tv-signin-dialog__social tv-signin-dialog__toggle-email js-show-email']";
    private static final String SIGN_IN_EMAIL_INPUT_XPATH = ".//input[@name='username']";
    private static final String SIGN_IN_PASSWORD_INPUT_XPATH = ".//input[@name='password']";
    private static final String SIGN_IN_SUBMIT_BUTTON_XPATH = ".//div[@class='tv-signin-dialog__footer-item tv-signin-dialog__footer-item--login']";
    private static final String USER_PROFILE_ICON_XPATH = ".//button[@aria-label='Open user menu']/img";
    private static final String WATCH_LIST_BUTTON_XPATH = ".//div[@data-name='watchlists-button']";
    private static final String WATCHLIST_NAMES_LIST_XPATH =
            ".//div[@data-name='popup-menu-container']//div[contains(@class,'item-')]//span[contains(@class,'label-')]//span[contains(@class,'title')]";
    private static final String CREATE_NEW_WATCH_LIST_BUTTON_XPATH = ".//span[text()='Create new list…']";
    private static final String WATCHLIST_NAME_INPUT_BOX = ".//div[@data-name='rename-dialog']//input";
    private static final String SAVE_BUTTON_XPATH = ".//button[@name='save']";
    private static final String ADD_SYMBOL_BUTTON_XPATH = ".//div[@data-name='add-symbol-button']";
    private static final String SYMBOL_SEARCH_BOX_XPATH = ".//input[@data-role='search']";
    private static final String STOCK_FILTER_BUTTON_XPATH = ".//span[@id='stock']";
    private static final String SYMBOL_SEARCH_RESULT_LIST_XPATH =
            ".//div[@data-name='symbol-search-dialog-content-item']//div[contains(@class,'description')]//span/em";
    private static final String CLOSE_SYMBOL_SEARCH_WINDOW_BUTTON_XPATH = ".//button[@data-name='close']";
    private static final String SIGN_OUT_BUTTON_XPATH = ".//button[@data-name='header-user-menu-sign-out']";

    private static void getUserEmailPasswordWatchlistNameInput() {
        userEmail = UserInputHelper.getUserEmailInput();
        userPassword = UserInputHelper.getUserPasswordInput();
        newWatchlistName = UserInputHelper.getWatchListNameInput();
    }

    /**
     * function to use selenium to sign in to trading view account
     */
    public static void signInToTradingView() {
        getUserEmailPasswordWatchlistNameInput();
        switch (UserInputHelper.getBrowserChoiceInput()) {
            case "1" -> SeleniumHelper.initializeWebDriver(BrowserConstants.CHROME);
            case "2" -> SeleniumHelper.initializeWebDriver(BrowserConstants.FIREFOX);
            case "3" -> SeleniumHelper.initializeWebDriver(BrowserConstants.EDGE);
        }
        SeleniumHelper.initializeWait(120L);
        SeleniumHelper.openWebPageFromURL(TRADING_VIEW_PAGE_URL);
        SeleniumHelper.clickOnWebElement(By.xpath(USER_MENU_BUTTON_XPATH));
        SeleniumHelper.clickOnWebElement(By.xpath(SIGN_IN_BUTTON_XPATH));
        SeleniumHelper.clickOnWebElement(By.xpath(SIGN_IN_WITH_EMAIL_BUTTON_XPATH));
        SeleniumHelper.enterTextIntoTextBox(By.xpath(SIGN_IN_EMAIL_INPUT_XPATH), userEmail);
        SeleniumHelper.enterTextIntoTextBox(By.xpath(SIGN_IN_PASSWORD_INPUT_XPATH), userPassword);
        SeleniumHelper.clickOnWebElement(By.xpath(SIGN_IN_SUBMIT_BUTTON_XPATH));
    }

    /**
     * function to use selenium to create new trading view watchlist if required
     */
    public static void createNewWatchListIfRequired() {
        try {
            SeleniumHelper.clickOnWebElement(By.xpath(WATCH_LIST_BUTTON_XPATH));
            List<WebElement> watchLists = SeleniumHelper.getListOfWebElements(By.xpath(WATCHLIST_NAMES_LIST_XPATH));
            boolean found = false;
            for (WebElement watchList : watchLists) {
                if (watchList.getText().trim().equalsIgnoreCase(newWatchlistName)) {
                    System.out.println("WATCHLIST FOUND WITH NAME: " + newWatchlistName);
                    found = true;
                    SeleniumHelper.clickOnWebElement(watchList);
                    break;
                }
            }
            if (!found) {
                System.out.println("CREATING NEW WATCHLIST WITH NAME: " + newWatchlistName);
                SeleniumHelper.clickOnWebElement(By.xpath(CREATE_NEW_WATCH_LIST_BUTTON_XPATH));
                SeleniumHelper.enterTextIntoTextBox(By.xpath(WATCHLIST_NAME_INPUT_BOX), newWatchlistName);
                SeleniumHelper.clickOnWebElement(By.xpath(SAVE_BUTTON_XPATH));
            }
        }
        catch (StaleElementReferenceException e) {
            SeleniumHelper.refreshWebPage();
            createNewWatchListIfRequired();
        }
    }

    /**
     * function to add stocks to trading view watch list
     * @param symbols: list of stock symbols to add
     */
    public static void addStocksToWatchList(List<String> symbols) {
        System.out.println("TOTAL SYMBOLS TO ADD: "+symbols.size());
        int totalSymbolAdded = 0;
        for (String symbol : symbols) {
            SeleniumHelper.clickOnWebElement(By.xpath(ADD_SYMBOL_BUTTON_XPATH));
            SeleniumHelper.enterTextIntoTextBox(By.xpath(SYMBOL_SEARCH_BOX_XPATH), "NSE:"+symbol);
            SeleniumHelper.clickOnWebElement(By.xpath(STOCK_FILTER_BUTTON_XPATH));
            List<WebElement> results =
                    SeleniumHelper.getListOfWebElements(By.xpath(SYMBOL_SEARCH_RESULT_LIST_XPATH));
            if (results.size() > 0) {
                SeleniumHelper.clickOnWebElement(results.get(0));
                System.out.println("ADDED SYMBOL ("+(++totalSymbolAdded)+" of "+symbols.size()+") --> "
                        +symbol+" (Expected) / "+results.get(0).getText().trim()+" (Actual)");
            }
            else {
                System.out.println("COULDN'T ADD SYMBOL: "+symbol);
            }
            SeleniumHelper.clickOnWebElement(By.xpath(CLOSE_SYMBOL_SEARCH_WINDOW_BUTTON_XPATH));
        }
    }

    /**
     * function to use selenium to log out of trading view account
     */
    public static void logoutOfTradingView() {
        SeleniumHelper.refreshWebPage();
        SeleniumHelper.clickOnWebElement(By.xpath(USER_PROFILE_ICON_XPATH));
        SeleniumHelper.clickOnWebElement(By.xpath(SIGN_OUT_BUTTON_XPATH));
        SeleniumHelper.quitWebDriver();
    }
}
