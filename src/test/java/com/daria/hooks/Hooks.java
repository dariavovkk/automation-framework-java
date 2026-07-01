package com.daria.hooks;

import com.codeborne.selenide.Configuration;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    @Before
    public void setUp(){
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
    }
    @After
    public void tearDown(){
        com.codeborne.selenide.Selenide.closeWebDriver();
    }
}
