package pages;

import org.openqa.selenium.WebDriver;

public class PageFactory {
    public Page createPage(String page, WebDriver driver) {
        if (page.equalsIgnoreCase("Insights")) {
            return new InsightsPage(driver);
        }

        if (page.equalsIgnoreCase("Services")) {
            return new ServicesPage(driver);
        }

        if (page.equalsIgnoreCase("About")) {
            return new AboutPage(driver);
        }

        throw new IllegalArgumentException("No such page");
    }
}
