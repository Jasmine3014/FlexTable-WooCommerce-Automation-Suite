package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class VerifyTitleDescLayout {
    Page page;
    Locator editTableBtn;
    Locator tableCutomization;
    Locator tableTitle;
    Locator tableDescription;
    Locator saveChangesBtn;
    Locator viewBtn;
    Locator title;
    Locator description;
    Locator hoverbtn;

    public VerifyTitleDescLayout(Page page) {
        this.page = page;
        editTableBtn = page.locator("//div[@class='tooltip-wrapper']//a[@class='table-edit']");
        tableCutomization = page.locator("//span[normalize-space()='3. Table customization']");
        tableTitle = page.locator("//input[@id='show-title']");
        tableDescription = page.locator("//input[@id='show-description']");
        saveChangesBtn = page.locator("//button[normalize-space()='Save changes']");
        hoverbtn= page.locator("//td[@class='title column-title has-row-actions column-primary page-title']");
        viewBtn = page.locator("//span[contains(@class,\"view\")]/a[normalize-space(text())=\"View\"]");
        title = page.locator("//h3[@id='swptls-table-title']");
        description = page.locator("//p[@id='swptls-table-description']");
    }

    public void clickEditTableBtn() {
        editTableBtn.click();
    }

    public void clickTablecustom() {
        tableCutomization.click();
    }
    public  void enableTitle_Des() {
        tableTitle.click();
        tableDescription.click();
        saveChangesBtn.click();
    }

    public void clickViewBtn() {
        hoverbtn.hover();
        viewBtn.click();
    }

    public boolean isTableNameContains(String text) {
        return title.innerText().toLowerCase().contains(text.toLowerCase());
    }

    public boolean isDescriptionContains(String text) {
        return description.innerText().toLowerCase().contains(text.toLowerCase());
    }

}
