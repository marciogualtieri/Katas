package katas.modeling.supermarket.pricing.entities;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.math.BigDecimal;

public class Purchase {
    private final Product product;
    private final BigDecimal quantity;

    public Purchase(Product product, float quantity) {
        this.product = product;
        this.quantity = BigDecimal.valueOf(quantity).setScale(2, BigDecimal.ROUND_DOWN);
    }

    public Product getProduct() {
        return product;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public BigDecimal calculatePrice() {
        return product.getPricePerUnit()
                .multiply(quantity)
                .subtract(calculateDiscount());
    }

    private BigDecimal calculateDiscount() {
        return product.getPromotionalOffer()
                .calculateDiscount(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Purchase other = (Purchase) obj;
        return Objects.equal(this.product, other.product);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("product", product)
                .add("quantity", quantity)
                .toString();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(
                this.product, this.quantity);

    }
}
