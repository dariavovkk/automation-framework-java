package com.daria.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class HomePage {


    private static final String URL = "https://www.t-mobile.pl";


    private SelenideElement shopButton() {
        return $$("button").findBy(text("Sklep"));
    }

    private final SelenideElement acceptCookiesButton =
            $("button#didomi-notice-agree-button");

    private SelenideElement bezAbonamentuButton() {
        return $x("//*[contains(text(),'Bez abonamentu')]");
    }

    public HomePage openPage() {

        open(URL);
        sleep(5000);

        System.out.println($("#didomi-notice-agree-button").exists());

        return this;
    }

    public void acceptCookies() {

        acceptCookiesButton
                .shouldBe(visible, Duration.ofSeconds(10))
                .click();

        acceptCookiesButton.shouldNot(exist);

    }

    public HomePage openShopMenu() {

        shopButton().shouldBe(visible).click();

        $("[role='menu'], .dropdown, nav")
                .shouldBe(visible, Duration.ofSeconds(10));

        shopButton().shouldHave(attribute("aria-expanded", "true"));

        return this;
    }

    public HomePage selectBezAbonamentu() {

        bezAbonamentuButton()
                .shouldBe(visible, Duration.ofSeconds(10))
                .click();

        return this;
    }
}