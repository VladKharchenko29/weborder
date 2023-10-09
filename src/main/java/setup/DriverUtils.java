package setup;

import org.openqa.selenium.chrome.ChromeOptions;

public class DriverUtils {

    public static ChromeOptions configurationChromeOptions() {
        ChromeOptions options = new ChromeOptions();

        options.addArguments("start-maximized");
        options.addArguments("--remote-allow-origins=*");
        return options;
    }

}
