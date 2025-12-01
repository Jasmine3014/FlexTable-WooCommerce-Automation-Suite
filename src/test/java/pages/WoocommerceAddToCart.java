package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class WoocommerceAddToCart {
    Page page;
    Locator cartPage;
    Locator viewBtn;
    Locator productAddtoCartBtn;
    Locator proceedCheckoutBtn;
    Locator firstName;
    Locator lastName;
    Locator address;
    Locator city;
    Locator placeOrderBtn;
    Locator orderRecivedMsg;

    public WoocommerceAddToCart (Page page) {
        this.page = page;
        cartPage = page.locator("//span[normalize-space()='Cart Page']");
        viewBtn = page.locator("//a[@aria-label='View “Cart”']");
        productAddtoCartBtn = page.locator("//a[normalize-space()='Add to cart']");
        proceedCheckoutBtn = page.locator("//div[@class='wc-block-cart__submit-container']/a/div[text()='Proceed to Checkout']");
        firstName = page.locator("#shipping-first_name");
        lastName = page.locator("#shipping-last_name");
        address = page.locator("#shipping-address_1");
        city = page.locator("#shipping-city");
        placeOrderBtn = page.locator("//button[@type='button']");
        orderRecivedMsg= page.locator("//h1[normalize-space()='Order received']");
    }

    public void clickOnViewCart() {
        cartPage.hover();
        viewBtn.click();
    }

    public  void  clickOnAddToCart() {
        productAddtoCartBtn.click();
    }

    public  void  clickOnProcedCheckout() {
        proceedCheckoutBtn.click();
    }

    public void fillShippingInfoIfPresent() {
        if (firstName.isVisible()) {
            firstName.fill("Jasmine");
            lastName.fill("Akter");
            address.fill("Dhaka");
            city.fill("Dhaka");
        }
    }

    public  void  clickPlaceOrderBtn() {
        placeOrderBtn.click();
    }

    public boolean isOrderSucessMsgVisible() {
        orderRecivedMsg.waitFor();
        return orderRecivedMsg.isVisible();
    }
}
