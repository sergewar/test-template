package com.sss.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GPage extends AbstractPO {
    public GPage(WebDriver webDriver, By container) {
        super(webDriver, By.cssSelector("div[title='Google']"));
    }
}
