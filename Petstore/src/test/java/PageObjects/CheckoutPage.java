package PageObjects;

import Utilities.testUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class CheckoutPage {

    // Webdriver initialization
    private final WebDriver driver;
    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    // I created this method to simplify the element grabing process with timeout and expected conditions. It makes the code easier to read =)
    public WebElement grabElement(By elementField) {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(elementField));
    }

    private WebElement creditCardNumber;
    private WebElement expiryDate;
    private WebElement continueButton;
    private WebElement confirmButton;
    private WebElement confirmationText;
    private WebElement boughtItem;

    private final By creditCardNumberField = By.name("order.creditCard");
    private final By expiryDateField = By.name("order.expiryDate");
    private final By continueButtonElement = By.name("newOrder");
    private final By confirmButtonElement = By.xpath("//a[normalize-space()='Confirm']");
    private final By confirmationTextElement = By.xpath("//li[normalize-space()='Thank you, your order has been submitted.']");
    private final By boughtItemElement = By.xpath("//td[contains(text(),'Adult Female')]");


    public void clickContinueButton() {
        continueButton = grabElement(continueButtonElement);
        continueButton.click();
        testUtils.sleep(1000);
    }

    public void clickConfirmButton() {
        confirmButton = grabElement(confirmButtonElement);
        confirmButton.click();
        testUtils.sleep(1000);
    }

    public void confirmPurchase(){
        confirmationText = grabElement(confirmationTextElement);
        boughtItem = grabElement(boughtItemElement);

        Assert.assertTrue(boughtItem.isDisplayed());
        Assert.assertTrue(confirmationText.isDisplayed());
    }

}
