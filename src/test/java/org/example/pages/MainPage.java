package org.example.pages;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    public void clickAddToCartBtn(String product) {
        $(byXpath("//*[@id='add-to-cart-" + product + "']")).click();
    }

    public void openCart() {
        $(byXpath("//*[@id='shopping_cart_container']/a")).click();
    }
}
