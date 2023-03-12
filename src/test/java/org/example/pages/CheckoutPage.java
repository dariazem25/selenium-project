package org.example.pages;

import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class CheckoutPage {

    public void inputFirstName(String firstName) {
        $(byXpath("//*[@id='first-name']")).sendKeys(firstName);
    }

    public void inputLastName(String lastName) {
        $(byId("last-name")).sendKeys(lastName);
    }

    public void inputZipCode(String zipCode) {
        $(byId("postal-code")).sendKeys(zipCode);
    }

    public void clickContinueBtn() {
        $(byCssSelector("#continue")).click();
    }
}
