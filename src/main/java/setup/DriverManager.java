package setup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class DriverManager {

    public static WebDriver webDriver;

    public static WebDriver getWebDriver() {
        WebDriverManager.chromedriver().setup();
        if (webDriver == null) {
            webDriver = new ChromeDriver(DriverUtils.configurationChromeOptions());
        }
        return webDriver;
    }

    public static void closeWebDriver() throws IOException {
        webDriver.close();
        if (webDriver != null) {
            webDriver.quit();
            webDriver = null;
        }
        Runtime rt = Runtime.getRuntime();
        rt.exec("taskkill /im chromedriver.exe /f /t");
    }
}

