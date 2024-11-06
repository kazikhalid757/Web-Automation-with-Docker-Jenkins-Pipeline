package utilis;

import java.io.IOException;

import Reports.PageObjectManage;
import org.openqa.selenium.WebDriver;

import Reports.PageObjectManage;

public class TestContextSetup {

    public WebDriver driver;
    public String landingPageProductName;
    public PageObjectManage pageObjectManager;
    public TestBase testBase;
//	public GenericUtils genericUtils;


    public TestContextSetup() throws IOException, InterruptedException {
        testBase = new TestBase();
        pageObjectManager = new PageObjectManage(testBase.WebDriverManager());
//		genericUtils = new GenericUtils(testBase.WebDriverManager());




    }

}
