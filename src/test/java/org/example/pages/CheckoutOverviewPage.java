package org.example.pages;

import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.$;

public class CheckoutOverviewPage {

    public void clickFinishBtn() {
        $(byCssSelector("#finish")).click();
    }
}
