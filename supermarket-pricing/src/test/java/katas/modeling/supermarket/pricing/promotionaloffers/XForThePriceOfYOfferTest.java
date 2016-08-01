package katas.modeling.supermarket.pricing.promotionaloffers;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class XForThePriceOfYOfferTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void whenXIsGreaterThenY_thenThrowException() throws Exception {
        thrown.expect(XForThePriceOfYOffer.XForThePriceOfYOfferValidationException.class);
        new XForThePriceOfYOffer(2, 3);
    }

    @Test
    public void whenXIsNegative_thenThrowException() throws Exception {
        thrown.expect(XForThePriceOfYOffer.XForThePriceOfYOfferValidationException.class);
        new XForThePriceOfYOffer(-2, 3);
    }

    @Test
    public void whenXIsZero_thenThrowException() throws Exception {
        thrown.expect(XForThePriceOfYOffer.XForThePriceOfYOfferValidationException.class);
        new XForThePriceOfYOffer(0, 3);
    }

    @Test
    public void whenYIsNegative_thenThrowException() throws Exception {
        thrown.expect(XForThePriceOfYOffer.XForThePriceOfYOfferValidationException.class);
        new XForThePriceOfYOffer(-5, -3);
    }

    @Test
    public void whenYIsZero_thenThrowException() throws Exception {
        thrown.expect(XForThePriceOfYOffer.XForThePriceOfYOfferValidationException.class);
        new XForThePriceOfYOffer(-5, 0);
    }

} 
