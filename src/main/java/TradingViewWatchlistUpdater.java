import services.TradingViewServices;

public class TradingViewWatchlistUpdater {

    public static void main(String[] args) {
        TradingViewServices.signInToTradingView();
        TradingViewServices.createNewWatchList();
        TradingViewServices.logoutOfTradingView();
    }
}
