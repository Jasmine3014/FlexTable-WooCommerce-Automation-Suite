package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Login_Page;
import utils.BaseTest;

public class test01_LoginToWordPress extends BaseTest {

    @Test
    public void LoginTest() {
        Login_Page loginPage = new Login_Page(page);
        loginPage.loginWithValidCredential(USERNAME, PASSWORD);
        Assert.assertTrue(loginPage.sucessLoginMsg(), "Login Was Not Successfull");
        }
    }

