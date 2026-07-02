package com.daria.steps;

import com.daria.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;


public class ShopSteps {

    HomePage homePage = new HomePage();


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
}