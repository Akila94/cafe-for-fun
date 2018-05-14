package cafe.lavilla.items.menu.core.constants;

/**
 * Class that contains the constants for the core module.
 */
public class FoodMenuConstants {
    /**
     * Enum that contains the error messages for the exceptions.
     */
    public enum ErrorMessages {
        ERROR_MESSAGE_ADD_CATEGORY_FAILURE("CL_1001", "Database error. Could not add the category to the database."),
        ERROR_MESSAGE_GET_CATEGORIES_FAILURE("CL_1002", "Database error. Could not get the categories."),
        ERROR_MESSAGE_GET_CATEGORY_FAILURE("CL_1003", "Database error. Could not get the category."),
        ERROR_MESSAGE_UPDATE_CATEGORY_FAILURE("CL_1004", "Database error. Could not update category."),
        ERROR_MESSAGE_DELETE_CATEGORY_FAILURE("CL_1005", "Database error. Could not delete category."),
        ERROR_MESSAGE_ADD_ITEM_FAILURE("CL_1006", "Database error. Could not add item to the database."),
        ERROR_MESSAGE_GET_ITEMS_FAILURE("CL_1007", "Database error. Could not get the items."),
        ERROR_MESSAGE_GET_ITEM_FAILURE("CL_1008", "Database error. Could not get the item."),
        ERROR_MESSAGE_UPDATE_ITEM_FAILURE("CL_1009", "Database error. Could not update the item to the database."),
        ERROR_MESSAGE_DELETE_ITEM_FAILURE("CL_1010", "Database error. Could not delete the item from the database."),
        ERROR_MESSAGE_ADD_IMAGE_FAILURE("CL_1011", "Image decoder error. Could not save the image."),
        ERROR_MESSAGE_DELETE_IMAGE_FAILURE("CL_1012", "Image decoder error. Could not delete the image of the item."),
        ERROR_MESSAGE_CREATE_PREP_STAT_FAILURE("CL_1100", "Could not create the prepared statement for the query."),
        ERROR_MESSAGE_GET_CONNECTION_FAILURE("CL_1102", "Could not get the db connection.");

        final String errorCode;
        final String errorMessage;

        ErrorMessages(String errorCode, String errorMessage) {
            this.errorCode = errorCode;
            this.errorMessage = errorMessage;
        }

        public String getErrorCode() {
            return errorCode;
        }

        public String getErrorMessage() {
            return errorMessage;
        }
    }

    public class CommonConstants {
        public static final String IMAGE_DIRECTORY_PATH = "/home/cafe-lavilla-food-menu-images/";
        public static final String TMP_IMAGE_DIRECTORY_PATH = "/home/cafe-lavilla-images-tmp/";
        public static final String IMAGE_SERVER_URL = "http://188.166.255.131:8080/cafe-lavilla/images/";
        public static final String TMP_IMAGE_SERVER_URL = "http://188.166.255.131:8080/cafe-lavilla/tmp/images/";
        public static final String IMAGE_EXT = ".jpeg";
        public static final String TMP_ID = "tmp";
    }
}
