package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Locale;

class UrlHelper {
    public static String makeUrl(String base, String page) {
        page = page.toLowerCase(Locale.ROOT);
        page = page.replaceAll(" ", "-");
        return base + page;
    }
}

public abstract class Page {
    private final WebDriver driver;

    @FindBy(xpath = "//*[contains(@class, 'breadcrumbs__link')]")
    protected List<WebElement> path;

    @FindBy(xpath = "//*[contains(@class, 'footer-ui')]")
    protected WebElement footer;

    @FindBy(xpath = "//*[contains(@class, 'header-ui')]")
    protected WebElement menu;

    @FindBy(xpath = "//*[contains(@class, 'top-navigation__row')]")
    protected WebElement navItem;

    @FindBy(xpath = "//*[contains(@class, 'header-search__button')]")
    protected WebElement searchButton;

    @FindBy(xpath = "//*[contains(@id, 'new_form_search')]")
    protected WebElement searchField;

    @FindBy(xpath = "//*[contains(@class, 'header-search__submit')]")
    protected WebElement submitButton;

    @FindBy(xpath = "//*[contains(@class, 'location-selector__button')]")
    protected WebElement languageButton;

    Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected void visitPage(String address) {
        String url = UrlHelper.makeUrl("https://www.epam.com/", address);
        driver.get(url);
    }

    public abstract void goToPage();

    public void scroll(ScrollDirection direction) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        if (direction == ScrollDirection.UP) {
            jsExecutor.executeScript("window." +
                    "scrollTo(0, -document.body.scrollHeight);");
        } else if (direction == ScrollDirection.DOWN) {
            jsExecutor.executeScript("window." +
                    "scrollTo(0, document.body.scrollHeight);");
        }
    }

    public WebElement getPath() {
        return path.get(path.size() - 1);
    }

    public boolean isPathVisible(String page) {
        return getPath().getText().equalsIgnoreCase(page);
    }

    public boolean isFooterVisible() {
        return footer.isDisplayed();
    }

    public boolean isMenuVisible() {
        return menu.isDisplayed();
    }

    protected abstract WebElement getNavItem();

    public abstract boolean isPageHighlighted();

    public boolean isSearchButtonVisible() {
        return searchButton.isDisplayed();
    }

    public void clickSearchButton() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(searchButton));
        searchButton.click();
    }

    public Page search(String query) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(searchField));

        searchField.sendKeys(query);

        wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        submitButton.submit();

        if (driver.getTitle().equalsIgnoreCase("Search")) {
            return new SearchResultsPage(driver);
        }
        return null;
    }


    public void clickLanguageButton() {
        languageButton.click();
    }

    public void changeToRussian() {
        driver.findElement(By.partialLinkText("Россия")).click();
    }

    public Language currentLanguage() {
        String language = languageButton.getText().split(" ")[0];
        if (language.equalsIgnoreCase("россия")){
            return Language.RUSSIAN;
        }
        if (language.equalsIgnoreCase("english")){
            return Language.ENGLISH;
        }
        return null;
    }

    public boolean titleEqualsTo(String title) {
        return driver.getTitle().equalsIgnoreCase(title);
    }

    public boolean isLanguageRussian() {
        return currentLanguage() == Language.RUSSIAN;
    }

    public boolean isSearchResults() {
        return this instanceof SearchResultsPage;
    }
}
