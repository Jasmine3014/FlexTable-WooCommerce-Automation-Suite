package tests;

import org.testng.annotations.Test;
import pages.FlexShortCutPage;
import pages.Login_Page;
import pages.VerifyFlexTablePage;
import utils.BaseTest;

public class test05_RenderTableViaShortcodeAndVerifyData extends BaseTest {

    @Test
    public void verifyTableUsingShortcode() {
        Login_Page loginPage = new Login_Page(page);
        loginPage.loginWithValidCredential(USERNAME, PASSWORD);

        VerifyFlexTablePage verifyFlexTablePage = new VerifyFlexTablePage(page);
        verifyFlexTablePage.navigateToFlexTableDashboard();

        FlexShortCutPage flex = new FlexShortCutPage(page);

        String shortcode = flex.getShortcode();
        flex.clickPages();
        flex.clickAddPage();
        flex.pasteShortcodeAsTitle(shortcode);
        flex.publishPage();
        flex.setViewPage();
    }
}
