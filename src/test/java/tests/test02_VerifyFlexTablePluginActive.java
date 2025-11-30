package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Login_Page;
import pages.PluginActivationPage;
import utils.BaseTest;

public class test02_VerifyFlexTablePluginActive extends BaseTest {

    @Test
    public void validateFlexTablePluginIsActive() {
        Login_Page loginPage = new Login_Page(page);
        loginPage.loginWithValidCredential(USERNAME, PASSWORD);
        Assert.assertTrue(loginPage.sucessLoginMsg(), "Login was not successful");

        PluginActivationPage pluginPage = new PluginActivationPage(page);
        pluginPage.navigateToInstalledPlugins();
        pluginPage.searchForFlexTablePlugin();
        if (pluginPage.isFlexTableInstalled()) {
            if (!pluginPage.isFlexTableActive()) {
                pluginPage.inatllPageActivateBtn();
            }
        } else {
            pluginPage.navigateToAddPlugins();
            pluginPage.searchForAddPlugin();
            pluginPage.installFlexTable();
        }
        Assert.assertTrue(pluginPage.isFlexTableActive(), "FlexTable plugin is not activated!");
    }
}
