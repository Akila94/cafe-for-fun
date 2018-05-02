package cafe.lavilla.food.menu.core.constants;

/**
 * Class that contains the SQL queries to access the database.
 */
public class SQLQueries {
    public static final String INSERT_SALAD_ITEM_QUERY = "INSERT INTO TABLE_SALADS(NAME,ARABIC_NAME,DESCRIPTION," +
            "ARABIC_DESCRIPTION,PRICE,IMG_URL) VALUES(?,?,?,?,?);";
    public static final String DELETE_SALAD_ITEM_QUERY = "DELETE FROM TABLE_SALADS WHERE ID=?";
    public static final String UPDATE_SALAD_ITEM_QUERY = "UPDATE TABLE_SALADS SET NAME=?,ARABIC_NAME=?,DESCRIPTION=?," +
            "ARABIC_DESCRIPTION=?,PRICE=?,IMG_URL=?;";
    public static final String GET_SALAD_ITEM_QUERY = "SELECT * FROM TABLE_SALADS WHERE ID=?";
    public static final String GET_SALAD_ITEMS_QUERY = "SELECT * FROM TABLE_SALADS;";
    public static final String GET_LAST_INSERTED_SALAD_ID_QUERY = "SELECT last_inserted_id() as id FROM TABLE_SALADS " +
            "LIMIT 1;";
}
