package cafe.lavilla.items.menu.core.imageconverter;

import cafe.lavilla.items.menu.core.constants.FoodMenuConstants;
import cafe.lavilla.items.menu.core.exception.FoodItemException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

/**
 * Class that save the image in a directory.
 */
public class ImageDecoder {

    public List<String> saveImage(InputStream inputStream, String category, int id) throws FoodItemException {

        List<String> imageDetails = new ArrayList<>();
        Random random = new Random();
        String randomNum = null;

        String dirPath;
        String imagePath;
        if (Objects.equals(category, FoodMenuConstants.CommonConstants.TMP_ID)) {
            randomNum = String.valueOf(random.nextInt(100) + 1);
            dirPath = FoodMenuConstants.CommonConstants.TMP_IMAGE_DIRECTORY_PATH;
            imagePath = dirPath + category + randomNum + FoodMenuConstants.CommonConstants.IMAGE_EXT;
        } else {
            String imageName = String.valueOf(id);
            dirPath = FoodMenuConstants.CommonConstants.IMAGE_DIRECTORY_PATH;
            imagePath = setImagePath(dirPath, imageName);
        }

        File directory = new File(dirPath);
        if (!directory.exists()) {
            if (directory.mkdir()) {
                directory.canExecute();
                directory.canRead();
                directory.canWrite();
            }
        }

        try {
            OutputStream outputStream = new FileOutputStream(new File(imagePath));
            int read;
            byte[] bytes = new byte[1024];
            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
            outputStream.flush();
            outputStream.close();
            if (Objects.equals(category, FoodMenuConstants.CommonConstants.TMP_ID)) {
                imageDetails.add(FoodMenuConstants.CommonConstants.TMP_IMAGE_SERVER_URL + category + randomNum +
                        FoodMenuConstants.CommonConstants.IMAGE_EXT);
                imageDetails.add(category + randomNum + FoodMenuConstants.CommonConstants.IMAGE_EXT);
            } else {
                imageDetails.add(imagePath);
                File tmpDir = new File(FoodMenuConstants.CommonConstants.TMP_IMAGE_DIRECTORY_PATH);
                if (tmpDir.exists()) {
                    if (tmpDir.list().length != 0) {
                        String[] files = tmpDir.list();
                        for (String temp : files) {
                            File fileDelete = new File(tmpDir, temp);
                            fileDelete.delete();
                        }
                    }
                }
            }
        } catch (IOException e) {
            throw new FoodItemException(
                    FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_ADD_IMAGE_FAILURE.getErrorMessage(),
                    FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_ADD_IMAGE_FAILURE.getErrorCode(), e);
        }
        return imageDetails;
    }

    private String setImagePath(String dirPath, String imageId) {

        return dirPath + imageId + FoodMenuConstants.CommonConstants.IMAGE_EXT;
    }
}
