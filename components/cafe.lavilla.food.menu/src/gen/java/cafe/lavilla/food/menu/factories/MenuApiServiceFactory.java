package cafe.lavilla.food.menu.factories;

import cafe.lavilla.food.menu.MenuApiService;
import cafe.lavilla.food.menu.impl.MenuApiServiceImpl;

public class MenuApiServiceFactory {

   private final static MenuApiService service = new MenuApiServiceImpl();

   public static MenuApiService getMenuApi()
   {
      return service;
   }
}
