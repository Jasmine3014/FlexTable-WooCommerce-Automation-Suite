package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.BaseTest;

public class test06_LayoutOption_TitleAndDescription extends BaseTest {

    @Test
    public void LayoutOption_TitleAndDescription() {
        Login_Page loginPage = new Login_Page(page);
        loginPage.loginWithValidCredential(USERNAME, PASSWORD);

        VerifyFlexTablePage verifyFlexTablePage = new VerifyFlexTablePage(page);
        verifyFlexTablePage.navigateToFlexTableDashboard();

        VerifyTitleDescLayout verifyTitleDescLayout = new VerifyTitleDescLayout(page);
        verifyTitleDescLayout.clickEditTableBtn();
        verifyTitleDescLayout.clickTablecustom();
        verifyTitleDescLayout.enableTitle_Des();
        verifyFlexTablePage.navigateToFlexTableDashboard();

        FlexShortCutPage flex = new FlexShortCutPage(page);
        flex.clickPages();

        verifyTitleDescLayout.clickViewBtn();
        Assert.assertTrue(
                verifyTitleDescLayout.isTableNameContains("Test Table"), "Table name does NOT contain 'test'"
        );
        Assert.assertTrue(
                verifyTitleDescLayout.isDescriptionContains("Test data"), "Table Description name does NOT contain"
        );


    }
    }

