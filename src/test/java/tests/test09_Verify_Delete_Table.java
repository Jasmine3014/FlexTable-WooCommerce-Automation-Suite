package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.BaseTest;

public class test09_Verify_Delete_Table extends BaseTest {

    @Test
    public void Verify_Delete_Table() {
        Login_Page loginPage = new Login_Page(page);
        loginPage.loginWithValidCredential(USERNAME, PASSWORD);

        VerifyFlexTablePage verifyFlexTablePage = new VerifyFlexTablePage(page);
        verifyFlexTablePage.navigateToFlexTableDashboard();

        DeleteTable deleteTable = new DeleteTable(page);
        deleteTable.clickOnDeleteTable();

        FlexShortCutPage flex = new FlexShortCutPage(page);
        flex.clickPages();

        VerifyTitleDescLayout verifyTitleDescLayout = new VerifyTitleDescLayout(page);
        verifyTitleDescLayout.clickViewBtn();
        Assert.assertFalse(deleteTable.iTablePresent(), "Table is visible");
        Assert.assertTrue(deleteTable.checkErrorMsg(), "No error Message");
    }

}
