package katas.modeling.supermarket.pricing;

import katas.modeling.supermarket.pricing.entities.Basket;
import katas.modeling.supermarket.pricing.entities.Purchase;
import org.junit.Before;
import org.junit.Test;

import java.util.stream.IntStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static utils.TestHelper.*;

public class BasketTest {

    private Basket basket;

    @Before
    public void before() throws Exception {
        basket = new Basket();
    }

    @Test
    public void whenPurchaseProduct() throws Exception {
        basket.addPurchase(TWO_FOR_ONE_BANANA_PURCHASE.getProduct(),
                TWO_FOR_ONE_BANANA_PURCHASE.getQuantity().floatValue());
        assertThat(basket.getPurchases(), contains(TWO_FOR_ONE_BANANA_PURCHASE));
    }

    @Test
    public void whenPurchaseProductTwice() throws Exception {
        purchaseMultipleTimes(basket, TWO_FOR_ONE_BANANA_PURCHASE, 2);
        assertThat(basket.getPurchases(), contains(new Purchase(TWO_FOR_ONE_BANANA, 2)));
    }

    @Test
    public void whenPurchaseMultipleProducts() throws Exception {
        purchaseMultipleTimes(basket, TWO_FOR_ONE_BANANA_PURCHASE, 1);
        purchaseMultipleTimes(basket, THREE_FOR_TWO_BANANA_PURCHASE, 1);
        assertThat(basket.getPurchases(), containsInAnyOrder(TWO_FOR_ONE_BANANA_PURCHASE, THREE_FOR_TWO_BANANA_PURCHASE));
    }

    private void purchaseMultipleTimes(Basket basket, Purchase purchase, int times) {
        IntStream.rangeClosed(1, times)
                .forEach(time -> basket
                        .addPurchase(purchase.getProduct(), purchase.getQuantity().floatValue()));
    }

} 
