package helper;

import java.io.IOException;
import java.util.Scanner;

public class UserDetailsHelper {

    private static Scanner scanner;

    /**
     * function to initialize the instance the scanner
     */
    public static void initializeUserDetailsHelper() {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }
    }

    /**
     * function to clear the console window screen
     */
    public static void clearConsoleWindow() {
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec(new String[]{"clear"});
        } catch (IOException | InterruptedException ignored) {}
    }

    /**
     * function to get the user's acceptance to share trading-view
     * email ID and password, along with the watch list name
     * @return user's acceptance as a string
     */
    public static boolean displayIntroductionAndGetUsersAcceptance() {
        clearConsoleWindow();
        System.out.println("********************************************");
        System.out.println("*      TRADING-VIEW WATCHLIST UPDATER      *");
        System.out.println("*          DEVELOPER: RAJESH SINHA         *");
        System.out.println("********************************************");
        System.out.println("* For the application to work, you need to *");
        System.out.println("* provide the email ID and password you    *");
        System.out.println("* use to sign-in to Trading-View. Also     *");
        System.out.println("* you need to provide the Trading-View     *");
        System.out.println("* watch list name you want to use. If no   *");
        System.out.println("* watchlist exists with that name, it will *");
        System.out.println("* create a new watchlist with the same     *");
        System.out.println("* name.                                    *");
        System.out.println("********************************************");
        System.out.println("* BUT DON'T WORRY! WE RESPECT YOUR PRIVACY *");
        System.out.println("* AND WE UNDERSTAND THE IMPORTANCE TO KEEP *");
        System.out.println("* YOUR CREDENTIALS SAFE AND SECURE.        *");
        System.out.println("* THERE IS NO WAY THIS APPLICATION WILL    *");
        System.out.println("* SAVE YOUR CREDENTIALS OR EXPOSE THEM! :) *");
        System.out.println("********************************************");
        System.out.println("*                                          *");
        System.out.println("* DO YOU AGREE TO SHARE THE ABOVE          *");
        System.out.println("* MENTIONED DETAILS WITH THIS APPLICATION? *");
        System.out.println("*                                          *");
        System.out.println("* --> YES                                  *");
        System.out.println("* --> NO                                   *");
        System.out.println("********************************************");
        System.out.print("* ENTER YOUR CHOICE: ");
        String choice = scanner.nextLine().trim();
        if (choice.equalsIgnoreCase("yes")) {
            return true;
        }
        else if (choice.equalsIgnoreCase("no")) {
            clearConsoleWindow();
            System.out.println("********************************************");
            System.out.println("* The application will not be able to sign *");
            System.out.println("* in to Trading View without the email ID  *");
            System.out.println("* and password, which is required to       *");
            System.out.println("* create/update any watch list.            *");
            System.out.println("*                                          *");
            System.out.println("* Also without the watch list name, the    *");
            System.out.println("* application will not be able to add      *");
            System.out.println("* entries, as the application will not     *");
            System.out.println("* which watchlist to work on with.         *");
            System.out.println("********************************************");
            System.out.println("* EXITING FROM THE APPLICATION AS YOU HAVE *");
            System.out.println("* DECIDED NOT TO SHARE THE DETAILS.        *");
            System.out.println("********************************************");
            return false;
        }
        else {
            clearConsoleWindow();
            System.out.println("********************************************");
            System.out.println("* Invalid Input! Please enter YES or No    *");
            System.out.println("********************************************");
            System.out.println("* PRESS ANY KEY TO CONTINUE...             *");
            System.out.println("********************************************");
            scanner.nextLine();
            return displayIntroductionAndGetUsersAcceptance();
        }
    }

    /**
     * function to get user's choice of method to share the required details
     * @return user's choice as a string
     */
    public static String acceptUsersChoiceForInputMethod() {
        clearConsoleWindow();
        System.out.println("********************************************");
        System.out.println("* There are two ways you can pass on the   *");
        System.out.println("* email ID, password you use to sign in to *");
        System.out.println("* Trading-View, along with the watch list  *");
        System.out.println("* name.                                    *");
        System.out.println("********************************************");
        System.out.println("* 1. Note down the credentials and the     *");
        System.out.println("*    watchlist name on the properties file *");
        System.out.println("*    provided along with the application.  *");
        System.out.println("*    (RECOMMENDED)                         *");
        System.out.println("*                                          *");
        System.out.println("* 2. Provide the required inputs to this   *");
        System.out.println("*    console window in the next step.      *");
        System.out.println("********************************************");
        System.out.print("* ENTER YOUR CHOICE (1 or 2): ");
        String choice = scanner.nextLine().trim();
        if (choice.equals("1") || choice.equals("2")) {
            return choice;
        }
        else {
            clearConsoleWindow();
            System.out.println("********************************************");
            System.out.println("* Invalid Input! Please enter 1 or 2       *");
            System.out.println("********************************************");
            System.out.println("* PRESS ANY KEY TO CONTINUE...             *");
            System.out.println("********************************************");
            scanner.nextLine();
            return acceptUsersChoiceForInputMethod();
        }
    }

    /**
     * function to get user's email input
     * @return user's email id as string
     */
    public static String getUserEmailInput() {
        clearConsoleWindow();
        String email;
        System.out.println("********************************************");
        System.out.println("* PLEASE ENTER THE EMAIL BELOW THAT YOU    *");
        System.out.println("* USE TO SIGN IN TO TRADING-VIEW.          *");
        System.out.println("********************************************");
        System.out.print("* ENTER YOUR EMAIL: ");
        email = scanner.nextLine().trim();
        if (email.length()<5 || !email.contains("@")) {
            clearConsoleWindow();
            System.out.println("********************************************");
            System.out.println("* Invalid Input! Please enter valid email  *");
            System.out.println("********************************************");
            System.out.println("* PRESS ANY KEY TO CONTINUE...             *");
            System.out.println("********************************************");
            scanner.nextLine();
            return getUserEmailInput();
        }
        else {
            return email;
        }
    }

    /**
     * function to get user's password input
     * @return user's password as string
     */
    public static String getUserPasswordInput() {
        clearConsoleWindow();
        String password;
        System.out.println("********************************************");
        System.out.println("* PLEASE ENTER THE PASSWORD BELOW THAT YOU *");
        System.out.println("* USE TO SIGN IN TO TRADING-VIEW.          *");
        System.out.println("********************************************");
        System.out.print("* ENTER YOUR PASSWORD: ");
        password = scanner.nextLine().trim();
        if (password.length()<1) {
            clearConsoleWindow();
            System.out.println("********************************************");
            System.out.println("* Invalid Input! Please enter valid        *");
            System.out.println("* password.                                *");
            System.out.println("********************************************");
            System.out.println("* PRESS ANY KEY TO CONTINUE...             *");
            System.out.println("********************************************");
            scanner.nextLine();
            return getUserPasswordInput();
        }
        else {
            return password;
        }
    }

    /**
     * function to get watch list name input
     * @return watch list name as string
     */
    public static String getWatchListNameInput() {
        clearConsoleWindow();
        String watchListName;
        System.out.println("********************************************");
        System.out.println("* PLEASE ENTER THE WATCH LIST NAME BELOW   *");
        System.out.println("********************************************");
        System.out.print("* ENTER WATCH LIST NAME: ");
        watchListName = scanner.nextLine().trim();
        if (watchListName.length()<1) {
            clearConsoleWindow();
            System.out.println("********************************************");
            System.out.println("* Invalid Input! Please enter valid        *");
            System.out.println("* watch list name                          *");
            System.out.println("********************************************");
            System.out.println("* PRESS ANY KEY TO CONTINUE...             *");
            System.out.println("********************************************");
            scanner.nextLine();
            return getWatchListNameInput();
        }
        else {
            return watchListName;
        }
    }
}
