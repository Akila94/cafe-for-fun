package internal;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import service.FoodMenuCoreService;
import service.FoodMenuCoreServiceImpl;

/**
 * Class that register this component as an OSGi bundle.
 */
@Component(name = "cafe.lavilla.food.menu.core.internal.FoodMenuCoreComponent", immediate = true)
public class FoodMenuCoreComponent {
    @Activate
    protected void activate(BundleContext bundleContext) {
        bundleContext.registerService(FoodMenuCoreService.class, new FoodMenuCoreServiceImpl(), null);
    }
}
