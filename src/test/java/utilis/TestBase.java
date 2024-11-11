package utilis;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Properties;

public class TestBase {

    private WebDriver driver;
    private String browserName = null;

    // Determine the browser from the scenario tag or properties
    public void determineBrowser(String tag) {
        // Check tags to determine if specific browser is requested
        if (tag != null) {
            if (tag.equalsIgnoreCase("@chrome")) {
                browserName = "chrome";
                System.out.println("Running on Chrome as per tag.");
            } else if (tag.equalsIgnoreCase("@firefox")) {
                browserName = "firefox";
                System.out.println("Running on Firefox as per tag.");
            }
        }

        // If no tag-based browser was found, use properties
        if (browserName == null) {
            try {
                FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/global.properties");
                Properties prop = new Properties();
                prop.load(fis);
                browserName = System.getProperty("browser", prop.getProperty("browser", "chrome"));
                System.out.println("No tag found; using browser from properties: " + browserName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Browser determined from tag: " + browserName);
        }
    }

    public WebDriver webDriverManager() throws IOException, InterruptedException {
        if (driver == null) {
            determineBrowser(System.getProperty("browser"));

            // Initialize WebDriver based on the browser
            if (browserName.equalsIgnoreCase("firefox")) {
                // Set up Firefox
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions options = new FirefoxOptions();
                options.setHeadless(true);  // Run headless if desired
                driver = new FirefoxDriver(options);
            } else if (browserName.equalsIgnoreCase("chrome")) {
                // Set up Chrome
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless");  // Run headless if desired
                driver = new  ChromeDriver(options);
            }

            assert driver != null;
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.manage().window().maximize();

            // Load URL from properties file
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/global.properties");
            Properties prop = new Properties();
            prop.load(fis);
            String url = prop.getProperty("QAUrl");

            driver.get(url);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
            wait.until(ExpectedConditions.urlToBe(url));
        }
        return driver;
    }

    public void closeWebDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
