package katas.modeling.supermarket.pricing;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static utils.TestHelper.*;

public class ProductTest {

    @Test
    public void whenSameProducts() throws Exception {
        assertThat(TWO_FOR_ONE_BANANA, equalTo(SAME_TWO_FOR_ONE_BANANA));
    }

    @Test
    public void wheDifferentProducts() throws Exception {
        assertThat(TWO_FOR_ONE_BANANA, not(equalTo(THREE_FOR_TWO_BANANA)));
    }

}
