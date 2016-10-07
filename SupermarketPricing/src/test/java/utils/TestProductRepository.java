package utils;

import katas.modeling.supermarket.pricing.entities.Cashier;
import katas.modeling.supermarket.pricing.entities.Product;

import java.util.HashMap;
import java.util.Map;

import static utils.TestHelper.*;

public class TestProductRepository implements Cashier.ProductRepository {

    private final Map<Integer, Product> products = new HashMap<>();

    public TestProductRepository() {
        products.put(STRAWBERRIES_ID, STRAWBERRIES);
        products.put(TWO_FOR_ONE_BANANA_ID, TWO_FOR_ONE_BANANA);
        products.put(THREE_FOR_TWO_BANANA_ID, THREE_FOR_TWO_BANANA);
        products.put(HALF_PRICE_APPLE_ID, HALF_PRICE_APPLE);
        products.put(TWO_FOR_PRICE_GRAPES_ID, TWO_FOR_PRICE_GRAPES);
    }

    public Product getProductById(int id) {
        return products.getOrDefault(id, null);
    }

}
