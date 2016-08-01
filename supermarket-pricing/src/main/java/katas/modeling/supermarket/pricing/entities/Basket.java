package katas.modeling.supermarket.pricing.entities;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Basket {

    private final Map<Product, Purchase> purchases = new HashMap<>();

    public void addPurchase(Product product, float quantity) {
        purchases.put(product, new Purchase(product, quantity));
    }

    public void addPurchase(Product product) {
        addPurchase(product, 1);
    }

    public Collection<Purchase> getPurchases() {
        return purchases.values();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Basket other = (Basket) obj;
        return Objects.equal(this.purchases, other.purchases);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("purchases", purchases)
                .toString();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(
                this.purchases);

    }
}
