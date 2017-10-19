package com.sss.pageobjects.selenidepo;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class SomePO {

    public SelenideElement getHeader() {
        return $("div[title='Google']");
    }
}
