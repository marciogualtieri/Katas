class Purchase:

    def __init__(self, product, units):
        self.product = product
        self.units = units

    def __eq__(self, other):
        return self.product == other.product and \
               self.units == other.units
