import constants.BrowserConstants;
import helper.PropertiesHelper;
import helper.SeleniumHelper;
import services.TradingViewServices;

public class TradingViewWatchlistUpdater {

    /**
     * function to start the application
     * @param args: command line arguments
     */
    public static void main(String[] args) {
        PropertiesHelper.initializePropertiesHelper();
        SeleniumHelper.initializeWebDriver(BrowserConstants.CHROME);
        SeleniumHelper.initializeWait(120L);
        TradingViewServices.signInToTradingView();
        TradingViewServices.createNewWatchListIfRequired();
        TradingViewServices.addStocksToWatchList();
        TradingViewServices.logoutOfTradingView();
    }
}
