package com.daria.steps;

import com.daria.pages.HomePage;
import io.cucumber.java.en.Given;


public class ShopSteps {

    private final HomePage homePage = new HomePage();


    @Given("user opens T-Mobile website")
    public void userOpensTMobileWebsite() {

        homePage.openPage();

    }
}