package taco.helper;

import org.togglz.core.Feature;
import org.togglz.core.annotation.Label;
import org.togglz.core.context.FeatureContext;

public enum FeatureFlags implements Feature {

    @Label("Discount on the pricing of tacos")
    DISCOUNT_APPLIED,

    @Label("When a product is finished")
    OUT_OF_STOCK;

    public boolean isActive() {
        return FeatureContext.getFeatureManager().isActive(this);
    }

}
