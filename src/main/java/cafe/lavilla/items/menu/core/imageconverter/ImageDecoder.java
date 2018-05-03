package cafe.lavilla.items.menu.core.imageconverter;

import cafe.lavilla.items.menu.core.exception.FoodItemException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * Class that decode the BASE64 image string to an image and save it in a directory.
 */
public class ImageDecoder {

    private static final Logger log = LoggerFactory.getLogger(ImageDecoder.class);

    private static boolean isWindows(String os) {

        return (os.contains("win"));
    }

    private static boolean isMac(String os) {

        return (os.contains("mac"));
    }

    private static boolean isLinux(String os) {

        return (os.contains("nux"));
    }

    public void saveImage(InputStream inputStream, String imageName) throws FoodItemException {

        String os = System.getProperty("os.name").toLowerCase();
        String userHome = System.getProperty("user.home");

        String dirPath = null;
        String imagePath = null;
        if (isWindows(os)) {
            dirPath = userHome + "\\cafe-lavilla-food-menu-images";
            imagePath = dirPath + "\\" + imageName +".jpeg";
        } else if (isLinux(os)) {
            dirPath = "/home/cafe-lavilla-food-menu-images";
            imagePath = dirPath + "/" + imageName +".jpeg";
        } else if (isMac(os)) {
            dirPath = userHome + "/cafe-lavilla-food-menu-images";
            imagePath = dirPath + "/" + imageName;
        } else {
            log.error("Unsupported operating system detected.");
        }

        File directory = null;
        if (dirPath != null) {
            directory = new File(dirPath);
        }
        if (directory != null && !directory.exists()) {
            directory.mkdir();
        }

        try {
            OutputStream outputStream = new FileOutputStream(new File(imagePath));
            int read = 0;
            byte[] bytes = new byte[1024];
            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            throw new FoodItemException("Could not save the image", "error", e);
        }
    }
}
