package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.VerifyFlexTablePage;
import pages.Login_Page;
import utils.BaseTest;

public class test03_OpenFlexTableDashboard extends BaseTest {

    @Test
    public void navigateToFlexTableDashboard() {
        Login_Page loginPage = new Login_Page(page);
        loginPage.loginWithValidCredential(USERNAME, PASSWORD);
        Assert.assertTrue(loginPage.sucessLoginMsg(), "Login was not successful");

        VerifyFlexTablePage verifyFlexTablePage = new VerifyFlexTablePage(page);
        verifyFlexTablePage.navigateToFlexTableDashboard();
        Assert.assertTrue(verifyFlexTablePage.isDashboardVisible(), "FlexTable Dashboard is not displayed!");
    }
}
