package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class VerifyFlexTablePage {
    Page page;

    private Locator flexTableMenu;
    private Locator dashboardHeader;

    public VerifyFlexTablePage(Page page) {
        this.page = page;

        flexTableMenu = page.locator("//div[@class='wp-menu-name' and text()='FlexTable']");
        dashboardHeader = page.locator("//h2[contains(text(),' Welcome!')]");
    }

    public void navigateToFlexTableDashboard() {
        flexTableMenu.click();
        flexTableMenu.waitFor();
    }

    public boolean isDashboardVisible() {
        dashboardHeader.waitFor();
        return dashboardHeader.isVisible();
    }
}
