package com.daria.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class HomePage {

    private static final String URL = "https://www.t-mobile.pl";

    private final SelenideElement acceptCookiesButton = $("button#didomi-notice-agree-button");
    private final SelenideElement productPriceLabel = $(".StyledFullDeviceInfo-sc-126tgxz-0 .actualText");
    private final SelenideElement cartPriceLabel = $("[data-qa='BKT_Activation']");
    private final SelenideElement cartProductName = $("[data-qa='BKT_ProductName']");
    private final SelenideElement tMobileLogo = $(".logoWrap");
    private final SelenideElement headerCartIcon = $("a[href*='/basket'], a[aria-label='Koszyk']");

    private SelenideElement shopButton() {
        return $$("button").findBy(text("Sklep"));
    }

    private SelenideElement bezAbonamentuButton() {
        return $x("//*[contains(text(),'Bez abonamentu')]");
    }

    private SelenideElement brandFilter(String brand) {
        return $("button[aria-label*='" + brand + "']");
    }

    private SelenideElement phoneLink(String phoneName) {
        return $$("a[aria-label*='" + phoneName + "']")
                .first()
                .shouldBe(visible, Duration.ofSeconds(10));
    }

    private SelenideElement addToCartButton() {
        return $("#dyt_addDeviceToCart");
    }

    public HomePage openPage() {
        open(URL);
        sleep(5000);
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

    public HomePage selectAppleSection(String brand) {
        brandFilter(brand)
                .shouldBe(visible)
                .click();
        return this;
    }

    public void selectPhone(String phoneName) {
        phoneLink(phoneName)
                .shouldBe(Condition.visible, Duration.ofSeconds(10))
                .click();
    }

    public HomePage selectColor(String name) {
        SelenideElement color = $$("div[role='button'][data-qa^='PRD_Color']")
                .findBy(attribute("aria-label", "Select " + name + " color variant"));

        color.shouldBe(Condition.visible, Duration.ofSeconds(15))
                .shouldBe(Condition.enabled, Duration.ofSeconds(15))
                .click();

        color.shouldHave(attribute("aria-pressed", "true"), Duration.ofSeconds(15));
        sleep(3000);
        return this;
    }

    public void addPhoneToCart() {
        addToCartButton().scrollIntoView("{block: \"center\"}");
        sleep(2000);
        executeJavaScript("arguments[0].click();", addToCartButton());
    }

    public String getProductPrice() {
        productPriceLabel.should(Condition.exist, Duration.ofSeconds(15));
        return executeJavaScript("return arguments[0].textContent;", productPriceLabel).toString().trim();
    }

    public String getCartPrice() {
        return cartPriceLabel
                .shouldBe(visible, Duration.ofSeconds(15))
                .text()
                .trim();
    }

    public void verifyProductInCart(String expectedPhoneName) {
        SelenideElement dynamicCartProductName = $x("//*[contains(text(), '" + expectedPhoneName + "')]");
        dynamicCartProductName.shouldBe(visible, Duration.ofSeconds(15));
    }

    public HomePage goToHomePage() {
        tMobileLogo.shouldBe(visible, Duration.ofSeconds(15));
        executeJavaScript("arguments[0].click();", tMobileLogo);
        return this;
    }

    public void clickHeaderCart() {
        headerCartIcon.shouldBe(visible, Duration.ofSeconds(15));
        executeJavaScript("arguments[0].click();", headerCartIcon);
    }
}