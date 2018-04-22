package cafe.lavilla.food.menu.endpoint.factories;

import cafe.lavilla.food.menu.endpoint.MenuApiService;
import cafe.lavilla.food.menu.endpoint.impl.MenuApiServiceImpl;

public class MenuApiServiceFactory {

   private final static MenuApiService service = new MenuApiServiceImpl();

   public static MenuApiService getMenuApi()
   {
      return service;
   }
}
