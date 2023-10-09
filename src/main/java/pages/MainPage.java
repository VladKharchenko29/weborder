package pages;

import base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    @FindBy(css = ".hero-video-content .blue.button")
    private WebElement demoBtn;

    @Step("Selecting Demo")
    public BookDemoPage selectDemo() {
        demoBtn.click();
        return new BookDemoPage();
    }

}
