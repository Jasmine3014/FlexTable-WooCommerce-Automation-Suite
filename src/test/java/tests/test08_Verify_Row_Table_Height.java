package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.BaseTest;

public class test08_Verify_Row_Table_Height extends BaseTest {

    @Test
    public void Verify_Row_Table_Height() {
        Login_Page loginPage = new Login_Page(page);
        loginPage.loginWithValidCredential(USERNAME, PASSWORD);

        VerifyFlexTablePage verifyFlexTablePage = new VerifyFlexTablePage(page);
        verifyFlexTablePage.navigateToFlexTableDashboard();

        VerifyTitleDescLayout verifyTitleDescLayout = new VerifyTitleDescLayout(page);
        verifyTitleDescLayout.clickEditTableBtn();
        verifyTitleDescLayout.clickTablecustom();

        VerifyRowAndTableHeight verify = new VerifyRowAndTableHeight(page);
        verify.clickOnStylingBtn();
        verify.selectRowsPerPage5();
        verify.selectTableHeight();
        verify.setSaveChangesBtn();

        FlexShortCutPage flex = new FlexShortCutPage(page);
        flex.clickPages();
        verifyTitleDescLayout.clickViewBtn();

        Assert.assertTrue(verify.isFrontendRowsFive(), "Frontend rows is not 5");
    }
}
