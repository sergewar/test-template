package com.sss.tests.testone;

import com.sss.steps.stepsone.StepsOne;
import com.sss.tests.common.AbstractTest;
import io.qameta.allure.Description;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

/**
 * Created by Sergewar on 16.10.2017.
 */
public class TestOne extends AbstractTest {
    @Autowired
    private StepsOne stepsOne;

    @Test
    @Description("One")
    public void realTestOne() {
        stepsOne.methodOne();
    }

    @Test
    @Description("One2()")
    public void realTestOne2() {
        stepsOne.methodOne();
    }

    @Test
    @Description("One3")
    public void realTestOne3() {
        stepsOne.methodOne();
    }

    @Test
    @Description("One4()")
    public void realTestOne4() {
        stepsOne.methodOne();
    }

    @Test
    @Description("One5")
    public void realTestOne5() {
        stepsOne.methodOne();
    }

    @Test
    @Description("One6")
    public void realTestOne6() {
        stepsOne.methodOne();
    }

    @Test
    @Description("One7")
    public void realTestOne7() {
        stepsOne.methodOne();
    }

    @Test
    @Description("One8")
    public void realTestOne8() {
        stepsOne.methodOne();
    }
}
