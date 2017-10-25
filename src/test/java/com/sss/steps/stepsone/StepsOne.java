package com.sss.steps.stepsone;

import com.codeborne.selenide.WebDriverRunner;
import com.sss.pageobjects.GPage;
import com.sss.steps.common.AbstractSteps;
import com.sss.utils.AShotComparator;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.yandex.qatools.ashot.AShot;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Sergewar on 16.10.2017.
 */
public class StepsOne extends AbstractSteps {
    private static final Logger LOGGER = LoggerFactory.getLogger(StepsOne.class);
    private String secretValue = "hello from steps one";

    @Step("annotation on method one")
    public void methodOne() {
        LOGGER.info(secretValue);
        getWD().navigate().to("http://www.google.com");
        getEyes().checkWindow("google main page");
        System.out.println(WebDriverRunner.getWebDriver().getPageSource());
        System.out.println("--------------------------------------------------------------");
        System.out.println(new GPage(getWD()).getHtml());
        getWD().navigate().to("http://www.yandex.ru");
        getEyes().checkWindow("yandex main page");
        getEyes().checkElement(By.cssSelector("html"));
    }

    @Step("annotation on method one")
    public void methodTwo() throws IOException {
        getWD().navigate().to("http://www.yandex.ru");
        getWD().findElement(By.cssSelector("body")).click();
        File originalScreenshot = new File("yandex.png");
        WebElement elementToShot = getWD().findElement(By.cssSelector("body"));

        Set<By> setIgnoredElements = new HashSet<>();
        setIgnoredElements.add(By.cssSelector(".banner"));
        setIgnoredElements.add(By.cssSelector(".userPhoto"));
//        setIgnoredElements.add(By.cssSelector("div#gs_lc0"));
//        setIgnoredElements.add(By.cssSelector("input#lst-ib"));
        AShot ashot = new AShot()
                ;
//                .coordsProvider(new WebDriverCoordsProvider())
//                .ignoredElements(setIgnoredElements);
//        Screenshot scrnshot = ashot
//                .shootingStrategy(ShootingStrategies.viewportPasting(50))
//                  .coordsProvider(new WebDriverCoordsProvider())
//                  .takeScreenshot(getWD(), elementToShot);
//        ImageIO.write(scrnshot.getImage(), "PNG", originalScreenshot);
        boolean isTheSame = new AShotComparator().comparator(originalScreenshot, ashot, getWD(), elementToShot);
        LOGGER.info("" + isTheSame);

    }


}
