package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.github.javafaker.Faker;

import java.time.Duration;

public class RegistrationPage {


    private final WebDriver driver;
    Faker faker = new Faker();

    private WebElement username;
    private WebElement password;
    private WebElement passwordRepeat;
    private WebElement firstName;
    private WebElement lastName;
    private WebElement email;
    private WebElement phone;
    private WebElement address1;
    private WebElement address2;
    private WebElement city;
    private WebElement state;
    private WebElement zip;
    private WebElement country;
    private WebElement save;


    private final By usernameField = By.name("username");
    private final By passwordField = By.name("password");
    private final By passwordRepeatField = By.name("repeatedPassword");
    private final By firstNameField = By.name("account.firstName");
    private final By lastNameField = By.name("account.lastName");
    private final By emailField = By.name("account.email");
    private final By phoneField = By.name("account.phone");
    private final By address1Field = By.name("account.address1");
    private final By address2Field = By.name("account.address2");
    private final By cityField = By.name("account.city");
    private final By stateField = By.name("account.state");
    private final By zipField = By.name("account.zip");
    private final By countryField = By.name("account.country");
    private final By saveButton = By.xpath("//input[@name='newAccount']");

    String usernameString = faker.name().username();
    String passwordString = faker.internet().password();
    String firstNameString = faker.name().firstName();
    String lastNameString = faker.name().lastName();
    String emailString = faker.internet().emailAddress();
    String phoneString = faker.phoneNumber().cellPhone();
    String address1String = faker.address().streetAddress();
    String address2String = faker.address().streetAddressNumber();
    String cityString = faker.address().city();
    String stateString = faker.address().state();
    String zipString = faker.address().zipCode();
    String countryString = faker.address().country();

    public String username() {
        return usernameString;
    }
    public String password() {
        return passwordString;
    }
    public String firstName() {
        return firstNameString;
    }

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement grabElement(By elementField) {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(elementField));
    }


    public void fillAllFields() {
        username = grabElement(usernameField);
        username.sendKeys(usernameString);

        password = grabElement(passwordField);
        password.sendKeys(passwordString);

        passwordRepeat = grabElement(passwordRepeatField);
        passwordRepeat.sendKeys(passwordString);

        firstName = grabElement(firstNameField);
        firstName.sendKeys(firstNameString);

        lastName = grabElement(lastNameField);
        lastName.sendKeys(lastNameString);

        email = grabElement(emailField);
        email.sendKeys(emailString);

        phone = grabElement(phoneField);
        phone.sendKeys(phoneString);

        address1 = grabElement(address1Field);
        address1.sendKeys(address1String);

        address2 = grabElement(address2Field);
        address2.sendKeys(address2String);

        city = grabElement(cityField);
        city.sendKeys(cityString);

        state = grabElement(stateField);
        state.sendKeys(stateString);

        zip = grabElement(zipField);
        zip.sendKeys(zipString);

        country = grabElement(countryField);
        country.sendKeys(countryString);

    }

    public void clickOnSaveButton() {
        save = grabElement(saveButton);
        save.click();
    }


}