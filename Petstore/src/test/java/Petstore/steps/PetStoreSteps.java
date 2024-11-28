package Petstore.steps;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import Config.BrowserConfig;
import PageObjects.StartPage;
import PageObjects.ActionsPage;
import PageObjects.SignInPage;
import PageObjects.RegistrationPage;
import org.testng.Assert;


public class PetStoreSteps {

    WebDriver driver;
    StartPage startPage;
    ActionsPage actionsPage;
    SignInPage signInPage;
    RegistrationPage registrationPage;


    @Given("I have a Selenium using {string}")
    public void i_have_a_selenium_using(String browser) {
        driver = BrowserConfig.openBrowser(browser);
        startPage = new StartPage(driver);
        actionsPage = new ActionsPage(driver);
        signInPage = new SignInPage(driver);
        registrationPage = new RegistrationPage(driver);
    }

    @Given("I access the petstore Page")
    public void i_access_the_petstore_page() {
        driver.get("https://petstore.octoperf.com/"); // Abre a URL do Google Maps
        startPage.clickEnterStore();
    }

    @Given("I click the Sign In button")
    public void i_click_the_sign_in_button() {
        actionsPage.clickSignInButton();
    }

    @Given("I click the register button")
    public void i_click_the_register_button() {
        signInPage.clickRegisterButton();
    }

    @Given("I fill all the necessary fields")
    public void i_fill_all_the_necessary_fields() {
        registrationPage.fillAllFields();

    }


    @Given("I click the save button")
    public void i_click_the_save_button() {

        registrationPage.clickOnSaveButton();

    }

    @Then("I see the actions page")
    public void i_see_the_actions_page() {
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, "https://petstore.octoperf.com/actions/Catalog.action");
    }
    @Then("I enter my credentials")
    public void i_enter_my_credentials() {
        i_click_the_sign_in_button();
        signInPage.enterUsername(registrationPage.username());
        signInPage.enterPassword(registrationPage.password());
    }
    @Then("I click the log in button")
    public void i_click_the_log_in_button() {
        signInPage.clickLoginButton();
    }
    @Then("I see the welcome message")
    public void i_see_the_welcome_message() {
        String expectedMessage = "Welcome " + registrationPage.firstName() + "!";
        String actualMessage = actionsPage.getWelcomeText();
        Assert.assertEquals(actualMessage, expectedMessage);

    }

    @After
    public void close() {
        BrowserConfig.closeBrowser(driver);
    }

}
