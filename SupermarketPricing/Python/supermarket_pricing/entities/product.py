class Product:

    def __init__(self, code, name, price_per_unit, promotional_offer=None):
        self.code = code
        self.name = name
        self.price_per_unit = price_per_unit
        self.promotional_offer = promotional_offer

    def __eq__(self, other):
        return self.code == other.code
