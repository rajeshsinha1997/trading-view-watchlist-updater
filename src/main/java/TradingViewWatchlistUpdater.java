import constants.BrowserConstants;
import helper.PropertiesHelper;
import helper.SeleniumHelper;
import helper.UserDetailsHelper;
import services.TradingViewServices;

public class TradingViewWatchlistUpdater {

    public static void initializeHelpers() {
        UserDetailsHelper.initializeUserDetailsHelper();
        PropertiesHelper.initializePropertiesHelper();
    }

    /**
     * function to start the application
     * @param args: command line arguments
     */
    public static void main(String[] args) {
        initializeHelpers();
        if (UserDetailsHelper.displayIntroductionAndGetUsersAcceptance()) {
            SeleniumHelper.initializeWebDriver(BrowserConstants.CHROME);
            SeleniumHelper.initializeWait(120L);
            TradingViewServices.signInToTradingView();
            TradingViewServices.createNewWatchListIfRequired();
            TradingViewServices.addStocksToWatchList();
            TradingViewServices.logoutOfTradingView();
        }
    }
}
