package PageObjects;

import java.time.Duration;

import Utilities.testUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StartPage {

    // Webdriver initialization
    private final WebDriver driver;
    public StartPage(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement enterStore;
    private final By enterStoreButton = By.xpath("//a[normalize-space()='Enter the Store']");



    public void clickEnterStore() {

        try {
            enterStore = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(enterStoreButton));
            enterStore.click();
            testUtils.sleep(1000);
        }
        catch (Exception e) {
            System.err.println("Error: enter store button is not visible." + e.getMessage());
        }

    }


}
