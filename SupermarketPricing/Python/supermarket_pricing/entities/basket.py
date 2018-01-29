from purchase import Purchase


class Basket:

    def __init__(self):
        self.purchases = {}

    def purchase(self, product, units=1):
        if product.code in self.purchases:
            self.purchases[product.code].units += units
        else:
            self.purchases[product.code] = Purchase(product, units)

    def checkout(self):
        return self.__total__() - self.__discount__()

    def __total__(self):
        return sum([purchase.product.price_per_unit * purchase.units
                    for purchase in self.purchases.values()])

    def __discount__(self):
        return sum([purchase.product.promotional_offer.discount(purchase)
                    for purchase in self.purchases.values()
                    if purchase.product.promotional_offer is not None])
