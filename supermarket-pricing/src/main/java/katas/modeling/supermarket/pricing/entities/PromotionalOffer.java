package katas.modeling.supermarket.pricing.entities;

import java.math.BigDecimal;

public interface PromotionalOffer {

    BigDecimal calculateDiscount(Purchase purchase);
}
