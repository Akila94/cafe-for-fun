package cafe.lavilla.food.menu.core.imageconverter;

import cafe.lavilla.food.menu.core.exception.FoodItemException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Decoder;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Class that decode the BASE64 image string to an image and save it in a directory.
 */
public class ImageDecoder {
    private static final Logger log = LoggerFactory.getLogger(ImageDecoder.class);

    public static String decodeImage(String imageString, String imageName) throws FoodItemException {
        BufferedImage image;
        byte[] imageByte;
        BASE64Decoder base64Decoder = new BASE64Decoder();
        String imagePath;

        try {
            imageByte = base64Decoder.decodeBuffer(imageString);
            ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
            image = ImageIO.read(bis);
            bis.close();
            imagePath = saveImage(image, imageName);
        } catch (IOException e) {
            throw new FoodItemException("Could not save the image", e.getMessage(), e);
        }
        return imagePath;
    }

    private static String saveImage(BufferedImage image, String imageName) throws IOException {
        String os = System.getProperty("os.name").toLowerCase();
        String userHome = System.getProperty("user.home");

        String dirPath = null;
        String imagePath = null;
        if (isWindows(os)) {
            dirPath = userHome + "\\cafe-lavilla-food-menu-images";
            imagePath = dirPath + "\\" + imageName;
        } else if (isLinux(os)) {
            dirPath = userHome + "/cafe-lavilla-food-menu-images";
            imagePath = dirPath + "/" + imageName;
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

        File imageFile = null;
        if (imagePath != null) {
            imageFile = new File(imagePath);
        }
        if (imageFile != null) {
            ImageIO.write(image, "jpeg", imageFile);
        }
        return imagePath;
    }

    private static boolean isWindows(String os) {
        return (os.contains("win"));
    }

    private static boolean isMac(String os) {
        return (os.contains("mac"));
    }

    private static boolean isLinux(String os) {
        return (os.contains("nux"));
    }


}
