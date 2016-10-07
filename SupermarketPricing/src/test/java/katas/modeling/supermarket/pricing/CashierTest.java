package katas.modeling.supermarket.pricing;

import katas.modeling.supermarket.pricing.entities.Cashier;
import org.junit.Before;
import org.junit.Test;
import utils.TestProductRepository;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static utils.TestHelper.*;

public class CashierTest {

    private Cashier cashier;

    private final Cashier.ProductRepository repository = new TestProductRepository();

    @Before
    public void before() throws Exception {
        cashier = new Cashier(repository);
    }

    @Test
    public void whenCashierScanProducts() throws Exception {
        cashier.scanProduct(TWO_FOR_ONE_BANANA_ID);
        cashier.scanProduct(THREE_FOR_TWO_BANANA_ID);
        assertThat(cashier.getBasket(), equalTo(BASKET));
    }

    @Test
    public void whenCashierChecksOut() throws Exception {
        cashier.scanProduct(STRAWBERRIES_ID);
        cashier.scanProduct(TWO_FOR_ONE_BANANA_ID);
        cashier.scanProduct(THREE_FOR_TWO_BANANA_ID);
        BigDecimal total = STRAWBERRIES.getPricePerUnit();
        total = total.add(TWO_FOR_ONE_BANANA.getPricePerUnit());
        total = total.add(THREE_FOR_TWO_BANANA.getPricePerUnit());
        total = total.setScale(2, BigDecimal.ROUND_DOWN);
        assertThat(cashier.checkout(), equalTo(total));
    }

    @Test
    public void whenCashierChecksOutTwoForThePriceOfOne() throws Exception {
        cashier.scanProduct(TWO_FOR_ONE_BANANA_ID, 3);
        BigDecimal total = TWO_FOR_ONE_BANANA.getPricePerUnit()
                .multiply(BigDecimal.valueOf(2))
                .setScale(2, BigDecimal.ROUND_DOWN);
        assertThat(cashier.checkout(),
                equalTo(total));
    }

    @Test
    public void whenCashierChecksOutThreeForThePriceOfTwo() throws Exception {
        cashier.scanProduct(THREE_FOR_TWO_BANANA_ID, 4);
        BigDecimal total = THREE_FOR_TWO_BANANA.getPricePerUnit()
                .multiply(BigDecimal.valueOf(3))
                .setScale(2, BigDecimal.ROUND_DOWN);
        assertThat(cashier.checkout(),
                equalTo(total));
    }

    @Test
    public void whenCashierChecksOutHalfPriceProduct() throws Exception {
        cashier.scanProduct(HALF_PRICE_APPLE_ID, 4);
        BigDecimal total = HALF_PRICE_APPLE.getPricePerUnit()
                .multiply(BigDecimal.valueOf(2))
                .setScale(2, BigDecimal.ROUND_DOWN);
        assertThat(cashier.checkout(),
                equalTo(total));
    }

    @Test
    public void whenCashierChecksOutTwoForPriceProduct() throws Exception {
        cashier.scanProduct(TWO_FOR_PRICE_GRAPES_ID, 2);
        BigDecimal total = BigDecimal.valueOf(4f)
                .setScale(2, BigDecimal.ROUND_DOWN);
        assertThat(cashier.checkout(),
                equalTo(total));
    }

}
