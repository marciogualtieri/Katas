from unittest import TestCase
from decimal import Decimal
from supermarket_pricing.entities.basket import Basket
from supermarket_pricing.entities.product import Product
from supermarket_pricing.entities.purchase import Purchase
from supermarket_pricing.entities.promotional_offer import HalfPriceOffer, XForPriceOffer, XForYOffer

AVOCADO = Product(code=1, name='Avocado (Loose)', price_per_unit=Decimal(1))

EGGS = Product(code=2, name='Eggs (Dozen)', price_per_unit=Decimal(2))

KALE_AT_HALF_PRICE = Product(code=3, name='Kale (300g)', price_per_unit=Decimal(3),
                             promotional_offer=HalfPriceOffer())

APPLE_AT_3_FOR_PRICE_10 = Product(code=4, name='Apple (Loose)', price_per_unit=Decimal(4),
                                  promotional_offer=XForPriceOffer(x=3, price=Decimal(10)))

MANGO_AT_3_FOR_2 = Product(code=5, name='Mango (Loose)', price_per_unit=Decimal(5),
                           promotional_offer=XForYOffer(x=3, y=2))

AVOCADO_PURCHASE = Purchase(AVOCADO, Decimal(1))
EGGS_PURCHASE = Purchase(EGGS, Decimal(2))
KALE_PURCHASE = Purchase(KALE_AT_HALF_PRICE, Decimal(3))
APPLE_PURCHASE = Purchase(APPLE_AT_3_FOR_PRICE_10, Decimal(4))
MANGO_PURCHASE = Purchase(MANGO_AT_3_FOR_2, Decimal(5))

PURCHASES_WITHOUT_PROMOTIONAL_OFFERS = {AVOCADO_PURCHASE.product.code: AVOCADO_PURCHASE,
                                        EGGS_PURCHASE.product.code: EGGS_PURCHASE}

PURCHASES_WITH_HALF_PRICE_OFFER = {AVOCADO_PURCHASE.product.code: AVOCADO_PURCHASE,
                                   KALE_PURCHASE.product.code: KALE_PURCHASE}

PURCHASES_WITH_3_FOR_PRICE_10_OFFER = {AVOCADO_PURCHASE.product.code: AVOCADO_PURCHASE,
                                       APPLE_PURCHASE.product.code: APPLE_PURCHASE}

PURCHASES_WITH_3_FOR_2_OFFER = {AVOCADO_PURCHASE.product.code: AVOCADO_PURCHASE,
                                MANGO_PURCHASE.product.code: MANGO_PURCHASE}


class TestBasket(TestCase):
    def setUp(self):
        self.basket = Basket()

    def test_basket_created(self):
        self.assertEqual(len(self.basket.purchases), 0)

    def test_product_added_to_basket(self):
        self.basket.purchase(AVOCADO)
        self.assertEqual(self.basket.purchases, {AVOCADO_PURCHASE.product.code: AVOCADO_PURCHASE})

    def test_product_added_multiple_times_to_basket(self):
        self.basket.purchase(AVOCADO, 2)
        self.basket.purchase(AVOCADO, 3)
        self.assertEqual(self.basket.purchases, {AVOCADO_PURCHASE.product.code: Purchase(AVOCADO, Decimal(5))})
        print self.basket.purchases

    def test_checkout_without_promotional_offers(self):
        add_purchases_to_basket(PURCHASES_WITHOUT_PROMOTIONAL_OFFERS, self.basket)
        self.assertEqual(self.basket.purchases, PURCHASES_WITHOUT_PROMOTIONAL_OFFERS)
        self.assertEqual(self.basket.checkout(), Decimal(5))

    def test_checkout_with_half_price_offer(self):
        add_purchases_to_basket(PURCHASES_WITH_HALF_PRICE_OFFER, self.basket)
        self.assertEqual(self.basket.purchases, PURCHASES_WITH_HALF_PRICE_OFFER)
        self.assertEqual(self.basket.checkout(), Decimal(5.5))

    def test_checkout_with_x_for_price_offer(self):
        add_purchases_to_basket(PURCHASES_WITH_3_FOR_PRICE_10_OFFER, self.basket)
        self.assertEqual(self.basket.purchases, PURCHASES_WITH_3_FOR_PRICE_10_OFFER)
        self.assertEqual(self.basket.checkout(), Decimal(15))

    def test_checkout_with_x_for_y_offer(self):
        add_purchases_to_basket(PURCHASES_WITH_3_FOR_2_OFFER, self.basket)
        self.assertEqual(self.basket.purchases, PURCHASES_WITH_3_FOR_2_OFFER)
        self.assertEqual(self.basket.checkout(), Decimal(21))


def add_purchases_to_basket(purchases, basket):
    for purchase in purchases.values():
        basket.purchase(purchase.product, purchase.units)
