package cafe.lavilla.items.menu.core.imageconverter;

import cafe.lavilla.items.menu.core.exception.FoodItemException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

/**
 * Class that decode the BASE64 image string to an image and save it in a directory.
 */
public class ImageDecoder {

    public List<String> saveImage(InputStream inputStream, String category, int id) throws FoodItemException {

        List<String> imageDetails = new ArrayList<>();
        Random random = new Random();
        String randomNum = null;

        String dirPath = null;
        String imagePath = null;
        if (Objects.equals(category, "tmp")) {
            randomNum = String.valueOf(random.nextInt(100) + 1);
            dirPath = "/home/cafe-lavilla-images-tmp";
            imagePath = dirPath + "/" + category + randomNum + ".jpeg";
        } else {
            String imageName = String.valueOf(id);
            switch (category) {
                case "Breakfast":
                    dirPath = setDirectoryPath(category.toLowerCase());
                    imagePath = setImagePath(dirPath, imageName);
                    break;
                case "Hot Drinks":
                    dirPath = setDirectoryPath(category.toLowerCase());
                    imagePath = setImagePath(dirPath, imageName);
                    break;
                case "Desserts":
                    dirPath = setDirectoryPath(category.toLowerCase());
                    imagePath = setImagePath(dirPath, imageName);
                    break;
                case "French Toast":
                    dirPath = setDirectoryPath(category.toLowerCase());
                    imagePath = setImagePath(dirPath, imageName);
                    break;
                case "Main Course":
                    dirPath = setDirectoryPath(category.toLowerCase());
                    imagePath = setImagePath(dirPath, imageName);
                    break;
                case "Pancakes":
                    dirPath = setDirectoryPath(category.toLowerCase());
                    imagePath = setImagePath(dirPath, imageName);
                    break;
                case "Pasta":
                    dirPath = setDirectoryPath(category.toLowerCase());
                    imagePath = setImagePath(dirPath, imageName);
                    break;
                case "Quenchers":
                    dirPath = setDirectoryPath(category.toLowerCase());
                    imagePath = setImagePath(dirPath, imageName);
                    break;
                case "Salads":
                    dirPath = setDirectoryPath(category.toLowerCase());
                    imagePath = setImagePath(dirPath, imageName);
                    break;
                case "Starters":
                    dirPath = setDirectoryPath(category.toLowerCase());
                    imagePath = setImagePath(dirPath, imageName);
                    break;
                case "Waffles":
                    dirPath = setDirectoryPath(category.toLowerCase());
                    imagePath = setImagePath(dirPath, imageName);
                    break;
            }
        }

        File directory = new File(dirPath);
        if (!directory.exists()) {
            directory.mkdir();
            directory.canExecute();
            directory.canRead();
            directory.canWrite();
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
            if (Objects.equals(category, "tmp")) {
                imageDetails.add("http://188.166.255.131:8080/cafe-lavilla/tmp/images/" + category + randomNum + "" +
                        ".jpeg");
                imageDetails.add(category + randomNum + ".jpeg");
            } else {
                imageDetails.add(imagePath);
            }
        } catch (IOException e) {
            throw new FoodItemException("Could not save the image", "error", e);
        }
        return imageDetails;
    }

    private String setDirectoryPath(String category) {

        return "/home/cafe-lavilla-food-menu-images/" + category;
    }

    private String setImagePath(String dirPath, String imageId) {

        return dirPath + "/" + imageId + ".jpeg";
    }
}
