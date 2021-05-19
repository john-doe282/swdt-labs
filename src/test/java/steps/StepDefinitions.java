package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import pages.*;

import java.util.Locale;

public class StepDefinitions {

    private final WebDriver driver = new SafariDriver();
    private final EpamPageFactory epamPageFactory = new EpamPageFactory();
    private Page currentPage;

    @Before
    public void init() {
        driver.manage().window().setPosition(new Point(0,0));
        driver.manage().window().setSize(new Dimension(1440,768));
    }

    @Given("User is connected to the Internet")
    public void userIsConnectedToInternet() {
        assert true;
    }

    @Then("Page title is {string}")
    public void pageTitle(String title) {
        assert currentPage.titleEqualsTo(title);
    }

    @After()
    public void closeBrowser() {
        driver.quit();
    }

    @Given("User is on {string}")
    public void userIsOnPage(String pageName) {
        currentPage = epamPageFactory.createPage(pageName, driver);
        currentPage.goToPage();
    }

    @When("User scrolls {string}")
    public void userScrollsUp(String direction) {
        currentPage.scroll(ScrollDirection.
                valueOf(direction.toUpperCase(Locale.ROOT)));
    }

    @Then("{string} path is visible")
    public void pagePathIsVisible(String page) {
        assert currentPage.isPathVisible(page);
    }

    @Then("Footer is visible")
    public void footerIsVisible() {
        assert currentPage.isFooterVisible();
    }

    @Then("Menu is visible")
    public void menuIsVisible() {
        assert currentPage.isMenuVisible();
    }

    @Then("{string} is highlighted in Menu bar")
    public void pageIsHighlightedInMenuBar(String page) {
        assert currentPage.isPageHighlighted();
    }

    @Then("Search button is visible")
    public void searchButtonIsVisible() {
        assert currentPage.isSearchButtonVisible();
    }

    @When("User clicks Search button")
    public void userClicksSearchButton() {
        currentPage.clickSearchButton();
    }

    @And("User enters {string}")
    public void userEntersQuery(String query) {
        currentPage = currentPage.search(query);
    }

    @Then("User is on Results page")
    public void userIsOnResultsCheck() {
        assert currentPage.isSearchResults();
    }

    @When("User clicks language button")
    public void userClicksLanguageButton() {
        currentPage.clickLanguageButton();
    }

    @And("User chooses Russian language")
    public void userChoosesRussianLanguage() {
        currentPage.changeToRussian();
    }

    @Then("{string} language is set to Russian")
    public void pageLanguageIsSetToRussian(String page) {
        assert currentPage.isLanguageRussian();
    }
}
