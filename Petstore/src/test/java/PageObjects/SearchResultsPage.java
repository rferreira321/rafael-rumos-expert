package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class SearchResultsPage {


    // Webdriver initialization
    private final WebDriver driver;
    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    // I created this method to simplify the element grabing process with timeout and expected conditions. It makes the code easier to read =)
    public WebElement grabElement(By elementField) {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(elementField));
    }

    private WebElement searchResultsName;

    private final By searchResultsNameField = By.xpath("//td[normalize-space()='Golden Retriever']");

    public void checkFirstSearchResult(String keyword) {
        searchResultsName = grabElement(searchResultsNameField);
        String productName = searchResultsName.getText().toLowerCase();
        Assert.assertTrue(productName.contains(keyword.toLowerCase()));

    }


}
