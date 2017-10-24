package com.sss.steps.common;

import com.applitools.eyes.selenium.Eyes;
import com.sss.tests.common.EyesProvider;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created by Sergewar on 16.10.2017.
 */
public abstract class AbstractSteps {
    @Autowired
    @Qualifier("selenideCustomized")
    private WebDriver wdInstance;

    public WebDriver getWD() {
        return wdInstance;
    }

    public Eyes getEyes() {
        return EyesProvider.getEyes();
    }
}
