package pages;

import io.cucumber.java.it.Ma;
import org.openqa.selenium.WebDriver;

public class EpamPageFactory {
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

        if (page.equalsIgnoreCase("Main")) {
            return new MainPage(driver);
        }

        throw new IllegalArgumentException("No such page");
    }
}
