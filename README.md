
# TradingView WatchList Updater

An easy-to-use Java Application (.jar), which you can
use to update your TradingView watchlist with the stocks
underlying any NSE Index.
<hr>

## Author: [Rajesh Sinha](https://github.com/rajeshsinha1997)
<hr>

## Pre-Requisites

- ### Java:
  This is a Java application, so to run the application
  Java should be present on your machine.

  NOT SURE HOW TO CHECK IT?

  Open Command-Prompt or Terminal (Based on the
  Operating System present on your machine), and
  type the below command on the Command-Prompt or
  Terminal window, and press enter.

  ```shell
  javac --version
  ```

  Once you press enter, if you see something similar
  as shown below then java is present on your machine.
  You should get a single line as output showing the
  version of the java compiler (i.e. javac).

  ```shell
  javac 19.0.1
  ```
  ![Java Compiler Version Image](src/main/resources/readme-images/javac-version.png)
  
  If you see any other output apart from what is shown
  above, please click on this link to [Download Java](https://www.oracle.com/in/java/technologies/downloads/)
  for your machine. Once you click on the link,
  select your operating system and then download the
  Java installer. 
  
  ![Java Download Image](src/main/resources/readme-images/download-java.png)  

  Once the installer has been downloaded,
  install java on your machine, and try to check if it
  is installed correctly using the same process shown above.
  <hr>
- ### CSV File from NSE Website

  Once you have decided which NSE Index you are going to
  use to get the stocks from, please click on this link to
  [NSE Website](https://www.nseindia.com/market-data/live-equity-market),
  and select the name of the index from the dropdown given
  in the left-hand side.

  ![NSE CSV Download Image](src/main/resources/readme-images/nse-csv-download.png)

  Once you have selected the index from the dropdown,
  click on the download button present on the right-hand
  side to download the 'csv' file of that index, which
  contains the symbols of the stocks underlying that
  particular index.

  Once the 'csv' file has been downloaded, keep it
  somewhere on your machine handy, as we are going to
  use this file later.
  <hr>
- ### Credentials of TradingView Account

  In order to update any watchlist of your TradingView
  account, the application needs to get access to
  your TradingView account, in order to get access of your
  TradingView account you need to provide the credentials
  (email ID and password) at some point to the application.

  Please keep those credentials accessible to you as
  you will need to provide those details at a later stage
  to the application to sign in to your TradingView
  account.

  Also, if you sign in to your TradingView account using
  Google and don't have any password associated with your
  TradingView account, the kindly follow the below steps
  to generate a password for your account. The application
  will not be able to work without a password.
  <hr>
  
  * Open [TradingView](https://in.tradingview.com/)
  ![TradingView Create Password 1](src/main/resources/readme-images/tradingview-create-password-1.png)
  
  * Click on Sign In
  ![TradingView Create Password 2](src/main/resources/readme-images/tradingview-create-password-2.png)

  * Click on Sign In with Email
  ![TradingView Create Password 3](src/main/resources/readme-images/tradingview-create-password-3.png)

  * Click on Forgot Password
  ![TradingView Create Password 4](src/main/resources/readme-images/tradingview-create-password-4.png)

  * Provide your email, Validate Captcha and Click on Search
  ![TradingView Create Password 5](src/main/resources/readme-images/tradingview-create-password-5.png)

  * Click on Send
  ![TradingView Create Password 6](src/main/resources/readme-images/tradingview-create-password-6.png)

  You will receive an e-mail (the same e-mail ID you provided)
  containing a link to reset the password for your TradingView account.
  Click on the link and set a new password for your TradingView account.

  Note down this password and the email ID, which will be required 
  at a later stage.
  <hr>
  
  **DON'T WORRY WITH SHARING THE CREDENTIALS WITH THE
  APPLICATION, AS THE APPLICATION IS NOT GOING TO STORE
  OR EXPOSE YOUR CREDENTIALS IN ANY WAY. HOWEVER, IF YOU WANT
  TO BE EXTRA SECURE, PLEASE CHANGE THE PASSWORD ASSOCIATED
  WITH YOUR TRADINGVIEW ACCOUNT AFTER THE OPERATION.**




## Usage/Examples

- Download the executable jar file from this link. [Click Here to Download](https://github.com/rajeshsinha1997/trading-view-watchlist-updater/raw/update-documentation/jar/TradingView_Watchlist_Updater_1.0.jar)
- Move the downloaded jar file to the desktop location. [OPTIONAL]
- Open command-prompt or terminal window at the same location where the
  downloaded jar file is present
- Type the command given below on the command-prompt or terminal window,
  and press enter.
  ```shell
  java -jar <enter the name of the jar file here>
  ```
- Once you press enter, you will see the user acceptance message, please
  read the message shown carefully and type **YES** (if you are ready to 
  share your TradingView credentials) or **NO** (if you don't want to 
  share your TradingView credentials). If you don't want to share the
  credentials the application will exit, as without the credentials it
  will not be able to sign in to TradingView and access your watch lists.
- If you have chosen to share the credentials then at the next step the
  application will ask you to share the path to the csv file, which you
  have downloaded from the NSE website. You can either drag and drop the
  csv file you have downloaded on the terminal window, or you can enter 
  the path to the csv file manually on the terminal window screen.
- Once you have provided the csv file path, then the application will ask
  you to share your TradingView credentials (email ID and password).
- Once you have shared the credentials then the application will ask you
  to choose a browser to perform the required operation.
  Please choose a browser from the list shown on the terminal window
  screen (only choose that browser which is installed on your machine, 
  do not choose any browser which is not installed on your machine),
  and press enter.
<hr>

**AT THE SIGN IN SCREEN, ONCE THE APPLICATION HAS ENTERED YOUR EMAIL ID
AND PASSWORD, YOU MAY SEE THAT A CAPTCHA NEEDS TO BE VERIFIED. PLEASE
COMPLETE THAT CAPTCHA VERIFICATION BY YOURSELF AND ONCE THAT IS DONE
CLICK ON THE SIGN-IN BUTTON.**

