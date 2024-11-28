package Config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;


public class BrowserConfig {

    public static WebDriver driver;

    public static WebDriver openBrowser(String browser) {

        switch (browser.toLowerCase()) {
            case "chrome":

                WebDriverManager.chromedriver().setup();

                driver = new ChromeDriver();
                break;
            case "firefox":

                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":

                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        return driver;

    }

    public static void closeBrowser(WebDriver driver) {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}