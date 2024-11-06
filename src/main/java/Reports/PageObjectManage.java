package Reports;

import org.openqa.selenium.WebDriver;
import HomePage.Homepage;

public class PageObjectManage {
    public static WebDriver driver;

    public Homepage homepage;

    public PageObjectManage(WebDriver driver) {
        this.driver = driver;
    }

    public Homepage getHomePage() {
        homepage = new Homepage(driver);

        return homepage;
    }
}
