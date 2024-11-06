package utilis;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestBase {

    public WebDriver driver;

    public WebDriver WebDriverManager() throws IOException, InterruptedException {
        if (driver == null) {
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/global.properties");
            Properties prop = new Properties();
            prop.load(fis);
            String url = prop.getProperty("QAUrl");
            String browser = System.getProperty("browser", prop.getProperty("browser", "chrome"));

            if (browser.equalsIgnoreCase("firefox")) {
                String driverPath = System.getProperty("user.dir") + "/src/test/resources/geckodriver";
                System.setProperty("webdriver.gecko.driver", driverPath);

                FirefoxOptions options = new FirefoxOptions();
                String firefoxBinaryPath = "/usr/bin/firefox"; // Set the correct Firefox binary path
                options.setBinary(new FirefoxBinary(new File(firefoxBinaryPath)));

                driver = new FirefoxDriver(options);
            } else {
                throw new IllegalArgumentException("Unsupported browser: " + browser);
            }

            assert driver != null;
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.manage().window().maximize();
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
