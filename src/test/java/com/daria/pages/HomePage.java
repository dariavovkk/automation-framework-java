package com.daria.pages;

import static com.codeborne.selenide.Selenide.open;


public class HomePage {


    private static final String URL = "https://www.t-mobile.pl";


    public HomePage openPage() {

        open(URL);

        return this;
    }

}