package katas.modeling.supermarket.pricing.promotionaloffers;

import katas.modeling.supermarket.pricing.entities.PromotionalOffer;
import katas.modeling.supermarket.pricing.entities.Purchase;

import java.math.BigDecimal;

public class NoPromotionalOffer implements PromotionalOffer {

    @Override
    public BigDecimal calculateDiscount(Purchase purchase) {
        return BigDecimal.valueOf(0f);
    }
}
