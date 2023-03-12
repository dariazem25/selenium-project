package org.example;

import com.codeborne.selenide.Condition;
import org.example.configuration.ConfProperties;
import org.example.pages.CartPage;
import org.example.pages.CheckoutOverviewPage;
import org.example.pages.CheckoutPage;
import org.example.pages.LoginPage;
import org.example.pages.MainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;

public class Tests {

    public static LoginPage loginPage = new LoginPage();
    public static MainPage mainPage = new MainPage();
    public static CartPage cartPage = new CartPage();
    public static CheckoutPage checkoutPage = new CheckoutPage();
    public static CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage();

    @BeforeAll
    public static void setup() {
        var chromeDriverPath = "src\\test\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        System.setProperty("selenide.browser", "Chrome");
    }

    @Test
    public void successfulPurchaseTest() {
        // Preconditions:
        // login
        open(ConfProperties.getProperty("loginpage"));
        loginPage.login("standard_user", "secret_sauce");

        // Actions:
        // Add the product to cart
        mainPage.clickAddToCartBtn("sauce-labs-backpack");

        // Open the cart
        mainPage.openCart();

        // Click the checkout button
        cartPage.clickCheckoutBtn();

        // Fill in your personal data
        checkoutPage.inputFirstName("test");
        checkoutPage.inputLastName("test");
        checkoutPage.inputZipCode("test");
        checkoutPage.clickContinueBtn();

        // Complete the purchase
        checkoutOverviewPage.clickFinishBtn();

        // Result:
        String completePurchasePage = webdriver().driver().getWebDriver().getCurrentUrl();

        // The redirection is occurred to checkoutcompletepage
        Assertions.assertEquals(ConfProperties.getProperty("checkoutcompletepage"), completePurchasePage);

        // The text is displayed
        var text = "Thank you for your order!";
        Assertions.assertTrue(webdriver().driver().getWebDriver().getPageSource().contains(text));
    }

    @Test
    public void invalidLoginTest() {
        // Preconditions:
        // login
        open(ConfProperties.getProperty("loginpage"));

        // Actions:
        // Input invalid login and password
        loginPage.inputLogin("test");
        loginPage.inputPasswd("test");
        loginPage.clickLoginBtn();

        // Result:
        // login is failed. The message is occurred on the current page
        String loginPage = webdriver().driver().getWebDriver().getCurrentUrl();
        var message = "Epic sadface: Username and password do not match any user in this service";

        $(byXpath("//*[@id='login_button_container']/div/form/div[3]/h3")).shouldHave(Condition.text(message));
        Assertions.assertEquals(ConfProperties.getProperty("loginpage"), loginPage);
    }
}
