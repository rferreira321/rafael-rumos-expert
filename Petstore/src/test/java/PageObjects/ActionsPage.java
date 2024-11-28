package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ActionsPage {
    private final WebDriver driver;

    private WebElement signIn;
    private WebElement welcomeText;

    private final By signInButton = By.xpath("//a[normalize-space()='Sign In']");
    private final By welcomeTextElement = By.xpath("//*[@id=\"WelcomeContent\"]");


    public ActionsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSignInButton() {

        signIn = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(signInButton));
        signIn.click();
    }

    public String getWelcomeText() {
        welcomeText = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(welcomeTextElement));
        return welcomeText.getText();
    }
}
