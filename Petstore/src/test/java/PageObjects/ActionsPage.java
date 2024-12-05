package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import Utilities.testUtils;

public class ActionsPage {

    // Webdriver initialization
    private final WebDriver driver;
    public ActionsPage(WebDriver driver) {
        this.driver = driver;
    }

    // I created this method to simplify the element grabing process with timeout and expected conditions. It makes the code easier to read =)
    public WebElement grabElement(By elementField) {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(elementField));
    }

    private WebElement signIn;
    private WebElement welcomeText;
    private WebElement searchBar;
    private WebElement searchBarButton;
    private WebElement dogsButton;
    private WebElement itemToBuy;
    private WebElement addToCart;
    private WebElement shoppingCartText;
    private WebElement removeButton;
    private WebElement proceedToCheckout;


    private final By signInButton = By.xpath("//a[normalize-space()='Sign In']");
    private final By welcomeTextElement = By.xpath("//*[@id=\"WelcomeContent\"]");
    private final By searchBarField = By.name("keyword");
    private final By searchBarButtonElement = By.name("searchProducts");
    private final By dogsButtonElement = By.xpath("//img[@src='../images/sm_dogs.gif']");
    private final By itemToBuyElement = By.xpath("//a[normalize-space()='K9-RT-01']");
    private final By addToCartButton = By.xpath("//a[normalize-space()='Add to Cart']");
    private final By shoppingCartTextElement = By.xpath("//h2[normalize-space()='Shopping Cart']");
    private final By removeButtonElement = By.xpath("//a[normalize-space()='Remove']");
    private final By proceedToCheckoutButton = By.xpath("//a[normalize-space()='Proceed to Checkout']");



    public void clickSignInButton() {

        signIn = grabElement(signInButton);
        signIn.click();
        testUtils.sleep(1000);
    }

    public String getWelcomeText() {
        welcomeText = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(welcomeTextElement));
        return welcomeText.getText();
    }

    public void searchInput(String words) {
        searchBar = grabElement(searchBarField);
        searchBar.sendKeys(words);
        testUtils.sleep(1000);
    }

    public void clickSearchButton() {
        searchBarButton = grabElement(searchBarButtonElement);
        searchBarButton.click();
        testUtils.sleep(1000);
    }

    public void clickDogsButton() {
        dogsButton = grabElement(dogsButtonElement);
        dogsButton.click();
        testUtils.sleep(1000);
    }

    public void selectItemToBuy() {
        itemToBuy = grabElement(itemToBuyElement);
        itemToBuy.click();
        testUtils.sleep(1000);
    }

    public void clickAddToCartButton(){
        addToCart = grabElement(addToCartButton);
        addToCart.click();
        testUtils.sleep(1000);
    }

    public void checkShoppingCartWithSelectedItem(){
        shoppingCartText = grabElement(shoppingCartTextElement);
        Assert.assertEquals(shoppingCartText.getText(), "Shopping Cart");
        testUtils.sleep(1000);
    }

    public void clickRemoveButton() {
        removeButton = grabElement(removeButtonElement);
        removeButton.click();
        testUtils.sleep(1000);
    }

    public void clickProceedToCheckoutButton() {
        proceedToCheckout = grabElement(proceedToCheckoutButton);
        proceedToCheckout.click();
        testUtils.sleep(1000);
    }

}
