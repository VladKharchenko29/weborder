package pages;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import setup.DriverManager;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BookDemoPage extends MainPage {

    @FindBy(id = "FirstName")
    private WebElement firsName;
    @FindBy(id = "LastName")
    private WebElement lastName;
    @FindBy(id = "Company")
    private WebElement company;
    @FindBy(id = "Email")
    private WebElement email;
    @FindBy(id = "Phone")
    private WebElement phone;
    @FindBy(id = "Other_Lead_Source__c")
    private WebElement aboutUs;
    @FindBy(id = "Account_Segment__c")
    private WebElement dropdown;
    @FindBy(css = "[type='submit']")
    private WebElement submitBtn;


    Faker faker = new Faker();
    String firstNameString = faker.name().firstName();
    String lastNameString = faker.name().lastName();
    String companyString = faker.company().name();
    String mailString = faker.internet().emailAddress();
    String phoneString = String.valueOf(faker.number().randomNumber(9, true));
    String aboutUsString = faker.starTrek().specie();

    @Step("Entering data into fields")
    public void enterData() {
        DriverManager.getWebDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        firsName.sendKeys(firstNameString);
        lastName.sendKeys(lastNameString);
        company.sendKeys(companyString);
        email.sendKeys(mailString);
        phone.sendKeys(phoneString);

        Select select = new Select(dropdown);
        select.selectByIndex(2);

        aboutUs.sendKeys(aboutUsString);
//        submitBtn.click();
    }

}
