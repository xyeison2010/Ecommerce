package Ecommerce.Utilities;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

import Ecommerce.Exceptions.ResizeImageException;
import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnails;



@Slf4j
public class MediaResizer {
	
	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(MediaResizer.class);

    public static InputStream resizeImage(BufferedImage read, int height, int width, String fileExtentions) {

        try {

            BufferedImage asBufferedImage = Thumbnails
                    .of(read)
                    .outputFormat(fileExtentions)
                    .size(height, width)
                    .asBufferedImage();

            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ImageIO.write(asBufferedImage, fileExtentions, os);
            return new ByteArrayInputStream(os.toByteArray());

        } catch (IOException ex) {
            log.error("unable to resize file {*}", ex);
            throw new ResizeImageException("Unable to resize image {}: ", ex);
        }

    }

}
