package cafe.lavilla.items.menu.factories;

import cafe.lavilla.items.menu.MenuApiService;
import cafe.lavilla.items.menu.impl.MenuApiServiceImpl;

public class MenuApiServiceFactory {

   private final static MenuApiService service = new MenuApiServiceImpl();

   public static MenuApiService getMenuApi()
   {
      return service;
   }
}
