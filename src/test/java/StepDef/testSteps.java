package StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import HomePage.Homepage;
import Reports.PageObjectManage;
import utilis.TestContextSetup;



public class testSteps {
    TestContextSetup testContextSetup;
    Homepage homepage;
    PageObjectManage pageObjectManage;
    public testSteps(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        this.homepage = testContextSetup.pageObjectManager.getHomePage();
    }


    @Given("User Click on Bikroy logo")
    public void UserClickOnBikroyLogo() throws InterruptedException {
        Thread.sleep(2000);

        Assert.assertTrue(homepage.getSearchIcon().isDisplayed());
        homepage.getSearchIcon().click();




    }


    @Given("Check Mobiles button is available in Category item section")
    public void checkMobilesButtonIsAvailableInCategoryItemSection() throws InterruptedException {

        homepage.getMobile().isDisplayed();
        Thread.sleep(1000);
    }

    @When("Click on Mobiles button")
    public void clickOnMobilesButton() throws InterruptedException {
        homepage.getMobile().click();
        Thread.sleep(1000);
        
    }

    @Then("Check Mobile page is Displayed")
    public void checkMobilePageIsDisplayed() throws InterruptedException {

        homepage.selectLocation().isDisplayed();
        Thread.sleep(1000);

    }

    @And("Check Select Location button is available")
    public void checkSelectLocationButtonIsAvailable() {
        homepage.selectLocation().isDisplayed();
    }

    @When("Click Select Location button")
    public void clickSelectLocationButton() throws InterruptedException {
        homepage.selectLocation().click();
        Thread.sleep(1000);
    }

    @Then("Check a Popup window displayed")
    public void checkAPopupWindowDisplayed() throws InterruptedException {
        homepage.Dhaka().isDisplayed();
        Thread.sleep(1000);

    }

    @And("Check Dhaka is available in Cities category")
    public void checkDhakaIsAvailableInCitiesCategory() {
        homepage.Dhaka().isDisplayed();
    }

    @When("Click on Dhaka city")
    public void clickOnDhakaCity() throws InterruptedException {
        homepage.Dhaka().click();
        Thread.sleep(1000);
    }

    @Then("Check Popular areas in Dhaka city are available")
    public void checkPopularAreasInDhakaCityAreAvailable() throws InterruptedException {
        homepage.Mirpur().isDisplayed();
        Thread.sleep(1000);
    }

    @When("Click Mirpur area")
    public void clickMirpurArea() {
        homepage.Mirpur().click();
    }

    @Then("Check that all mobiles in Mirpur area are displayed")
    public void checkThatAllMobilesInMirpurAreaAreDisplayed() throws InterruptedException {
        homepage.topProduct().isDisplayed();
        Thread.sleep(1000);
    }

    @When("Click on a mobile top in the list")
    public void clickOnAMobileTopInTheList() {
        homepage.topProduct().click();
    }

    @Then("Check mobile Details page is displayed")
    public void checkMobileDetailsPageIsDisplayed() throws InterruptedException {
        homepage.ProductDetails().isDisplayed();
        Thread.sleep(1000);

    }

    @Given("Check the Searchbar is available")
    public void checkTheSearchboxIsAvailable() {
        homepage.Search().isDisplayed();

    }

    @When("Click on Search box")
    public void clickOnSearchBox() {
        homepage.Search().click();
    }

    @And("Input {string} in The Search box")
    public void inputValueInTheSearchBox(String text) {
        homepage.Search().sendKeys(text);
    }

    @Then("Check a page displayed")
    public void checkAPageDisplayed() {
        homepage.MobilesSearch().isDisplayed();
    }

    @And("Check next button is available")
    public void checkNextButtonIsAvailable() {
        homepage.Next().isDisplayed();
    }

    @When("Chick on Next button")
    public void chickOnNextButton() {
        homepage.Next().click();
    }

    @Then("check the Previous button is active")
    public void checkThePreviousButtonIsActive() {
        homepage.Previous().isDisplayed();
    }

    @When("Click on Previous button")
    public void clickOnPreviousButton() {
        homepage.Previous().click();
    }

    @Then("Check the main page displayed")
    public void checkTheMainPageDisplayed() {
        homepage.Search().isDisplayed();
    }

}
