package katas.modeling.supermarket.pricing.promotionaloffers;

import katas.modeling.supermarket.pricing.entities.PromotionalOffer;
import katas.modeling.supermarket.pricing.entities.Purchase;

import java.math.BigDecimal;

public class XForThePriceOfYOffer implements PromotionalOffer {

    private final int x;
    private final int y;

    public XForThePriceOfYOffer(int x, int y) {
        this.x = x;
        this.y = y;
        validate(x, y);
    }

    @Override
    public BigDecimal calculateDiscount(Purchase purchase) {
        int groupsOfSizeX = purchase.getQuantity().intValue() / x;
        BigDecimal discount = BigDecimal.valueOf(0f);
        for (int i = 0; i < groupsOfSizeX; i++)
            discount = discount.add(purchase.getProduct().getPricePerUnit())
                    .multiply(BigDecimal.valueOf((long) x - y));
        return discount;
    }

    public class XForThePriceOfYOfferValidationException extends RuntimeException {
        public XForThePriceOfYOfferValidationException(int x, int y) {
            super(String.format("%d for the price of %d is invalid", x, y));
        }
    }

    private void validate(int x, int y) {
        if (x <= 0 || y <= 0 || x <= y)
            throw new XForThePriceOfYOfferValidationException(x, y);
    }
}
