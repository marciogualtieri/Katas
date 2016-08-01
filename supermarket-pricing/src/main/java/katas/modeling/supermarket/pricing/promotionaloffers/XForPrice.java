package katas.modeling.supermarket.pricing.promotionaloffers;

import katas.modeling.supermarket.pricing.entities.PromotionalOffer;
import katas.modeling.supermarket.pricing.entities.Purchase;

import java.math.BigDecimal;

public class XForPrice implements PromotionalOffer {

    private final int x;
    private final BigDecimal price;

    public XForPrice(int x, float price) {
        this.x = x;
        this.price = BigDecimal.valueOf(price).setScale(2, BigDecimal.ROUND_DOWN);
    }

    @Override
    public BigDecimal calculateDiscount(Purchase purchase) {
        int groupsOfSizeX = purchase.getQuantity().intValue() / x;
        BigDecimal discount = BigDecimal.valueOf(0f);
        for(int i = 0; i < groupsOfSizeX; i++)
            discount = discount.add(purchase.getProduct().getPricePerUnit())
                    .multiply(purchase.getQuantity());
        return discount.subtract(price);
    }
}
