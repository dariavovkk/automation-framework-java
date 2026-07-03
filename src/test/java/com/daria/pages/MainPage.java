package com.daria.pages;

import com.codeborne.selenide.SelenideElement;
import java.time.Duration;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private static final String URL = "https://www.t-mobile.pl";
    private final SelenideElement acceptCookiesButton = $("button#didomi-notice-agree-button");
    private final SelenideElement headerCartIcon = $("a[href*='/basket'], a[aria-label='Koszyk']");

    private SelenideElement shopButton() {
        return $$("button").findBy(text("Sklep"));
    }

    public MainPage openPage() {
        open(URL);
        sleep(5000);
        return this;
    }

    public void acceptCookies() {
        if (acceptCookiesButton.is(visible)) {
            try {
                acceptCookiesButton.shouldBe(visible, Duration.ofSeconds(10)).click();
            } catch (Exception e) {
                executeJavaScript("arguments[0].click();", acceptCookiesButton);
            }
            acceptCookiesButton.shouldNot(exist, Duration.ofSeconds(5));
        }
    }

    public MainPage openShopMenu() {
        shopButton().shouldBe(visible).click();
        $("[role='menu'], .dropdown, nav")
                .shouldBe(visible, Duration.ofSeconds(10));
        shopButton().shouldHave(attribute("aria-expanded", "true"));
        return this;
    }

    public void clickHeaderCart() {
        headerCartIcon.shouldBe(visible, Duration.ofSeconds(15));
        executeJavaScript("arguments[0].click();", headerCartIcon);
    }
}