package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.BaseTest;

public class woocommerce_Add_To_Cart extends BaseTest {

    @Test
    public void Verify_woocommerce_Add_To_Cart(){
        Login_Page loginPage = new Login_Page(page);
        loginPage.loginWithValidCredential(USERNAME, PASSWORD);

        FlexShortCutPage flex = new FlexShortCutPage(page);
        flex.clickPages();

        WoocommerceAddToCart woocommerceAddToCart = new WoocommerceAddToCart(page);
        woocommerceAddToCart.clickOnViewCart();
        woocommerceAddToCart.clickOnAddToCart();
        woocommerceAddToCart.clickOnProcedCheckout();
        woocommerceAddToCart.fillShippingInfoIfPresent();
        woocommerceAddToCart.clickPlaceOrderBtn();
        Assert.assertTrue(woocommerceAddToCart.isOrderSucessMsgVisible(), "No success Message");
    }
}
