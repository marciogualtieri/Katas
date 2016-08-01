package utils;

import katas.modeling.supermarket.pricing.entities.Basket;
import katas.modeling.supermarket.pricing.entities.Product;
import katas.modeling.supermarket.pricing.entities.Purchase;
import katas.modeling.supermarket.pricing.promotionaloffers.HalfPriceOffer;
import katas.modeling.supermarket.pricing.promotionaloffers.NoPromotionalOffer;
import katas.modeling.supermarket.pricing.promotionaloffers.XForPrice;
import katas.modeling.supermarket.pricing.promotionaloffers.XForThePriceOfYOffer;

public class TestHelper {

    public static final int STRAWBERRIES_ID = 1;
    public static final int TWO_FOR_ONE_BANANA_ID = 2;
    public static final int THREE_FOR_TWO_BANANA_ID = 3;
    public static final int HALF_PRICE_APPLE_ID = 4;
    public static final int TWO_FOR_PRICE_GRAPES_ID = 5;

    public static final Product STRAWBERRIES =
            new Product(STRAWBERRIES_ID, "Keelings Strawberry 227G", 2.99f, new NoPromotionalOffer());

    public static final Product TWO_FOR_ONE_BANANA =
            new Product(TWO_FOR_ONE_BANANA_ID, "Tesco Ripe Bananas 5 pack", 1.99f, new XForThePriceOfYOffer(2, 1));

    public static final Product SAME_TWO_FOR_ONE_BANANA = new Product(2, "Tesco Ripe Bananas 5 pack", 1.99f, null);

    public static final Product THREE_FOR_TWO_BANANA =
            new Product(THREE_FOR_TWO_BANANA_ID, "Tesco Goodness Fun-Size Bananas", 1.56f,
                    new XForThePriceOfYOffer(3, 2));

    public static final Product HALF_PRICE_APPLE =
            new Product(HALF_PRICE_APPLE_ID, "Tesco Bramley Apples Loose", 0.4f, new HalfPriceOffer());

    public static final Product TWO_FOR_PRICE_GRAPES =
            new Product(TWO_FOR_PRICE_GRAPES_ID, "Tesco Red Seedless Grapes 500G", 2.19f, new XForPrice(2, 4f));

    public static final Purchase TWO_FOR_ONE_BANANA_PURCHASE = new Purchase(TWO_FOR_ONE_BANANA, 1);
    public static final Purchase SAME_TWO_FOR_ONE_BANANA_PURCHASE = new Purchase(TWO_FOR_ONE_BANANA, 1);
    public static final Purchase THREE_FOR_TWO_BANANA_PURCHASE = new Purchase(THREE_FOR_TWO_BANANA, 1);

    public static final Basket BASKET = createTestBasket();

    private static Basket createTestBasket() {
        Basket basket = new Basket();
        basket.addPurchase(TWO_FOR_ONE_BANANA);
        basket.addPurchase(THREE_FOR_TWO_BANANA);
        return basket;
    }

    private TestHelper() {
    }
}
