package com.daria.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import java.time.Duration;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class ProductsListPage {

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

    public ProductsListPage selectBezAbonamentu() {
        bezAbonamentuButton()
                .shouldBe(visible, Duration.ofSeconds(10))
                .click();
        return this;
    }

    public ProductsListPage selectBrandSection(String brand) {
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
}