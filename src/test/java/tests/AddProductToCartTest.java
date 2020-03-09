package tests;

import org.junit.Assert;
import org.junit.Test;
import pages.MainPage;

public class AddProductToCartTest extends BaseTest{

    @Test
    public void shouldAddProductToCart() {

        MainPage customerBasket = new MainPage(driver);
        customerBasket.mouseHoverCategory()
                      .clickOnSubcategory()
                      .addToCart();

        Assert.assertTrue(customerBasket.getAlertText().contains(customerBasket.verifyCartContent()));
    }
}
