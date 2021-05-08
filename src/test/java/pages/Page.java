package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    Page(WebDriver driver) {
        this.driver = driver;
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
        List<WebElement> elements = driver.
                findElements(By.className("breadcrumbs__link"));
        return elements.get(elements.size() - 1);
    }

    public WebElement getFooter() {
        return driver.findElement(By.className("footer-ui"));
    }

    public WebElement getMenu() {
        return driver.findElement(By.className("header-ui"));
    }

    public WebElement getNavItem() {
        return driver.findElement(By.className("top-navigation__row"));
    }

    public WebElement getSearchButton() {
        return driver.findElement(By.className("header-search__button"));
    }

    public void clickSearchButton() {
        WebElement searchButton = getSearchButton();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(searchButton));
        searchButton.click();
    }
    public Page search() {
        WebElement searchField = driver.
                findElement(By.id("new_form_search"));
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(searchField));

        searchField.sendKeys("Content");
        wait.until(ExpectedConditions.elementToBeClickable(searchField));

        WebElement submitButton = driver.findElement(By.className("header-search__submit"));

        wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        submitButton.submit();
        String url = driver.getCurrentUrl();
//        wait.until(ExpectedConditions.titleIs("Search"));
//        String title = driver.getTitle();
        if (driver.getTitle().equalsIgnoreCase("Search")) {
            System.out.println("here");
            return new SearchResultsPage(driver);
        }
        System.out.println(driver.getTitle());
        return null;
    }

    public WebElement getLanguageButton() {
        return driver.findElement(By.className("location-selector__button"));
    }
    public void clickLanguageButton() {
        WebElement languageButton = getLanguageButton();
        String text = languageButton.getText();
        String tagName = languageButton.getTagName();
        boolean displayed = languageButton.isDisplayed();
        boolean selected = languageButton.isSelected();
        languageButton.click();
    }

    public void changeToRussian() {
        driver.findElement(By.partialLinkText("Россия")).click();
    }

    public Language currentLanguage() {
        String language = getLanguageButton().getText().split(" ")[0];
        if (language.equalsIgnoreCase("россия")){
            return Language.RUSSIAN;
        }
        if (language.equalsIgnoreCase("english")){
            return Language.ENGLISH;
        }
        return null;
    }
}
