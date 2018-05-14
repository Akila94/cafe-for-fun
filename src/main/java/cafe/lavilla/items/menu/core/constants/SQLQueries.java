package cafe.lavilla.items.menu.core.constants;

/**
 * Class that contains the SQL queries to access the database.
 */
public class SQLQueries {
    public static final String INSERT_SALAD_ITEM_QUERY =
            "INSERT INTO table_salads(NAME,DESCRIPTION,PRICE) VALUES(?,?,?);";
    public static final String INSERT_SALAD_IMAGE_QUERY = "UPDATE table_salads SET IMG_SOURCE=? WHERE ID=?;";
    public static final String DELETE_SALAD_ITEM_QUERY = "DELETE FROM table_salads WHERE ID=?;";
    public static final String UPDATE_SALAD_ITEM_QUERY =
            "UPDATE table_salads SET NAME=?,DESCRIPTION=?,PRICE=?,IMG_SOURCE=? WHERE ID=?;";
    public static final String GET_SALAD_ITEM_QUERY = "SELECT * FROM table_salads WHERE ID=?;";
    public static final String GET_SALAD_ITEMS_QUERY = "SELECT * FROM table_salads;";
    public static final String GET_LAST_INSERTED_SALAD_ID_QUERY = "SELECT last_insert_id() as id FROM table_salads " +
            "LIMIT 1;";

    public static final String DELETE_BREAKFAST_ITEM_QUERY = "DELETE FROM table_breakfast WHERE ID=?;";
    public static final String GET_BREAKFAST_ITEM_BY_ID = "SELECT * FROM table_breakfast WHERE ID=?;";
    public static final String GET_BREAKFAST_ITEMS_QUERY = "SELECT * FROM table_breakfast;";
    public static final String INSERT_BREAKFAST_ITEM_QUERY = "INSERT INTO table_breakfast(NAME,DESCRIPTION,PRICE," +
            "IMG_SOURCE) VALUES(?,?,?,?);";
    public static final String LAST_INSERTED_BREAKFAST_ID_QUERY = "SELECT last_insert_id() as id FROM table_breakfast" +
            "LIMIT 1;";
    public static final String UPDATE_BREAKFAST_ITEM_QUERY =
            "UPDATE table_breakfast SET NAME=?,DESCRIPTION=?,PRICE=?," +
                    "IMG_SOURCE=? WHERE ID=?;";

    public static final String INSERT_HOT_DRINK_QUERY =
            "INSERT INTO table_hot_drinks (NAME,DESCRIPTION,PRICE,IMG_SOURCE) VALUES(?,?,?,?);";
    public static final String UPDATE_HOT_DRINK_QUERY =
            "UPDATE table_hot_drinks SET NAME=?,DESCRIPTION=?,PRICE=?,IMG_SOURCE=? WHERE ID=?;";
    public static final String DELETE_HOT_DRINK_QUERY = "DELETE FROM table_hot_drinks WHERE ID=?;";
    public static final String GET_HOT_DRINK_BY_ID_QUERY = "SELECT * FROM table_hot_drinks WHERE ID=?;";
    public static final String GET_HOT_DRINKS_QUERY = "SELECT * FROM table_hot_drinks;";
    public static final String LAST_INSERTED_HOT_DRINK_ID_QUERY =
            "SELECT last_insert_id() as id FROM table_hot_drinks LIMIT 1;";

    public static final String INSERT_DESSERT_QUERY =
            "INSERT INTO table_desserts (NAME,DESCRIPTION,PRICE,IMG_SOURCE) VALUES(?,?,?,?);";
    public static final String UPDATE_DESSERT_QUERY =
            "UPDATE table_desserts SET NAME=?,DESCRIPTION=?,PRICE=?,IMG_SOURCE=? WHERE ID=?;";
    public static final String DELETE_DESSERT_QUERY = "DELETE FROM table_desserts WHERE ID=?;";
    public static final String GET_DESSERT_BY_ID_QUERY = "SELECT * FROM table_desserts WHERE ID=?;";
    public static final String GET_DESSERT_QUERY = "SELECT * FROM table_desserts;";
    public static final String LAST_INSERTED_DESSERTS_ID_QUERY =
            "SELECT last_insert_id() as id FROM table_desserts LIMIT 1;";

    public static final String INSERT_FRENCH_TOAST_QUERY =
            "INSERT INTO table_french_toast (NAME,DESCRIPTION,PRICE,IMG_SOURCE) VALUES(?,?,?,?);";
    public static final String UPDATE_FRENCH_TOAST_QUERY =
            "UPDATE table_french_toast SET NAME=?,DESCRIPTION=?,PRICE=?,IMG_SOURCE=? WHERE ID=?;";
    public static final String DELETE_FRENCH_TOAST_QUERY = "DELETE FROM table_french_toast WHERE ID=?;";
    public static final String GET_FRENCH_TOAST_BY_ID_QUERY = "SELECT * FROM table_french_toast WHERE ID=?;";
    public static final String GET_FRENCH_TOAST_QUERY = "SELECT * FROM table_french_toast;";
    public static final String LAST_INSERTED_FRENCH_TOAST_ID_QUERY =
            "SELECT last_insert_id() as id FROM table_french_toast LIMIT 1;";

