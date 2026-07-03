package com.daria.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import java.time.Duration;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class ProductDetailsPage {

    private final SelenideElement productPriceLabel = $(".StyledFullDeviceInfo-sc-126tgxz-0 .actualText");

    private SelenideElement addToCartButton() {
        return $("#dyt_addDeviceToCart");
    }

    public ProductDetailsPage selectColor(String name) {
        SelenideElement color = $$("div[role='button'][data-qa^='PRD_Color']")
                .findBy(attribute("aria-label", "Select " + name + " color variant"));

        color.shouldBe(Condition.visible, Duration.ofSeconds(15))
                .shouldBe(Condition.enabled, Duration.ofSeconds(15))
                .click();

        color.shouldHave(attribute("aria-pressed", "true"), Duration.ofSeconds(15));
        sleep(3000);
        return this;
    }

    public String getProductPrice() {
        productPriceLabel.should(Condition.exist, Duration.ofSeconds(15));
        return executeJavaScript("return arguments[0].textContent;", productPriceLabel).toString().trim();
    }

    public void addPhoneToCart() {
        addToCartButton().scrollIntoView("{block: \"center\"}");
        sleep(2000);
        executeJavaScript("arguments[0].click();", addToCartButton());
    }
}