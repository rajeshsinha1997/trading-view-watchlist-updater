package com.example.twu;

import com.example.twu.helper.UserInputHelper;
import com.example.twu.services.TradingViewServices;

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
            TradingViewServices.signInToTradingView();
            TradingViewServices.createNewWatchListIfRequired();
            TradingViewServices.addStocksToWatchList();
            TradingViewServices.logoutOfTradingView();
        }
    }
}
