package com.sss.steps.stepsone;

import com.codeborne.selenide.WebDriverProvider;
import com.codeborne.selenide.WebDriverRunner;
import com.sss.pageobjects.GPage;
import com.sss.steps.common.AbstractSteps;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Sergewar on 16.10.2017.
 */
public class StepsOne extends AbstractSteps {
    private static final Logger LOGGER = LoggerFactory.getLogger(StepsOne.class);
    private String secretValue = "hello from steps one";

    @Step("annotation on method one")
    public void methodOne() {
        LOGGER.info(secretValue);
        getWD().navigate().to("http://www.google.com");
        getEyes().checkWindow("google main page");
        System.out.println(WebDriverRunner.getWebDriver().getPageSource());
        System.out.println("--------------------------------------------------------------");
        System.out.println(new GPage(getWD()).getHtml());
        getWD().navigate().to("http://www.yandex.ru");
        getEyes().checkWindow("yandex main page");
        getEyes().checkElement(By.cssSelector("html"));
    }
}
