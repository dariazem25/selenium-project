package org.example.pages;

import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    public void inputLogin(String login) {
        $(byXpath("//*[@id='user-name']")).sendKeys(login);
    }

    public void inputPasswd(String passwd) {
        $(byId("password")).sendKeys(passwd);
    }

    public void clickLoginBtn() {
        $(byCssSelector("#login-button")).click();
    }

    public void login(String login, String passwd) {
        inputLogin(login);
        inputPasswd(passwd);
        clickLoginBtn();
    }
}
