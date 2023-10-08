package nav;

import setup.DriverManager;

public class Navigation implements URL {

    public void openMainPage( ){
        open(URL.MAIN_PAGE);
    }

    public void openLogin( ){
        open(URL.LOGIN);
    }

    private static void open(String url) {
        DriverManager.getWebDriver().navigate().to(url);
    }
}
