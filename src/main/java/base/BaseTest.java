package base;

import nav.Navigation;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.MainPage;
import setup.DriverManager;

import java.io.IOException;

public class BaseTest {

    public Navigation navigation = new Navigation();
    public MainPage mainPage = new MainPage();

    @BeforeTest
    public void setup() {
        DriverManager.getWebDriver();
    }


    @AfterTest
    public void teardown() throws IOException {
//        setup.DriverManager.closeWebDriver();
    }
}
