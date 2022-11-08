package com.example.twu;

import com.example.twu.helper.CSVHelper;
import com.example.twu.helper.UserInputHelper;
import com.example.twu.services.TradingViewServices;

import java.io.IOException;
import java.util.List;

public class TradingViewWatchlistUpdater {

    public static void initializeHelpers() {
        UserInputHelper.initializeUserDetailsHelper();
    }

    /**
     * function to start the application
     * @param args: command line arguments
     */
    public static void main(String[] args) {
        initializeHelpers();
        if (UserInputHelper.displayIntroductionAndGetUsersAcceptance()) {
            try {
                List<String> symbols = CSVHelper.getStockSymbolsFromCSVFile();
                TradingViewServices.signInToTradingView();
                TradingViewServices.createNewWatchListIfRequired();
                TradingViewServices.addStocksToWatchList(symbols);
                TradingViewServices.logoutOfTradingView();
            } catch (IOException e) {
                TradingViewServices.logoutOfTradingView();
            }
        }
    }
}
