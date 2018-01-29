from abc import ABCMeta, abstractmethod
from decimal import Decimal


class PromotionalOffer:

    __metaclass__ = ABCMeta

    def __init__(self):
        pass

    @abstractmethod
    def discount(self, purchase):
        pass


class HalfPriceOffer(PromotionalOffer):

    def discount(self, purchase):
        return purchase.product.price_per_unit * Decimal(0.5) * purchase.units


class XForPriceOffer(PromotionalOffer):

    def __init__(self, x, price):
        super(PromotionalOffer, self).__init__()
        self.x = x
        self.price = price

    def discount(self, purchase):
        original_price = purchase.units * purchase.product.price_per_unit
        discount_price = (int(purchase.units) / self.x * self.price +
                          int(purchase.units) % self.x * purchase.product.price_per_unit)
        return original_price - discount_price


class XForYOffer(PromotionalOffer):

    def __init__(self, x, y):
        super(PromotionalOffer, self).__init__()
        self.x = x
        self.y = y

    def discount(self, purchase):
        discount_units = int(purchase.units) / self.x * self.y + int(purchase.units) % self.x
        return (purchase.units - discount_units) * purchase.product.price_per_unit
