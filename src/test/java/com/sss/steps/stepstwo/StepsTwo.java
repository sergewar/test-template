package com.sss.steps.stepstwo;

import com.sss.steps.common.AbstractSteps;
import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Sergewar on 16.10.2017.
 */
public class StepsTwo extends AbstractSteps {
    private static final Logger LOGGER = LoggerFactory.getLogger(StepsTwo.class);

    private String secretValue = "hello from steps two";

    @Step("annotation on method two")
    public void methodTwo() {
        LOGGER.info(secretValue);
    }
}
