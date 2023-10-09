import base.BaseTest;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class SmokeTest extends BaseTest {

    @Test
    @Description("Test")
    public void mainPage() {
        navigation.openMainPage();
        mainPage.selectDemo()
                .enterData();
    }

}