    public static final String INSERT_MAIN_COURSE_QUERY =
            "INSERT INTO table_main_course (NAME,DESCRIPTION,PRICE,IMG_SOURCE) VALUES(?,?,?,?);";
    public static final String UPDATE_MAIN_COURSE_QUERY =
            "UPDATE table_main_course SET NAME=?,DESCRIPTION=?,PRICE=?,IMG_SOURCE=? WHERE ID=?;";
    public static final String DELETE_MAIN_COURSE_QUERY = "DELETE FROM table_main_course WHERE ID=?;";
    public static final String GET_MAIN_COURSE_BY_ID_QUERY = "SELECT * FROM table_main_course WHERE ID=?;";
    public static final String GET_MAIN_COURSE_QUERY = "SELECT * FROM table_main_course;";
    public static final String LAST_INSERTED_MAIN_COURSE_ID_QUERY =
            "SELECT last_insert_id() as id FROM table_main_course LIMIT 1;";

    public static final String INSERT_PAN_CAKES_QUERY =
            "INSERT INTO table_pan_cakes (NAME,DESCRIPTION,PRICE,IMG_SOURCE) VALUES(?,?,?,?);";
    public static final String UPDATE_PAN_CAKES_QUERY =
            "UPDATE table_pan_cakes SET NAME=?,DESCRIPTION=?,PRICE=?,IMG_SOURCE=? WHERE ID=?;";
    public static final String DELETE_PAN_CAKES_QUERY = "DELETE FROM table_pan_cakes WHERE ID=?;";
    public static final String GET_PAN_CAKES_BY_ID_QUERY = "SELECT * FROM table_pan_cakes WHERE ID=?;";
    public static final String GET_PAN_CAKES_QUERY = "SELECT * FROM table_pan_cakes;";
    public static final String LAST_INSERTED_PAN_CAKES_ID_QUERY =
            "SELECT last_insert_id() as id FROM table_pan_cakes LIMIT 1;";

    public static final String INSERT_PASTA_QUERY =
            "INSERT INTO table_pasta (NAME,DESCRIPTION,PRICE,IMG_SOURCE) VALUES(?,?,?,?);";
    public static final String UPDATE_PASTA_QUERY =
            "UPDATE table_pasta SET NAME=?,DESCRIPTION=?,PRICE=?,IMG_SOURCE=? WHERE ID=?;";
    public static final String DELETE_PASTA_QUERY = "DELETE FROM table_pasta WHERE ID=?;";
    public static final String GET_PASTA_BY_ID_QUERY = "SELECT * FROM table_pasta WHERE ID=?;";
    public static final String GET_PASTA_QUERY = "SELECT * FROM table_pasta;";
    public static final String LAST_INSERTED_PASTA_ID_QUERY =
            "SELECT last_insert_id() as id FROM table_pasta LIMIT 1;";

    public static final String INSERT_QUENCHERS_QUERY =
            "INSERT INTO table_quenchers (NAME,DESCRIPTION,PRICE,IMG_SOURCE) VALUES(?,?,?,?);";
    public static final String UPDATE_QUENCHERS_QUERY =
            "UPDATE table_quenchers SET NAME=?,DESCRIPTION=?,PRICE=?,IMG_SOURCE=? WHERE ID=?;";
    public static final String DELETE_QUENCHERS_QUERY = "DELETE FROM table_quenchers WHERE ID=?;";
    public static final String GET_QUENCHERS_BY_ID_QUERY = "SELECT * FROM table_quenchers WHERE ID=?;";
    public static final String GET_QUENCHERS_QUERY = "SELECT * FROM table_quenchers;";
    public static final String LAST_INSERTED_QUENCHERS_ID_QUERY =
            "SELECT last_insert_id() as id FROM table_quenchers LIMIT 1;";

    public static final String INSERT_STARTERS_QUERY =
            "INSERT INTO table_starters (NAME,DESCRIPTION,PRICE,IMG_SOURCE) VALUES(?,?,?,?);";
    public static final String UPDATE_STARTERS_QUERY =
            "UPDATE table_starters SET NAME=?,DESCRIPTION=?,PRICE=?,IMG_SOURCE=? WHERE ID=?;";
    public static final String DELETE_STARTERS_QUERY = "DELETE FROM table_starters WHERE ID=?;";
    public static final String GET_STARTERS_BY_ID_QUERY = "SELECT * FROM table_starters WHERE ID=?;";
    public static final String GET_STARTERS_QUERY = "SELECT * FROM table_starters;";
    public static final String LAST_INSERTED_STARTERS_ID_QUERY =
            "SELECT last_insert_id() as id FROM table_starters LIMIT 1;";

