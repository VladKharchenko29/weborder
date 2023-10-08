import base.BaseTest;
import org.testng.annotations.Test;

public class SmokeTest extends BaseTest {

    @Test
    public void mainPage() {
        navigation.openMainPage();
        mainPage.selectDemo()
                .enterData();
    }

}
