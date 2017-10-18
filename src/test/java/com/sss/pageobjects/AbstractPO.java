package com.sss.pageobjects;

import com.sss.testing.utils.webdriver.pageobject.AbstractPageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractPO extends AbstractPageObject {
    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractPO.class);

    public AbstractPO(WebDriver webDriver, By container) {
        super(webDriver, container);
    }

    public WebDriver getWD() {
        return getWebDriver();
    }
}
