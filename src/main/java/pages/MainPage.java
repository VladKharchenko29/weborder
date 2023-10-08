package pages;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    @FindBy(css = ".hero-video-content .blue.button")
    private WebElement demoBtn;


    public BookDemoPage selectDemo() {
        demoBtn.click();
        return new BookDemoPage();
    }

}
