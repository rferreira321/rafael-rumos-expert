package Petstore.steps;

import PageObjects.*;
import Utilities.testUtils;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import Config.BrowserConfig;
import org.testng.Assert;

//import static PageObjects.RegistrationPage.usernameString;



public class PetStoreSteps {

    WebDriver driver;
    StartPage startPage;
    ActionsPage actionsPage;
    SignInPage signInPage;
    RegistrationPage registrationPage;
    SearchResultsPage searchResultsPage;
    CheckoutPage checkoutPage;

    String username = "";
    String password = "";
    String firstName = "";
    String productName = "";


    @Given("I have a Selenium using {string}")
    public void i_have_a_selenium_using(String browser) {
        testUtils.sleep(1000);
        driver = BrowserConfig.openBrowser(browser);
        startPage = new StartPage(driver);
        actionsPage = new ActionsPage(driver);
        signInPage = new SignInPage(driver);
        registrationPage = new RegistrationPage(driver);
        searchResultsPage = new SearchResultsPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }

    @Given("I access the petstore Page")
    public void i_access_the_petstore_page() {
        driver.get("https://petstore.octoperf.com/");
        testUtils.sleep(1000);
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
        testUtils.sleep(1000);
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, "https://petstore.octoperf.com/actions/Catalog.action");
    }

    @Then("I log in with the new user")
    public void i_log_in_with_the_new_user() {
        username = registrationPage.username();
        password = registrationPage.password();
        firstName = registrationPage.firstName();
        signInPage.enterUsername(username);
        signInPage.enterPassword(password);
        i_click_the_log_in_button();
    }


    @Given("I enter my standard credentials")
    public void i_enter_my_standard_credentials() {
        username = "rferreira123";
        password = "automation";
        firstName = "rafa";
        signInPage.enterUsername(username);
        signInPage.enterPassword(password);
    }

    @Given("I enter my purchase credentials")
    public void i_enter_my_purchase_credentials() {
        String purchaseUsername = "purchaseOrder";
        String purchasePassword = "automation";
        firstName = "purchase";
        signInPage.enterUsername(purchaseUsername);
        signInPage.enterPassword(purchasePassword);
    }


    @Then("I click the log in button")
    public void i_click_the_log_in_button() {
        signInPage.clickLoginButton();
    }

    @Then("I see the welcome message")
    public void i_see_the_welcome_message() {
        String expectedMessage = "Welcome " + firstName + "!";
        String actualMessage = actionsPage.getWelcomeText();
        Assert.assertEquals(actualMessage, expectedMessage);

    }

// -------------------------------------------------------------//
    // SEARCH PRODUCT STEPS //


    @Given("I search for a valid {string}")
    public void i_search_for_a_valid(String input) {
        productName = input;
        actionsPage.searchInput(input);
        actionsPage.clickSearchButton();

    }

    @Then("I should see results with the keyword I searched for")
    public void i_should_see_results_with_the_keyword_i_searched_for() {
        searchResultsPage.checkFirstSearchResult(productName);
    }


    // -------------------------------------------------------------//
    // ADD TO CART STEPS //

    @Given("I click the Dogs page")
    public void i_click_the_dogs_page() {
        actionsPage.clickDogsButton();

    }

    @Given("I select an item to buy")
    public void i_select_an_item_to_buy() {
        actionsPage.selectItemToBuy();
    }

    @Given("I click the Add to cart button")
    public void i_click_the_add_to_cart_button() {
        actionsPage.clickAddToCartButton();
    }

    @Then("I should see the Shopping cart page with the item I selected")
    public void i_should_see_the_shopping_cart_page_with_the_item_i_selected() {
        actionsPage.checkShoppingCartWithSelectedItem();
    }

    @Then("I remove the item from the cart")
    public void i_remove_the_item_from_the_cart() {
        actionsPage.clickRemoveButton();
    }



    // -------------------------------------------------------------//
    // FULL PURCHASE STEPS //
    @Then("I click the Proceed to Checkout button")
    public void i_click_the_proceed_to_checkout_button() {
        actionsPage.clickProceedToCheckoutButton();
    }

    @Then("I click the confirm button")
    public void i_click_the_confirm_button() {
        checkoutPage.clickConfirmButton();
    }

    @Then("I click the continue button")
    public void i_click_the_continue_button() {
        checkoutPage.clickContinueButton();
    }

    @Then("I should see the order confirmation page with the item I purchased")
    public void i_should_see_the_order_confirmation_page_with_the_item_i_purchased() {
        checkoutPage.confirmPurchase();
    }




    @After
    public void close() {
        BrowserConfig.closeBrowser(driver);
    }

}
