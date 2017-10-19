package com.sss.tests.common;

import com.codeborne.selenide.Selenide;
import com.sss.testing.utils.webdriver.RuntimeModes;
import com.sss.testing.utils.webdriver.WDFactory;
import com.sss.testing.utils.webdriver.WDSettings;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class AbstractGuiAppTest extends AbstractSelenideBasedTest {


    @BeforeMethod(groups = {"GUI", "smoke"})
    public void setUpGui(ITestContext testContext) throws Exception {
        String testName = testContext.getName();
        prepareSelenide(testName);
        String applicationUrl = "http://google.com";
        Selenide.open(applicationUrl);
    }

    private void prepareSelenide(String testName) {
        WDSettings wdSettings = new WDSettings(
                "ru",
                "chrome",
                "target/download",
                "/tmp/mounted",
                "/webdriver_downloads",
                "",
                "");
        WDFactory wdFactory = new WDFactory();
        wdFactory.createCustomizedSelenide(
                wdSettings,
                RuntimeModes.RUN,
                testName
        );
        getWebDriver().manage().deleteAllCookies();
    }
}
