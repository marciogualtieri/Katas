package katas.modeling.supermarket.pricing.promotionaloffers;

import katas.modeling.supermarket.pricing.entities.PromotionalOffer;
import katas.modeling.supermarket.pricing.entities.Purchase;

import java.math.BigDecimal;

public class HalfPriceOffer implements PromotionalOffer {

    @Override
    public BigDecimal calculateDiscount(Purchase purchase) {
        BigDecimal discount = purchase.getProduct().getPricePerUnit();
        discount = discount.multiply(purchase.getQuantity());
        return discount.divide(BigDecimal.valueOf(2), BigDecimal.ROUND_UP);
    }
}
