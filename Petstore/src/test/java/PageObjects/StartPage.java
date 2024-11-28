package PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StartPage {

    private final WebDriver driver;

    private WebElement enterStore;

    private final By enterStoreButton = By.xpath("//a[normalize-space()='Enter the Store']");

    public StartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickEnterStore() {

        enterStore = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(enterStoreButton));
        enterStore.click();
    }


}
