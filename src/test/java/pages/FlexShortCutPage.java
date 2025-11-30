package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

public class FlexShortCutPage {
    Page page;
    private Locator shortCutBtn;
    private Locator pagesBtn;
    private Locator addPage;
    private Locator closeModalBtn;
    private Locator pageTitle;
    private Locator pageInput;
    private Locator publisButton;
    private Locator confirmPublishButton;
    private Locator viewPageBtn;

    public FlexShortCutPage(Page page) {
        this.page = page;
        shortCutBtn = page.locator("//button[@class='copy-shortcode btn-shortcode ']");
        pagesBtn = page.locator("//div[@class='wp-menu-name' and text()='Pages']");
        addPage = page.locator("//a[@href='post-new.php?post_type=page' and text()='Add Page']");
        closeModalBtn = page.locator("//button[@aria-label='Close']");
        pageTitle = page.locator("h1[aria-label='Add title']");
        pageInput = page.locator("//p[@contenteditable=\"true\" and contains(@class,\"rich-text\")]");
        publisButton = page.locator("//button[normalize-space()='Publish']");
        confirmPublishButton = page.locator("//button[@class='components-button editor-post-publish-button editor-post-publish-button__button is-primary is-compact']");
        viewPageBtn= page.locator("//div[@class='post-publish-panel__postpublish-buttons']");
    }

    public String getShortcode() {
        shortCutBtn.click();
        shortCutBtn.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.ATTACHED));
        return shortCutBtn.textContent().trim();
    }

    public void clickPages() {
        pagesBtn.click();
    }

    public void clickAddPage() {
        addPage.click();
        closeModalBtn.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
        closeModalBtn.click();
    }

    public void pasteShortcodeAsTitle(String shortcode) {
        pageTitle.click();
        pageTitle.fill("Test Table");
        pageInput.click();
        pageInput.type(shortcode);
    }

    public void publishPage() {
        publisButton.click();
        confirmPublishButton.click();

    }
    public void setViewPage() {
        viewPageBtn.click();
    }
}
