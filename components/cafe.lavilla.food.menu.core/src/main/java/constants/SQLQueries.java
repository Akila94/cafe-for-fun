package constants;

/**
 * Class that contains the SQL queries to access the database.
 */
public class SQLQueries {
    public static final String INSERT_SALAD_ITEM_QUERY = "INSERT INTO TABLE_SALADS(NAME,DESCRIPTION," +
            "ARABIC_DESCRIPTION,PRICE,IMG_URL) VALUES(?,?,?,?,?);";
    public static final String GET_SALAD_ITEMS_QUERY = "SELECT * FROM TABLE_SALADS;";
}
