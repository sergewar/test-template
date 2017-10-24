package com.sss.steps.stepsone;

import com.codeborne.selenide.WebDriverProvider;
import com.codeborne.selenide.WebDriverRunner;
import com.sss.pageobjects.GPage;
import com.sss.steps.common.AbstractSteps;
import com.sss.utils.GifSequenceWriter;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageOutputStream;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.sss.utils.ImageUtils.createGif;

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
        getWD().navigate().to("http://www.bbc.com");

        Set<By> setIgnoredElements = new HashSet<>();
        setIgnoredElements.add(By.cssSelector(".banner"));
        setIgnoredElements.add(By.cssSelector(".userPhoto"));
        AShot ashot = new AShot();
        ashot.coordsProvider(new WebDriverCoordsProvider());

        Screenshot scrnshot = ashot.ignoredElements(setIgnoredElements).
                takeScreenshot(getWD(), getWD().findElement(By.cssSelector("body")));
        try {
            ImageIO.write(scrnshot.getImage(), "PNG", new File("image.png"));
        } catch (IOException e) {
            throw new RuntimeException("can't write file");
        }
        BufferedImage expectedImage = null;
        try {
            expectedImage = ImageIO.read(new File("google.png"));
        } catch (IOException e) {
            throw new RuntimeException("can't read file");
        }

        BufferedImage actualImage = scrnshot.getImage();

        ImageDiffer imgDiff = new ImageDiffer();

        ImageDiff diff = imgDiff.makeDiff(expectedImage, actualImage);

        System.out.println("finally");
//        Assert.assertTrue(diff.hasDiff(), "Images are Same");


        File diffFile = new File("diffImage.png");
        File marketFile = new File("marked.png");
        File transparentMarketFile = new File("transparentMarked.png");
        ImageIO.write(diff.getDiffImage(), "png", diffFile);
        ImageIO.write(diff.getMarkedImage(), "png", marketFile);
        ImageIO.write(diff.getTransparentMarkedImage(), "png", transparentMarketFile);

        List<BufferedImage> slides = new ArrayList<>();

        slides.add(expectedImage);
        slides.add(diff.getDiffImage());
        slides.add(diff.getMarkedImage());
        slides.add(diff.getTransparentMarkedImage());
        createGif("FinalGif.gif", slides);

    }


}
