package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class VerifyRowAndTableHeight {
    Page page;
    Locator styling_btn;
    Locator rowsPerPageDropdown;
    Locator tableHeightDropdown;
    Locator saveChangesBtn;
    Locator frontendTableRow;

    public VerifyRowAndTableHeight(Page page) {
        this.page = page;
        styling_btn = page.locator("//button[normalize-space()='Styling']");
        rowsPerPageDropdown = page.locator("//select[@id='rows-per-page']");
        tableHeightDropdown = page.locator("//select[@id='table_height']");
        saveChangesBtn = page.locator("//button[normalize-space()='Save changes']");
        frontendTableRow = page.locator("//select[@name='create_tables_length']");
    }

    public void clickOnStylingBtn() {
        styling_btn.click();
    }

    public void selectRowsPerPage5() {
        rowsPerPageDropdown.selectOption("5");
    }

    public void selectTableHeight() {
        tableHeightDropdown.selectOption("600px");
    }

    public void setSaveChangesBtn() {
        saveChangesBtn.click();
    }

    public boolean isFrontendRowsFive() {
        String frontendValue = frontendTableRow.locator("option:checked").getAttribute("value");
        return frontendValue.equals("5");
    }


}
