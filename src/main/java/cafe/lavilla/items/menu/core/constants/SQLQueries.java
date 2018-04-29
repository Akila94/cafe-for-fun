package cafe.lavilla.items.menu.core.constants;

/**
 * Class that contains the SQL queries to access the database.
 */
public class SQLQueries {
    public static final String INSERT_SALAD_ITEM_QUERY =
            "INSERT INTO TABLE_SALADS(NAME,DESCRIPTION,PRICE,IMG_SOURCE) VALUES(?,?,?,?);";
    public static final String DELETE_SALAD_ITEM_QUERY = "DELETE FROM TABLE_SALADS WHERE ID=?";
    public static final String UPDATE_SALAD_ITEM_QUERY =
            "UPDATE TABLE_SALADS SET NAME=?,DESCRIPTION=?,PRICE=?,IMG_SOURCE=?;";
    public static final String GET_SALAD_ITEM_QUERY = "SELECT * FROM TABLE_SALADS WHERE ID=?";
    public static final String GET_SALAD_ITEMS_QUERY = "SELECT * FROM TABLE_SALADS;";
    public static final String GET_LAST_INSERTED_SALAD_ID_QUERY = "SELECT last_inserted_id() as id FROM TABLE_SALADS " +
            "LIMIT 1;";

    public static final String DELETE_BREAKFAST_ITEM_QUERY = "DELETE FROM TABLE_BREAKFAST WHERE ID=?;";
    public static final String GET_BREAKFAST_ITEM_BY_ID = "SELECT * FROM TABLE_BREAKFAST WHERE ID=?;";
    public static final String GET_BREAKFAST_ITEMS_QUERY = "SELECT * FROM TABLE_BREAKFAST;";
    public static final String INSERT_BREAKFAST_ITEM_QUERY = "INSERT INTO TABLE_BREAKFAST(NAME,DESCRIPTION,PRICE," +
            "IMG_SOURCE) VALUES(?,?,?,?);";
    public static final String LAST_INSERTED_BREAKFAST_ID_QUERY="SELECT last_inserted_id() as id FROM TABLE_BREAKFAST" +
            "LIMIT 1;";
    public static final String UPDATE_BREAKFAST_ITEM_QUERY="UPDATE TABLE_BREAKFAST SET NAME=?,DESCRIPTION=?,PRICE=?," +
            "IMG_SOURCE=?;";

    public static final String INSERT_HOT_DRINK_QUERY=
            "INSERT INTO TABLE_HOT_DRINKS (NAME,DESCRIPTION,PRICE,IMG_SOURCE) VALUES(?,?,?,?);";
    public static final String UPDATE_HOT_DRINK_QUERY=
            "UPDATE TABLE_HOT_DRINKS SET NAME=?,DESCRIPTION=?,PRICE=?,IMG_SOURCE=?;";
    public static final String DELETE_HOT_DRINK_QUERY="DELETE FROM TABLE_HOT_DRINKS WHERE ID=?;";
    public static final String GET_HOT_DRINK_BY_ID_QUERY="SELECT * FROM TABLE_HOT_DRINKS WHERE ID=?;";
    public static final String GET_HOT_DRINKS_QUERY="SELECT * FROM TABLE_HOT_DRINKS;";
    public static final String LAST_INSERTED_HOT_DRINK_ID_QUERY=
            "SELECT last_inserted_id() as id FROM TABLE_HOT_DRINKS LIMIT 1;";

    public static final String INSERT_DESSERT_QUERY=
            "INSERT INTO TABLE_DESSERTS (NAME,DESCRIPTION,PRICE,IMG_SOURCE) VALUES(?,?,?,?);";
    public static final String UPDATE_DESSERT_QUERY=
            "UPDATE TABLE_DESSERTS SET NAME=?,DESCRIPTION=?,PRICE=?,IMG_SOURCE=?;";
    public static final String DELETE_DESSERT_QUERY="DELETE FROM TABLE_DESSERTS WHERE ID=?;";
    public static final String GET_DESSERT_BY_ID_QUERY="SELECT * FROM TABLE_DESSERTS WHERE ID=?;";
    public static final String GET_DESSERT_QUERY="SELECT * FROM TABLE_DESSERTS;";
    public static final String LAST_INSERTED_DESSERTS_ID_QUERY=
            "SELECT last_inserted_id() as id FROM TABLE_DESSERTS LIMIT 1;";

    public static final String INSERT_FRENCH_TOAST_QUERY=
            "INSERT INTO TABLE_FRENCH_TOAST (NAME,DESCRIPTION,PRICE,IMG_SOURCE) VALUES(?,?,?,?);";
    public static final String UPDATE_FRENCH_TOAST_QUERY=
            "UPDATE TABLE_FRENCH_TOAST SET NAME=?,DESCRIPTION=?,PRICE=?,IMG_SOURCE=?;";
    public static final String DELETE_FRENCH_TOAST_QUERY="DELETE FROM TABLE_FRENCH_TOAST WHERE ID=?;";
    public static final String GET_FRENCH_TOAST_BY_ID_QUERY="SELECT * FROM TABLE_FRENCH_TOAST WHERE ID=?;";
    public static final String GET_FRENCH_TOAST_QUERY="SELECT * FROM TABLE_FRENCH_TOAST;";
    public static final String LAST_INSERTED_FRENCH_TOAST_ID_QUERY=
            "SELECT last_inserted_id() as id FROM TABLE_FRENCH_TOAST LIMIT 1;";

