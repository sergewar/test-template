package com.sss.tests.selenide;

import com.sss.pageobjects.selenidepo.SomePO;
import com.sss.tests.common.AbstractGuiAppTest;
import org.testng.annotations.Test;

public class SelenideTestOne extends AbstractGuiAppTest {

    @Test
    private void testOne() {
        System.out.println(new SomePO().getHeader().getText());
    }
}
