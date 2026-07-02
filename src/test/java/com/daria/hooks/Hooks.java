package com.daria.hooks;

import com.codeborne.selenide.Configuration;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import static com.codeborne.selenide.Selenide.closeWebDriver;


public class Hooks {


    @Before
    public void setUp() {

        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";

    }


    @After
    public void tearDown() {

        closeWebDriver();

    }

}