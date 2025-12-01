package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class VerifyOrderHistory {
    Page page;
    Locator myAccount;
    Locator orders;
    Locator viewOrder;

    public VerifyOrderHistory(Page page) {
        this.page = page;
        myAccount = page.locator("//a[normalize-space()='My account']");
        orders = page.locator("//a[normalize-space()='Orders']");
        viewOrder = page.locator("//a[@aria-label='View order 78']");
    }

    public  void clickOnMyAccount() {
        myAccount.click();
    }

    public  void  clickOnOrders() {
        orders.click();
    }
    public  void ClickOnViewOrder() {
        viewOrder.click();
    }
}
