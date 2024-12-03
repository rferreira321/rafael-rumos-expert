package PageObjects;

import Utilities.testUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//import PageObjects.RegistrationPage.credentials;

public class SignInPage {

    // Webdriver initialization
    private final WebDriver driver;
    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }


    private WebElement register;
    private WebElement login;
    private WebElement username;
    private WebElement password;

    private final By registerButton = By.xpath("//a[normalize-space()='Register Now!']");
    private final By loginButton = By.xpath("//input[@name='signon']");
    private final By usernameField = By.name("username");
    private final By passwordField = By.name("password");



    public void clickRegisterButton() {

        register = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(registerButton));
        register.click();
    }

    public void enterUsername(String usernameString) {

        username = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(usernameField));
        username.clear();
        username.sendKeys(usernameString);

    }
    public void enterPassword(String passwordString) {

        password = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(passwordField));
        password.clear();
        password.sendKeys(passwordString);
    }

    public void clickLoginButton() {

        login = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(loginButton));
        login.click();
    }

    public void enterSpecifiedUsername(String usernameString) {

        username = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(usernameField));
        username.clear();
        username.sendKeys(usernameString);

    }
    public void enterSpecifiedPassword(String passwordString) {

        password = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(passwordField));
        password.clear();
        password.sendKeys(passwordString);
        testUtils.sleep(1000);
    }
}
