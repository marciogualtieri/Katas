package katas.modeling.supermarket.pricing;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static utils.TestHelper.*;

public class PurchaseTest {

    @Test
    public void whenSamePurchase() throws Exception {
        assertThat(TWO_FOR_ONE_BANANA_PURCHASE, equalTo(SAME_TWO_FOR_ONE_BANANA_PURCHASE));
    }

    @Test
    public void wheDifferentPurchases() throws Exception {
        assertThat(TWO_FOR_ONE_BANANA_PURCHASE, not(equalTo(THREE_FOR_TWO_BANANA_PURCHASE)));
    }

}
