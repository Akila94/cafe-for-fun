package cafe.lavilla.items.menu.core.constants;

/**
 * Class that contains the constants for the core module.
 */
public class FoodMenuConstants {
    /**
     * Enum that contains the error messages for the exceptions.
     */
    public enum ErrorMessages {
        ERROR_MESSAGE_ADD_SALAD_ITEM_FAILURE("CL_1001", "Database error. Could not add the salad item to the database" +
                "."),
        ERROR_MESSAGE_GET_CATEGORIES_FAILURE("CL_1002", "Database error. Could not get the categories."),
        ERROR_MESSAGE_DELETE_SALAD_ITEM_FAILURE("CL_1004", "Database error. Could not delete the salad item."),
        ERROR_MESSAGE_UPDATE_SALAD_ITEM_FAILURE("CL_1005", "Database error. Could not update the salad item."),
        ERROR_MESSAGE_DELETE_SALAD_IMAGE_FAILURE("CL_1006", "Database error. Could not delete the image of the salad " +
                "item."),
        ERROR_MESSAGE_GET_BREAKFAST_ITEM_FAILURE("CL_1007", "Database error. Could not get the breakfast item."),
        ERROR_MESSAGE_DELETE_BREAKFAST_ITEM_FAILURE("CL_1008", "Database error. Could not delete the breakfast item"),
        ERROR_MESSAGE_DELETE_BREAKFAST_IMAGE_FAILURE("CL_1009", "Database error. Could not delete the image of the " +
                "breakfast item"),
        ERROR_MESSAGE_ADD_BREAKFAST_ITEM_FAILURE("CL_1010", "Database error. Could not add breakfast item."),
        ERROR_MESSAGE_GET_ITEMS_FAILURE("CL_1011", "Database error. Could not get the items."),
        ERROR_MESSAGE_CREATE_PREP_STAT_FAILURE("CL_1100", "Could not create the prepared statement for the query."),
        ERROR_MESSAGE_CREATE_RESULT_SET_FAILURE("CL_1101", "Could not create the result set for the query"),
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
}
