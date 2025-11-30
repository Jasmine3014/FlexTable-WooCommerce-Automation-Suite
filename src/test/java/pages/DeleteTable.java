package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class DeleteTable {
    Page page;
    Locator deleteTableBtn;
    Locator confirmDelete;
    Locator errorMsg;
    Locator table;

    public DeleteTable (Page page) {
        this.page= page;
        deleteTableBtn = page.locator("//button[@class='table-delete']");
        errorMsg = page.locator("//b[contains(text(),'Table maybe deleted or can’t be loaded.')]");
        confirmDelete = page.locator("//button[normalize-space()='Delete']");
        table = page.locator("create_tables_wrapper");
    }

    public void clickOnDeleteTable() {
        deleteTableBtn.click();
        confirmDelete.click();
    }

    public boolean iTablePresent() {
        return table.isVisible();
    }

    public boolean checkErrorMsg() {
        errorMsg.waitFor();
        return errorMsg.isVisible();
    }
}
