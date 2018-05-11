package cafe.lavilla.items.menu.core.model;

import cafe.lavilla.items.menu.core.dao.impl.FoodItemDAOImpl;
import cafe.lavilla.items.menu.core.exception.FoodItemException;
import cafe.lavilla.items.menu.core.imageconverter.ImageDecoder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;
import java.util.Random;

/**
 * Created by shan.
 */
public class TestSalads {
    public static void main(String[] args) {
        File inputFile=new File("C:\\Users\\Shan Chathusanda\\Downloads\\lavilla\\Breakfast\\Morning Slider.jpeg");
//        try {
//            InputStream inputStream=new FileInputStream(inputFile);
//            ImageDecoder imageDecoder=new ImageDecoder();
//            imageDecoder.saveImage(inputStream,"Morning Slider");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (FoodItemException e) {
//            e.printStackTrace();
//        }

//        Random random = new Random();
//        String rand = String.valueOf(random.nextInt(50)+1);
//        System.out.println(rand);

        String name="French Toast";
        System.out.println(name.toLowerCase());
    }
}
