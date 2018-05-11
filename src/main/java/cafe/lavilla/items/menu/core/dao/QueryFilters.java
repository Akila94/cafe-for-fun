package cafe.lavilla.items.menu.core.dao;

import cafe.lavilla.items.menu.core.constants.SQLQueries;

/**
 * Created by Shan Chathusanda on 4/24/2018.
 */
public class QueryFilters {

    public static String[] filterInsertQuery(String category) {

        String[] queries = new String[3];

        switch (category) {
            case "Breakfast":
                queries[0] = SQLQueries.INSERT_BREAKFAST_ITEM_QUERY;
                queries[1] = SQLQueries.LAST_INSERTED_BREAKFAST_ID_QUERY;
                break;
            case "Hot Drinks":
                queries[0] = SQLQueries.INSERT_HOT_DRINK_QUERY;
                queries[1] = SQLQueries.LAST_INSERTED_HOT_DRINK_ID_QUERY;
                break;
            case "Desserts":
                queries[0] = SQLQueries.INSERT_DESSERT_QUERY;
                queries[1] = SQLQueries.LAST_INSERTED_DESSERTS_ID_QUERY;
                break;
            case "French Toast":
                queries[0] = SQLQueries.INSERT_FRENCH_TOAST_QUERY;
                queries[1] = SQLQueries.LAST_INSERTED_FRENCH_TOAST_ID_QUERY;
                break;
            case "Main Course":
                queries[0] = SQLQueries.INSERT_MAIN_COURSE_QUERY;
                queries[1] = SQLQueries.LAST_INSERTED_MAIN_COURSE_ID_QUERY;
                break;
            case "Pancakes":
                queries[0] = SQLQueries.INSERT_PAN_CAKES_QUERY;
                queries[1] = SQLQueries.LAST_INSERTED_PAN_CAKES_ID_QUERY;
                break;
            case "Pasta":
                queries[0] = SQLQueries.INSERT_PASTA_QUERY;
                queries[1] = SQLQueries.LAST_INSERTED_PASTA_ID_QUERY;
                break;
            case "Quenchers":
                queries[0] = SQLQueries.INSERT_QUENCHERS_QUERY;
                queries[1] = SQLQueries.LAST_INSERTED_QUENCHERS_ID_QUERY;
                break;
            case "Salads":
                queries[0] = SQLQueries.INSERT_SALAD_ITEM_QUERY;
                queries[1] = SQLQueries.GET_LAST_INSERTED_SALAD_ID_QUERY;
                queries[2] = SQLQueries.INSERT_SALAD_IMAGE_QUERY;
                break;
            case "Starters":
                queries[0] = SQLQueries.INSERT_STARTERS_QUERY;
                queries[1] = SQLQueries.LAST_INSERTED_STARTERS_ID_QUERY;
                break;
            case "Waffles":
                queries[0] = SQLQueries.INSERT_WAFFLES_QUERY;
                queries[1] = SQLQueries.LAST_INSERTED_WAFFLES_ID_QUERY;
                break;
        }
        return queries;
    }

    public static String filterUpdateQuery(String category) {

        String updateQuery = null;

        switch (category) {
            case "Breakfast":
                updateQuery = SQLQueries.UPDATE_BREAKFAST_ITEM_QUERY;
                break;
            case "Hot Drinks":
                updateQuery = SQLQueries.UPDATE_HOT_DRINK_QUERY;
                break;
            case "Desserts":
                updateQuery = SQLQueries.UPDATE_DESSERT_QUERY;
                break;
            case "French Toast":
                updateQuery = SQLQueries.UPDATE_FRENCH_TOAST_QUERY;
                break;
            case "Main Course":
                updateQuery = SQLQueries.UPDATE_MAIN_COURSE_QUERY;
                break;
            case "Pancakes":
                updateQuery = SQLQueries.UPDATE_PAN_CAKES_QUERY;
                break;
            case "Pasta":
                updateQuery = SQLQueries.UPDATE_PASTA_QUERY;
                break;
            case "Quenchers":
                updateQuery = SQLQueries.UPDATE_QUENCHERS_QUERY;
                break;
            case "Salads":
                updateQuery = SQLQueries.UPDATE_SALAD_ITEM_QUERY;
                break;
            case "Starters":
                updateQuery = SQLQueries.UPDATE_STARTERS_QUERY;
                break;
            case "Waffles":
                updateQuery = SQLQueries.UPDATE_WAFFLES_QUERY;
                break;
        }
        return updateQuery;
    }