    public static final String INSERT_MAIN_COURSE_QUERY=
            "INSERT INTO TABLE_MAIN_COURSE (NAME,DESCRIPTION,PRICE,IMG_SOURCE) VALUES(?,?,?,?);";
    public static final String UPDATE_MAIN_COURSE_QUERY=
            "UPDATE TABLE_MAIN_COURSE SET NAME=?,DESCRIPTION=?,PRICE=?,IMG_SOURCE=?;";
    public static final String DELETE_MAIN_COURSE_QUERY="DELETE FROM TABLE_MAIN_COURSE WHERE ID=?;";
    public static final String GET_MAIN_COURSE_BY_ID_QUERY="SELECT * FROM TABLE_MAIN_COURSE WHERE ID=?;";
    public static final String GET_MAIN_COURSE_QUERY="SELECT * FROM TABLE_MAIN_COURSE;";
    public static final String LAST_INSERTED_MAIN_COURSE_ID_QUERY=
            "SELECT last_inserted_id() as id FROM TABLE_MAIN_COURSE LIMIT 1;";

    public static final String INSERT_PAN_CAKES_QUERY=
            "INSERT INTO TABLE_PAN_CAKES (NAME,DESCRIPTION,PRICE,IMG_SOURCE) VALUES(?,?,?,?);";
    public static final String UPDATE_PAN_CAKES_QUERY=
            "UPDATE TABLE_PAN_CAKES SET NAME=?,DESCRIPTION=?,PRICE=?,IMG_SOURCE=?;";
    public static final String DELETE_PAN_CAKES_QUERY="DELETE FROM TABLE_PAN_CAKES WHERE ID=?;";
    public static final String GET_PAN_CAKES_BY_ID_QUERY="SELECT * FROM TABLE_PAN_CAKES WHERE ID=?;";
    public static final String GET_PAN_CAKES_QUERY="SELECT * FROM TABLE_PAN_CAKES;";
    public static final String LAST_INSERTED_PAN_CAKES_ID_QUERY=
            "SELECT last_inserted_id() as id FROM TABLE_PAN_CAKES LIMIT 1;";

    public static final String INSERT_PASTA_QUERY=
            "INSERT INTO TABLE_PASTA (NAME,DESCRIPTION,PRICE,IMG_SOURCE) VALUES(?,?,?,?);";
    public static final String UPDATE_PASTA_QUERY=
            "UPDATE TABLE_PASTA SET NAME=?,DESCRIPTION=?,PRICE=?,IMG_SOURCE=?;";
    public static final String DELETE_PASTA_QUERY="DELETE FROM TABLE_PASTA WHERE ID=?;";
    public static final String GET_PASTA_BY_ID_QUERY="SELECT * FROM TABLE_PASTA WHERE ID=?;";
    public static final String GET_PASTA_QUERY="SELECT * FROM TABLE_PASTA;";
    public static final String LAST_INSERTED_PASTA_ID_QUERY=
            "SELECT last_inserted_id() as id FROM TABLE_PASTA LIMIT 1;";

    public static final String INSERT_QUENCHERS_QUERY=
            "INSERT INTO TABLE_QUENCHERS (NAME,DESCRIPTION,PRICE,IMG_SOURCE) VALUES(?,?,?,?);";
    public static final String UPDATE_QUENCHERS_QUERY=
            "UPDATE TABLE_QUENCHERS SET NAME=?,DESCRIPTION=?,PRICE=?,IMG_SOURCE=?;";
    public static final String DELETE_QUENCHERS_QUERY="DELETE FROM TABLE_QUENCHERS WHERE ID=?;";
    public static final String GET_QUENCHERS_BY_ID_QUERY="SELECT * FROM TABLE_QUENCHERS WHERE ID=?;";
    public static final String GET_QUENCHERS_QUERY="SELECT * FROM TABLE_QUENCHERS;";
    public static final String LAST_INSERTED_QUENCHERS_ID_QUERY=
            "SELECT last_inserted_id() as id FROM TABLE_QUENCHERS LIMIT 1;";

    public static final String INSERT_STARTERS_QUERY=
            "INSERT INTO TABLE_STARTERS (NAME,DESCRIPTION,PRICE,IMG_SOURCE) VALUES(?,?,?,?);";
    public static final String UPDATE_STARTERS_QUERY=
            "UPDATE TABLE_STARTERS SET NAME=?,DESCRIPTION=?,PRICE=?,IMG_SOURCE=?;";
    public static final String DELETE_STARTERS_QUERY="DELETE FROM TABLE_STARTERS WHERE ID=?;";
    public static final String GET_STARTERS_BY_ID_QUERY="SELECT * FROM TABLE_STARTERS WHERE ID=?;";
    public static final String GET_STARTERS_QUERY="SELECT * FROM TABLE_STARTERS;";
    public static final String LAST_INSERTED_STARTERS_ID_QUERY=
            "SELECT last_inserted_id() as id FROM TABLE_STARTERS LIMIT 1;";

    public static final String INSERT_WAFFLES_QUERY=
            "INSERT INTO TABLE_WAFFLES (NAME,DESCRIPTION,PRICE,IMG_SOURCE) VALUES(?,?,?,?);";
    public static final String UPDATE_WAFFLES_QUERY=
            "UPDATE TABLE_WAFFLES SET NAME=?,DESCRIPTION=?,PRICE=?,IMG_SOURCE=?;";
    public static final String DELETE_WAFFLES_QUERY="DELETE FROM TABLE_WAFFLES WHERE ID=?;";
    public static final String GET_WAFFLES_BY_ID_QUERY="SELECT * FROM TABLE_WAFFLES WHERE ID=?;";
    public static final String GET_WAFFLES_QUERY="SELECT * FROM TABLE_WAFFLES;";
    public static final String LAST_INSERTED_WAFFLES_ID_QUERY=
            "SELECT last_inserted_id() as id FROM TABLE_WAFFLES LIMIT 1;";
}
