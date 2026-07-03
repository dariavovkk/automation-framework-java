package com.daria.pages;

import java.time.Duration;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class CartPage {

    private final SelenideElement cartPriceLabel = $("[data-qa='BKT_Activation']");
    private final SelenideElement tMobileLogo = $(".logoWrap");

    public String getCartPrice() {
        return cartPriceLabel
                .shouldBe(visible, Duration.ofSeconds(15))
                .text()
                .trim();
    }

    public CartPage goToHomePage() {
        tMobileLogo.shouldBe(visible, Duration.ofSeconds(15));
        executeJavaScript("arguments[0].click();", tMobileLogo);
        return this;
    }

    public void verifyProductInCart(String expectedPhoneName) {
        SelenideElement dynamicCartProductName = $x("//*[contains(text(), '" + expectedPhoneName + "')]");
        dynamicCartProductName.shouldBe(visible, Duration.ofSeconds(15));
    }
}