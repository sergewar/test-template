package com.sss.utils;

import javax.imageio.stream.FileImageOutputStream;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by Sergewar on 23.10.2017.
 */
public class ImageUtils {
    public static void createGif(String filePath,List<BufferedImage> slides) throws IOException {
        ImageOutputStream output = new FileImageOutputStream(new File(filePath));
        GifSequenceWriter writer = new GifSequenceWriter(output, slides.get(0).getType() ,300,true);

        for (BufferedImage slide : slides) {
            writer.writeToSequence(slide);
        }
        writer.close();
        output.close();
    }
}
