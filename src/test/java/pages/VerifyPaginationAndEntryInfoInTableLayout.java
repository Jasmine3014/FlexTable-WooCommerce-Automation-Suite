package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class VerifyPaginationAndEntryInfoInTableLayout {
    Page page;
    Locator entryInfoBtn;
    Locator paginationBtn;
    Locator saveChangesBtn;
    Locator paginationBox;

    public VerifyPaginationAndEntryInfoInTableLayout(Page page) {
        this.page = page;
        entryInfoBtn = page.locator("//input[@id='hide-entry-info']");
        paginationBtn = page.locator("//input[@id='hide-pagination']");
        saveChangesBtn = page.locator("//button[normalize-space()='Save changes']");
        paginationBox = page.locator("//div[@id='create_tables_paginate']");
    }

    public void enableTableBottomsElements() {
        entryInfoBtn.click();
        paginationBtn.click();
        saveChangesBtn.click();
    }

    public void assertPaginationPresent() {
        assertThat(paginationBox).isVisible();
    }

}
