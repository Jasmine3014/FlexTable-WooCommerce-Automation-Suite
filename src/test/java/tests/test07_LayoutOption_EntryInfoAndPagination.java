package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.BaseTest;

public class test07_LayoutOption_EntryInfoAndPagination extends BaseTest {

    @Test
    public void LayoutOption_EntryInfoAndPagination() {
        Login_Page loginPage = new Login_Page(page);
        loginPage.loginWithValidCredential(USERNAME, PASSWORD);

        VerifyFlexTablePage verifyFlexTablePage = new VerifyFlexTablePage(page);
        verifyFlexTablePage.navigateToFlexTableDashboard();

        VerifyTitleDescLayout verifyTitleDescLayout = new VerifyTitleDescLayout(page);
        verifyTitleDescLayout.clickEditTableBtn();
        verifyTitleDescLayout.clickTablecustom();

        VerifyPaginationAndEntryInfoInTableLayout verifyPagination= new VerifyPaginationAndEntryInfoInTableLayout(page);
        verifyPagination.enableTableBottomsElements();

        FlexShortCutPage flex = new FlexShortCutPage(page);
        flex.clickPages();
        verifyTitleDescLayout.clickViewBtn();
        verifyPagination.assertPaginationPresent();

        }
    }

