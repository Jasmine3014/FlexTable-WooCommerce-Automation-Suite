package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FlexShortCutPage;
import pages.Login_Page;
import pages.VerifyOrderHistory;
import pages.WoocommerceAddToCart;
import utils.BaseTest;

public class verify_Order_History extends BaseTest {

    @Test
    public void Verify_woocommerce_Add_To_Cart(){
        Login_Page loginPage = new Login_Page(page);
        loginPage.loginWithValidCredential(USERNAME, PASSWORD);

        FlexShortCutPage flex = new FlexShortCutPage(page);
        flex.clickPages();

        WoocommerceAddToCart woocommerceAddToCart = new WoocommerceAddToCart(page);
        woocommerceAddToCart.clickOnViewCart();

        VerifyOrderHistory verifyOrderHistory = new VerifyOrderHistory(page);
        verifyOrderHistory.clickOnMyAccount();
        verifyOrderHistory.clickOnOrders();
        verifyOrderHistory.ClickOnViewOrder();
    }
}
