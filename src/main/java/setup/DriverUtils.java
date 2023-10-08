package setup;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverUtils {

    public static ChromeOptions configurationChromeOptions() {
        ChromeOptions options = new ChromeOptions();

        options.addArguments("start-maximized");
        return options;
    }
}
