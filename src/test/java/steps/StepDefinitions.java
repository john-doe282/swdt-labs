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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import pages.*;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class StepDefinitions {

    private final WebDriver driver = new SafariDriver();
    private final PageFactory pageFactory = new PageFactory();
    private Page currentPage;

    @Before
    public void init() {
        driver.manage().window().setPosition(new Point(0,0));
        driver.manage().window().setSize(new Dimension(1440,768));
    }
    @Given("User is connected to the Internet")
    public void user_is_connected_to_the_internet() {
        assert true;
    }


    @When("User opens {string}")
    public void user_opens(String string) {
        driver.get(string);
    }

    @Then("Page title is {string}")
    public void page_title(String string) {
        String title = driver.getTitle();
        assert title.equals(string);
    }

    @After()
    public void closeBrowser() {
        driver.quit();
    }

    @Given("User is on {string}")
    public void userIsOnPage(String pageName) {
        currentPage = pageFactory.createPage(pageName, driver);
        currentPage.goToPage();
    }

    @When("User scrolls {string}")
    public void userScrollsUp(String direction) {
        currentPage.scroll(ScrollDirection.valueOf(direction.toUpperCase(Locale.ROOT)));
    }

    @Then("{string} path is visible")
    public void pagePathIsVisible(String page) {
        WebElement path = currentPage.getPath();
        System.out.println(path.getText());
        assert path.isDisplayed() && path.getText().equalsIgnoreCase(page);
    }

    @Then("Footer is visible")
    public void footerIsVisible() {
        WebElement footer = currentPage.getFooter();
        assert footer.isDisplayed();
    }

    @Then("Menu is visible")
    public void menuIsVisible() {
        WebElement menu = currentPage.getMenu();
        assert menu.isDisplayed();
    }

    @Then("{string} is highlighted in Menu bar")
    public void pageIsHighlightedInMenuBar(String page) {
        WebElement navItem = currentPage.getNavItem();
        assert navItem.isSelected();
    }

    @Then("Search button is visible")
    public void searchButtonIsVisible() {
        WebElement searchButton = currentPage.getSearchButton();
        assert searchButton.isDisplayed();
    }

    @When("User clicks Search button")
    public void userClicksSearchButton() {
        currentPage.clickSearchButton();
    }

    @And("User enters {string}")
    public void userEntersQuery(String query) {
        currentPage = currentPage.search();
    }

    @Then("User is on Results page")
    public void userIsOnResultsCheck() {
        assert currentPage instanceof SearchResultsPage;
    }

    @When("User filters by {string}")
    public void userFiltersByIndustries(String filter) {

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
        assert currentPage.currentLanguage() == Language.RUSSIAN;
    }
}
