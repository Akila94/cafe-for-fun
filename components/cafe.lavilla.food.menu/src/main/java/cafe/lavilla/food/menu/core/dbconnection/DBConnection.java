package cafe.lavilla.food.menu.core.dbconnection;

import cafe.lavilla.food.menu.core.constants.FoodMenuConstants;
import cafe.lavilla.food.menu.core.exception.FoodItemException;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Class that creates the connections to the database.
 */
public class DBConnection {

    public static Connection getDBConnection() throws FoodItemException {
        Connection connection;
        String pw = "root";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/CAFE_LAVILLA_FOODS_DB",
                    "root", pw);
        } catch (Exception e) {
            throw new FoodItemException(
                    FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_GET_CONNECTION_FAILURE.getErrorCode(),
                    FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_GET_CONNECTION_FAILURE.getErrorMessage(), e);
        }
        return connection;
    }
}