    public static final String INSERT_WAFFLES_QUERY =
            "INSERT INTO table_waffles (NAME,DESCRIPTION,PRICE,IMG_SOURCE) VALUES(?,?,?,?);";
    public static final String UPDATE_WAFFLES_QUERY =
            "UPDATE table_waffles SET NAME=?,DESCRIPTION=?,PRICE=?,IMG_SOURCE=? WHERE ID=?;";
    public static final String DELETE_WAFFLES_QUERY = "DELETE FROM table_waffles WHERE ID=?;";
    public static final String GET_WAFFLES_BY_ID_QUERY = "SELECT * FROM table_waffles WHERE ID=?;";
    public static final String GET_WAFFLES_QUERY = "SELECT * FROM table_waffles;";
    public static final String LAST_INSERTED_WAFFLES_ID_QUERY =
            "SELECT last_insert_id() as id FROM table_waffles LIMIT 1;";

    //    new queries for new tables
    public static final String INSERT_CATEGORY_QUERY = "INSERT INTO TABLE_CATEGORY(CATEGORY_NAME) VALUES(?);";
    public static final String UPDATE_CATEGORY_QUERY = "UPDATE TABLE_CATEGORY SET CATEGORY_NAME=? WHERE CATEGORY_ID=?;";
    public static final String DELETE_CATEGORY_QUERY = "DELETE FROM TABLE_CATEGORY WHERE CATEGORY_ID=?;";
    public static final String GET_CATEGORIES_QUERY = "SELECT * FROM TABLE_CATEGORY;";
    public static final String GET_LAST_INSERTED_CATEGORY_ID_QUERY = "SELECT last_insert_id() as ID FROM " +
            "TABLE_CATEGORY LIMIT 1;";
    public static final String GET_CATEGORY_BY_ID_QUERY="SELECT * FROM TABLE_CATEGORY WHERE CATEGORY_ID=?;";

    public static final String INSERT_ITEM_QUERY = "INSERT INTO TABLE_ITEMS(CATEGORY_ID,ITEM_NAME,DESCRIPTION,PRICE) " +
            "VALUES(?,?,?,?);";
    public static final String GET_LAST_INSERTED_ITEM_ID_QUERY="SELECT last_insert_id() as ID FROM TABLE_ITEMS;";
    public static final String INSERT_ITEM_IMAGE_QUERY = "UPDATE TABLE_ITEMS SET IMG_SOURCE=? WHERE ITEM_ID=?;";
    public static final String UPDATE_ITEM_QUERY = "UPDATE TABLE_ITEMS SET CATEGORY_ID=?,ITEM_NAME=?,DESCRIPTION=?," +
            "PRICE=?,IMG_SOURCE=? WHERE ITEM_ID=?;";
    public static final String UPDATE_ITEM_IMAGE_QUERY = "UPDATE TABLE_ITEMS SET IMG_SOURCE=? WHERE ITEM_ID=?;";
    public static final String DELETE_ITEM_QUERY = "DELETE FROM TABLE_ITEMS WHERE ITEM_ID=?;";
    public static final String DELETE_ITEM_BY_CATEGORY_QUERY="DELETE FROM TABLE_ITEMS WHERE CATEGORY_ID=?;";
    public static final String GET_ITEMS_QUERY =
            "SELECT A.*,B.ITEM_ID,B.ITEM_NAME,B.DESCRIPTION,B.PRICE,B.IMG_SOURCE " +
                    "FROM TABLE_CATEGORY as A, CAFE_LAVILLA_FOODS_DB.TABLE_ITEMS as B" +
                    "WHERE A.CATEGORY_ID=B.CATEGORY_ID ORDER BY B.CATEGORY_ID;";
    public static final String GET_ITEM_BY_ID_QUERY =
            "SELECT A.*,B.ITEM_ID,B.ITEM_NAME,B.DESCRIPTION,B.PRICE,B.IMG_SOURCE " +
            "FROM TABLE_CATEGORY as A, CAFE_LAVILLA_FOODS_DB.TABLE_ITEMS as B " +
            "WHERE A.CATEGORY_ID=B.CATEGORY_ID AND B.ITEM_ID=?;";
    public static final String GET_ITEMS_BY_CATEGORY_QUERY =
            "SELECT A.*,B.ITEM_ID,B.ITEM_NAME,B.DESCRIPTION,B.PRICE,B.IMG_SOURCE " +
                    "FROM TABLE_CATEGORY as A, CAFE_LAVILLA_FOODS_DB.TABLE_ITEMS as B " +
                    "WHERE A.CATEGORY_ID=B.CATEGORY_ID AND A.CATEGORY_ID=?;";
    public static final String GET_DELETED_ITEMS_QUERY="SELECT ITEM_ID,ITEM_NAME FROM TABLE_ITEMS WHERE CATEGORY_ID=?;";
}
