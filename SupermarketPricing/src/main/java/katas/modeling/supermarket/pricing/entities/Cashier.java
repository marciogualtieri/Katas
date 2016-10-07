package katas.modeling.supermarket.pricing.entities;

import java.math.BigDecimal;

public class Cashier {

    private final ProductRepository repository;

    private final Basket basket = new Basket();

    public Cashier(ProductRepository repository) {
        this.repository = repository;
    }

    public void scanProduct(int productId) {
        scanProduct(productId, 1);
    }

    public void scanProduct(int productId, float quantity) {
        Product product = repository.getProductById(productId);
        basket.addPurchase(product, quantity);
    }

    public Basket getBasket() {
        return basket;
    }

    public BigDecimal checkout() {
        BigDecimal total = BigDecimal.valueOf(0f);
        for(Purchase purchase : basket.getPurchases()) {
            total = total.add(purchase.calculatePrice());
        }
        return total.setScale(2, BigDecimal.ROUND_DOWN);
    }

    public interface ProductRepository {
        Product getProductById(int id);
    }
}
