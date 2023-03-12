package org.example.pages;

import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.$;

public class CartPage {

    public void clickCheckoutBtn() {
        $(byCssSelector("#checkout")).click();
    }
}
