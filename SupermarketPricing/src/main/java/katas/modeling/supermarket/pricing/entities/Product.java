package katas.modeling.supermarket.pricing.entities;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.math.BigDecimal;

public class Product {
    private final int id;
    private final String description;
    private final BigDecimal pricePerUnit;
    private final PromotionalOffer promotionalOffer;

    public Product(int id, String description, float pricePerUnit, PromotionalOffer promotionalOffer) {
        this.id = id;
        this.description = description;
        this.pricePerUnit = BigDecimal.valueOf(pricePerUnit).setScale(2, BigDecimal.ROUND_DOWN);
        this.promotionalOffer = promotionalOffer;
    }

    public BigDecimal getPricePerUnit() {
        return pricePerUnit;
    }

    public PromotionalOffer getPromotionalOffer() {
        return promotionalOffer;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Product other = (Product) obj;
        return Objects.equal(this.id, other.id);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("description", description)
                .add("pricePerUnit", pricePerUnit)
                .toString();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(
                this.id);

    }
}
