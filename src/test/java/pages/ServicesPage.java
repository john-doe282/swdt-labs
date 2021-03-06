package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ServicesPage extends Page {
    private final String address = "services";

    public ServicesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void goToPage() {
        super.visitPage(address);
    }

    @Override
    protected WebElement getNavItem() {
        return navItem.
                findElement(new By.ByLinkText("Services"));
    }

    @Override
    public boolean isPageHighlighted() {
        return getNavItem().isSelected();
    }
}
