package com.sss.tests.common;

import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterMethod;

class AbstractSelenideBasedTest {

    @AfterMethod
    public void tearDown() {
        Selenide.close();
    }

}
