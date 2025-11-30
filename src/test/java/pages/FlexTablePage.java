package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class FlexTablePage {
    Page page;

    private Locator createNewTableBtn;
    private Locator sheetUrlInput;
    private Locator createTableFromUrlBtn;
    private Locator tableTitleInput;
    private Locator tableDescriptionInput;
    private Locator fetchAndSaveBtn;
    private Locator editButton;
    private Locator tableName;

    public FlexTablePage(Page page) {
        this.page = page;
        createNewTableBtn = page.locator("//button[@class='btn btn-lg' and text()='Create new table']");
        sheetUrlInput = page.locator("#sheet-url");
        createTableFromUrlBtn = page.locator("//div[@class='create-table-btn-wrapper']//button[text()='Create table from URL']");
        tableTitleInput = page.locator("//input[@id='table-name']");
        tableDescriptionInput = page.locator("//textarea[@id='table-description']");
        fetchAndSaveBtn = page.locator("//button[@class='table-action__save' and text()='Save changes']");
        tableName = page.locator("a[class='table-edit'] h4[class='swptls-title h4']");
    }

    public void createTable() {
        createNewTableBtn.click();
    }

    public void createTableFromUrl() {
        sheetUrlInput.fill("https://docs.google.com/spreadsheets/d/11qRH9xUuglOTIZa7JnWTVBYuGMT32ZhFuJ5_xypApGM/edit?gid=0#gid=0");
        createTableFromUrlBtn.click();
        createTableFromUrlBtn.waitFor();
    }

    public boolean isTableNameContains(String text) {
        return tableName.innerText().toLowerCase().contains(text.toLowerCase());
    }


    public void fillTitleAndDescriptionAndSave() {
        tableTitleInput.waitFor();
        tableTitleInput.clear();
        tableTitleInput.fill("Test table");
        tableDescriptionInput.fill("Test data");
        fetchAndSaveBtn.click();
    }

}
