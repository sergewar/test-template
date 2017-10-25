package com.sss.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static com.sss.utils.ImageUtils.createGif;

public class AShotComparator {

    public boolean comparator(File original, AShot aShot, WebDriver driver, Collection<WebElement> elements) {
        aShot.coordsProvider(new WebDriverCoordsProvider());
        Screenshot scrnshot = aShot.takeScreenshot(driver, elements);
//        try {
//
//            ImageIO.write(scrnshot.getImage(), "PNG", new File( screenshotFileName + ".png"));
//        } catch (IOException e) {
//            throw new RuntimeException("Can't write screenshot file");
//        }

        BufferedImage expectedImage;
        try {
            expectedImage = ImageIO.read(original);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file");
        }

        BufferedImage actualImage = scrnshot.getImage();

        ImageDiffer imgDiff = new ImageDiffer();
        ImageDiff diff = imgDiff.makeDiff(expectedImage, actualImage);

        boolean hasDifference = diff.hasDiff();
        if (hasDifference) {
            String screenshotDirectory = "screenshots";
            new File(screenshotDirectory).mkdirs();

            String screenshotFileNamePrefix = getScreenShotName(driver);
            String scrPathPref = screenshotDirectory + System.getProperty("file.separator") + screenshotFileNamePrefix + "_";
            File diffFile = new File(scrPathPref + "diffImage.png");
            File marketFile = new File(scrPathPref + "marked.png");
            File transparentMarketFile = new File(scrPathPref + "transparentMarked.png");
            BufferedImage diffImage = diff.getDiffImage();
            BufferedImage markedImage = diff.getMarkedImage();
            BufferedImage transparentMarkedImage = diff.getTransparentMarkedImage();

            List<BufferedImage> slides = new ArrayList<>();
            slides.add(expectedImage);
            slides.add(diffImage);
            slides.add(markedImage);
            slides.add(transparentMarkedImage);
            try {
                ImageIO.write(diffImage, "png", diffFile);
                ImageIO.write(markedImage, "png", marketFile);
                ImageIO.write(transparentMarkedImage, "png", transparentMarketFile);
                createGif(scrPathPref + "FinalGif.gif", slides);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return hasDifference;
    }

    public boolean comparator(File original, AShot aShot, WebDriver driver, WebElement element) {
        return comparator(original, aShot, driver, Collections.singletonList(element));
    }

    private String getScreenShotName(WebDriver driver) {
        String domain;
        try {
            domain = new URL(driver.getCurrentUrl()).getHost();
        } catch (MalformedURLException e) {
            domain = "";
        }
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String screenshotFileName =
                domain + "_" +
//         get locale: var language = window.navigator.userLanguage || window.navigator.language;
                        ((JavascriptExecutor) driver).executeScript("return window.navigator.language") + "_" +
                        driver.manage().window().getSize().toString().replace(" ", "") + "_" +
                        now.format(dtf);
        return screenshotFileName;
    }
}
