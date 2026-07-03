package com.daria.steps;

import com.daria.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class ShopSteps {

    HomePage homePage = new HomePage();
    private String savedProductPrice;

    @Given("user opens T-Mobile website")
    public void userOpensTMobileWebsite() {
        homePage.openPage();
    }

    @And("user accepts cookies")
    public void userAcceptsCookies() {
        homePage.acceptCookies();
    }

    @When("user opens Sklep menu")
    public void userOpensSklepMenu() {
        homePage.openShopMenu();
    }

    @And("user selects Bez abonamentu from Smartfony section")
    public void userSelectsBezAbonamentu() {
        homePage.selectBezAbonamentu();
    }

    @When("user selects {string} brand")
    public void userSelectsBrand(String brand) {
        homePage.selectAppleSection(brand);
    }

    @And("user selects phone {string}")
    public void userSelectsPhone(String phoneName) {
        homePage.selectPhone(phoneName);
    }

    @And("user selects color {string}")
    public void userSelectsColor(String color) {
        homePage.selectColor(color);
    }

    @And("user adds phone to cart")
    public void userAddsPhoneToCart() {
        this.savedProductPrice = homePage.getProductPrice();
        homePage.addPhoneToCart();
    }

    @Then("user verifies that cart price matches product price")
    public void userVerifiesThatCartPriceMatchesProductPrice() {
        String actualCartPrice = homePage.getCartPrice();

        String cleanProductPrice = this.savedProductPrice.replaceAll("[^0-9]", "");
        String cleanCartPrice = actualCartPrice.replaceAll("[^0-9]", "");

        Assertions.assertEquals(cleanProductPrice, cleanCartPrice,
                String.format("Prices are not the same", this.savedProductPrice, actualCartPrice));
    }

    @When("user goes back to T-Mobile home page")
    public void userGoesBackToTMobileHomePage() {
        homePage.goToHomePage();
    }

    @And("user clicks on header cart icon")
    public void userClicksOnHeaderCartIcon() {
        homePage.clickHeaderCart();
    }

    @Then("cart contains added phone {string}")
    public void cartContainsAddedPhone(String phoneName) {
        homePage.verifyProductInCart(phoneName);
    }
}