    public static String filterDeleteQuery(String category) {

        String deleteQuery = null;

        switch (category) {
            case "Breakfast":
                deleteQuery = SQLQueries.DELETE_BREAKFAST_ITEM_QUERY;
                break;
            case "Hot Drinks":
                deleteQuery = SQLQueries.DELETE_HOT_DRINK_QUERY;
                break;
            case "Desserts":
                deleteQuery = SQLQueries.DELETE_DESSERT_QUERY;
                break;
            case "French Toast":
                deleteQuery = SQLQueries.DELETE_FRENCH_TOAST_QUERY;
                break;
            case "Main Course":
                deleteQuery = SQLQueries.DELETE_MAIN_COURSE_QUERY;
                break;
            case "Pancakes":
                deleteQuery = SQLQueries.DELETE_PAN_CAKES_QUERY;
                break;
            case "Pasta":
                deleteQuery = SQLQueries.DELETE_PASTA_QUERY;
                break;
            case "Quenchers":
                deleteQuery = SQLQueries.DELETE_QUENCHERS_QUERY;
                break;
            case "Salads":
                deleteQuery = SQLQueries.DELETE_SALAD_ITEM_QUERY;
                break;
            case "Starters":
                deleteQuery = SQLQueries.DELETE_STARTERS_QUERY;
                break;
            case "Waffles":
                deleteQuery = SQLQueries.DELETE_WAFFLES_QUERY;
                break;
        }
        return deleteQuery;
    }

    public static String filterGetQuery(String category) {

        String getQuery = null;

        switch (category) {
            case "Breakfast":
                getQuery = SQLQueries.GET_BREAKFAST_ITEM_BY_ID;
                break;
            case "Hot Drinks":
                getQuery = SQLQueries.GET_HOT_DRINK_BY_ID_QUERY;
                break;
            case "Desserts":
                getQuery = SQLQueries.GET_DESSERT_BY_ID_QUERY;
                break;
            case "French Toast":
                getQuery = SQLQueries.GET_FRENCH_TOAST_BY_ID_QUERY;
                break;
            case "Main Course":
                getQuery = SQLQueries.GET_MAIN_COURSE_BY_ID_QUERY;
                break;
            case "Pancakes":
                getQuery = SQLQueries.GET_PAN_CAKES_BY_ID_QUERY;
                break;
            case "Pasta":
                getQuery = SQLQueries.GET_PASTA_BY_ID_QUERY;
                break;
            case "Quenchers":
                getQuery = SQLQueries.GET_QUENCHERS_BY_ID_QUERY;
                break;
            case "Salads":
                getQuery = SQLQueries.GET_SALAD_ITEM_QUERY;
                break;
            case "Starters":
                getQuery = SQLQueries.GET_STARTERS_BY_ID_QUERY;
                break;
            case "Waffles":
                getQuery = SQLQueries.GET_WAFFLES_BY_ID_QUERY;
                break;
        }
        return getQuery;
    }

    public static String filterGetAllQuery(String category) {

        String getAllQuery = null;

        switch (category) {
            case "Breakfast":
                getAllQuery = SQLQueries.GET_BREAKFAST_ITEMS_QUERY;
                break;
            case "Hot Drinks":
                getAllQuery = SQLQueries.GET_HOT_DRINKS_QUERY;
                break;
            case "Desserts":
                getAllQuery = SQLQueries.GET_DESSERT_QUERY;
                break;
            case "French Toast":
                getAllQuery = SQLQueries.GET_FRENCH_TOAST_QUERY;
                break;
            case "Main Course":
                getAllQuery = SQLQueries.GET_MAIN_COURSE_QUERY;
                break;
            case "Pancakes":
                getAllQuery = SQLQueries.GET_PAN_CAKES_QUERY;
                break;
            case "Pasta":
                getAllQuery = SQLQueries.GET_PASTA_QUERY;
                break;
            case "Quenchers":
                getAllQuery = SQLQueries.GET_QUENCHERS_QUERY;
                break;
            case "Salads":
                getAllQuery = SQLQueries.GET_SALAD_ITEMS_QUERY;
                break;
            case "Starters":
                getAllQuery = SQLQueries.GET_STARTERS_QUERY;
                break;
            case "Waffles":
                getAllQuery = SQLQueries.GET_WAFFLES_QUERY;
                break;
        }
        return getAllQuery;
    }
}
