# Supermarket Pricing

## Overview

Given the [instructions from Dave Thomas](http://codekata.com/kata/kata01-supermarket-pricing/), this kata is greatly
focused on modeling, so first of all follows a class diagram of my solution:

![](https://g.gravizo.com/source/custom_mark1?https%3A%2F%2Fraw.githubusercontent.com%2Fmarciogualtieri%2FKatas%2Fmaster%2FSupermarketPricing%2FPython%2FREADME.md)

<details>
<summary></summary>
custom_mark1
    /**
     *@opt all
     *@composed 1 Has n Purchase
     */
    class Basket {
        public void purchase(Product product, float units);
        public Collection purchases;
    }
    /**
    *@opt all
    *@composed 1 Has 1 Product
    */
    class Purchase {
        public Product product;
        public decimal units;
        public decimal checkout();
        private decimal __discount__();
    }
    /**
    *@opt all
    *@composed 1 Has 1 PromotionalOffer
    */
    class Product {
        public decimal price_per_unit;
        public PromotionalOffer promotional_offer;
    }
    /**
    *@opt all
    */
    interface PromotionalOffer {
        public decimal discount(Purchase purchase);
    }
    /**
    *@opt all
    */
    class HalfPriceOffer implements PromotionalOffer {}
    /**
    *@opt all
    */
    class XForThePriceOfYOffer implements PromotionalOffer {}
    /**
    *@opt all
    */
    class XForPrice implements PromotionalOffer {}
custom_mark1
</details>

This implementation is based on my previous [Java solution](https://github.com/marciogualtieri/Katas/tree/master/SupermarketPricing/Java). Refer to this project for details on the design. The purpose of this project is practice of basic Python OOP.

## Running Tests

To run alll tests, type the following command:

    nosetests -vv