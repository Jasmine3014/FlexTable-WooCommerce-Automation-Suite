package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FlexTablePage;
import pages.Login_Page;
import pages.VerifyFlexTablePage;
import utils.BaseTest;

public class test04_CreateNewTableFromGoogleSheet extends BaseTest {

    @Test
    public void createTableFromGoogleSheet() {

        Login_Page loginPage = new Login_Page(page);
        loginPage.loginWithValidCredential(USERNAME, PASSWORD);
        Assert.assertTrue(loginPage.sucessLoginMsg(), "Login was not successful");

        VerifyFlexTablePage verifyFlexTablePage = new VerifyFlexTablePage(page);
        verifyFlexTablePage.navigateToFlexTableDashboard();

        FlexTablePage flexTablePage = new FlexTablePage(page);
        flexTablePage.createTable();
        flexTablePage.createTableFromUrl();
        flexTablePage.fillTitleAndDescriptionAndSave();
        verifyFlexTablePage.navigateToFlexTableDashboard();
        Assert.assertTrue(
                flexTablePage.isTableNameContains("Test table"), "Table name does NOT contain 'test'"
        );


    }
}
