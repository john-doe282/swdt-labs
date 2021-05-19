package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InsightsPage extends Page {
    private final String address = "insights";

    public InsightsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void goToPage() {
        super.visitPage(address);
    }

    @Override
    public WebElement getNavItem() {
        return navItem.
                findElement(new By.ByLinkText("Insights"));
    }

    @Override
    public boolean isPageHighlighted() {
        return getNavItem().isSelected();
    }

}
