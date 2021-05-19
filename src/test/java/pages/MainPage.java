package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends Page {
    private final String address = "";

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void goToPage() {
        super.visitPage(address);
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
