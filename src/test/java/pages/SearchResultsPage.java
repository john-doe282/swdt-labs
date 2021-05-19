package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultsPage extends Page {

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void goToPage() {

    }

    @Override
    protected WebElement getNavItem() {
        return null;
    }

    @Override
    public boolean isPageHighlighted() {
        return false;
    }
}
