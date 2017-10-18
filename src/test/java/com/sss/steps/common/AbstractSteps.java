package com.sss.steps.common;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created by Sergewar on 16.10.2017.
 */
public abstract class AbstractSteps {
    @Autowired
    @Qualifier("webdriverInstance")
    private WebDriver wdInstance;

    public WebDriver getWD() {
        return wdInstance;
    }
}
