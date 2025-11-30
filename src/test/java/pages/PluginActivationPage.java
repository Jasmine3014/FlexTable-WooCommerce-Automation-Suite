package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class PluginActivationPage {
    Page page;
    public Locator pluginActivateBtn;
    private Locator pluginMenuBtn;
    private Locator installPluginOption;
    private Locator addPluginOption;
    private Locator pluginSearchBox;
    private Locator flexTableInstallBtn;
    private Locator searchAddPluginBox;
    private Locator flexTablePluginInList;
    private Locator afterInstallPluginActivateBtn;
    private Locator activateFlexTableBtn;

    public PluginActivationPage(Page page) {
        this.page = page;
        pluginMenuBtn = page.locator("//div[@class='wp-menu-name' and contains(text(), 'Plugins')]");
        installPluginOption = page.locator("//li[@class='wp-first-item current']/a[text()='Installed Plugins']");
        addPluginOption = page.locator("//li[@id='menu-plugins']//a[@href='plugin-install.php' and text()='Add Plugin']");
        pluginSearchBox = page.locator("#plugin-search-input");
        searchAddPluginBox = page.locator("//input[@id='search-plugins']");
        pluginActivateBtn = page.locator("//a[@aria-label='Activate FlexTable']");
        afterInstallPluginActivateBtn = page.locator("//a[contains(@aria-label, 'Activate FlexTable')]");
        flexTableInstallBtn = page.locator("//a[contains(@aria-label, 'Install FlexTable')]");
        flexTablePluginInList = page.locator("//h3/a[contains(text(),'FlexTable')]");
        activateFlexTableBtn = page.locator("//a[@id='activate-sheets-to-wp-table-live-sync']");
    }

    public void navigateToInstalledPlugins() {
        pluginMenuBtn.click();
        installPluginOption.waitFor();
        installPluginOption.click();
    }

    public void navigateToAddPlugins() {
        pluginMenuBtn.click();
        addPluginOption.waitFor();
        addPluginOption.click();
    }

    public void inatllPageActivateBtn(){
        activateFlexTableBtn.waitFor();
        activateFlexTableBtn.click();
    }

    public void searchForAddPlugin() {
        searchAddPluginBox.fill("FlexTable");
        searchAddPluginBox.press("Enter");
    }

    public void installFlexTable() {
        flexTableInstallBtn.waitFor();
        flexTableInstallBtn.click();
        afterInstallPluginActivateBtn.waitFor();
        afterInstallPluginActivateBtn.click();
    }

    public void searchForFlexTablePlugin() {
        pluginSearchBox.fill("FlexTable");
        pluginSearchBox.press("Enter");    }

    public boolean isFlexTableInstalled() {
        return flexTablePluginInList.count() > 0;
    }

    public boolean isFlexTableActive() {
        return !pluginActivateBtn.isVisible();
    }
}
