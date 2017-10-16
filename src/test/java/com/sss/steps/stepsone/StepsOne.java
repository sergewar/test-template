package com.sss.steps.stepsone;

import com.sss.steps.common.AbstractSteps;
import io.qameta.allure.Step;
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
    }
}
