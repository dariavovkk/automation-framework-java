package com.daria.steps;

import com.daria.pages.CartPage;
import com.daria.pages.MainPage;
import com.daria.pages.ProductDetailsPage;
import com.daria.pages.ProductsListPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class ShopSteps {

    private final MainPage mainPage = new MainPage();
    private final ProductsListPage productsListPage = new ProductsListPage();
    private final ProductDetailsPage productDetailsPage = new ProductDetailsPage();
    private final CartPage cartPage = new CartPage();

    private String savedProductPrice;

    @Given("user opens T-Mobile website")
    public void userOpensTMobileWebsite() {
        mainPage.openPage();
    }

    @And("user accepts cookies")
    public void userAcceptsCookies() {
        mainPage.acceptCookies();
    }

    @When("user opens Sklep menu")
    public void userOpensSklepMenu() {
        mainPage.openShopMenu();
    }

    @And("user selects Bez abonamentu from Smartfony section")
    public void userSelectsBezAbonamentu() {
        productsListPage.selectBezAbonamentu();
    }

    @When("user selects {string} brand")
    public void userSelectsBrand(String brand) {
        productsListPage.selectBrandSection(brand);
    }

    @And("user selects phone {string}")
    public void userSelectsPhone(String phoneName) {
        productsListPage.selectPhone(phoneName);
    }

    @And("user selects color {string}")
    public void userSelectsColor(String color) {
        productDetailsPage.selectColor(color);
    }

    @And("user adds phone to cart")
    public void userAddsPhoneToCart() {
        this.savedProductPrice = productDetailsPage.getProductPrice();
        productDetailsPage.addPhoneToCart();
    }

    @Then("user verifies that cart price matches product price")
    public void userVerifiesThatCartPriceMatchesProductPrice() {
        String actualCartPrice = cartPage.getCartPrice();

        String cleanProductPrice = this.savedProductPrice.replaceAll("[^0-9]", "");
        String cleanCartPrice = actualCartPrice.replaceAll("[^0-9]", "");

        Assertions.assertEquals(cleanProductPrice, cleanCartPrice,
                String.format("Cena nie zgadza się! Na produkcie: %s, w koszyku: %s", this.savedProductPrice, actualCartPrice));
    }

    @When("user goes back to T-Mobile home page")
    public void userGoesBackToTMobileHomePage() {
        cartPage.goToHomePage();
    }

    @And("user clicks on header cart icon")
    public void userClicksOnHeaderCartIcon() {
        mainPage.clickHeaderCart();
    }

    @Then("cart contains added phone {string}")
    public void cartContainsAddedPhone(String phoneName) {
        cartPage.verifyProductInCart(phoneName);
    }
}