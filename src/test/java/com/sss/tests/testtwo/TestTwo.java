package com.sss.tests.testtwo;

import com.sss.steps.stepsone.StepsOne;
import com.sss.steps.stepstwo.StepsTwo;
import com.sss.tests.common.AbstractTest;
import io.qameta.allure.Description;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

/**
 * Created by Sergewar on 16.10.2017.
 */
public class TestTwo extends AbstractTest {

    @Autowired
    private StepsTwo stepsTwo;

    @Test
    @Description("Two")
    public void realTestTwo() {
        stepsTwo.methodTwo();
    }

    @Test
    @Description("Two2")
    public void realTestTwo2() {
        stepsTwo.methodTwo();
    }

    @Test
    @Description("Two3")
    public void realTestTwo3() {
        stepsTwo.methodTwo();
    }

    @Test
    @Description("Two4")
    public void realTestTwo4() {
        stepsTwo.methodTwo();
    }

    @Test
    @Description("Two5")
    public void realTestTwo5() {
        stepsTwo.methodTwo();
    }

    @Test
    @Description("Two6")
    public void realTestTwo6() {
        stepsTwo.methodTwo();
    }
}
