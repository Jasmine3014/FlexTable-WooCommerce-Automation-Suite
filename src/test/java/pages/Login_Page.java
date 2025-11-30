package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.testng.Assert;

public class Login_Page {
    Page page;
    private Locator userName;
    private Locator passWord;
    private Locator loginBtn;
    private Locator welcomeMsg;

    public Login_Page(Page page) {
        this.page = page;
        this.userName = page.locator("//input[@id='user_login']");
        this.passWord = page.locator("//input[@id='user_pass']");
        this.loginBtn = page.locator("//input[@id='wp-submit']");
        this.welcomeMsg = page.locator("//div[@class='welcome-panel-header-image']");

    }

    public void loginWithValidCredential(String username, String password) {
        userName.fill(utils.BaseTest.USERNAME);
        passWord.fill(utils.BaseTest.PASSWORD);
        loginBtn.click();
    }

    public boolean sucessLoginMsg() {
        welcomeMsg.waitFor();
        return welcomeMsg.isVisible();
    }
}
