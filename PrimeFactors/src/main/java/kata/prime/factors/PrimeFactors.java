package kata.prime.factors;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactors {
    private static final int SMALLEST_PRIME_NUMBER = 2;

    public List<Integer> generate(int n) {
        List<Integer> primeFactors = new ArrayList<Integer>();
        int primeFactor = SMALLEST_PRIME_NUMBER;
        while(n > 1){
            List<Integer> factors = factorOutNumberFromNumber(n, primeFactor);
            n = factors.remove(factors.size()-1);
            primeFactors.addAll(factors);
            primeFactor = getNextPrimeFactor(primeFactor);
        }
        return primeFactors;
    }

    private List<Integer> factorOutNumberFromNumber(int number, int numberToFactorOut) {
        List<Integer> factors = new ArrayList<Integer>();
        while(number % numberToFactorOut == 0) {
            factors.add(numberToFactorOut);
            number /= numberToFactorOut;
        }
        factors.add(number);
        return factors;
    }

    /**
     * Cheating a little bit here...  I'm returning the next  integer instead o f the next
     * prime. But generating primes  is not an easy task and it doesn't matter here anyway.
     * Suppose that I just factored out 3.  The next number is 4, which cannot be factored
     * out anyway, since I already factored out 2.   The same goes to 6. Before 6, 2 and 3
     * have been factored out, so 6 cannot be a factor.  I'm paying the price of trying to
     * factor out numbers that cannot, but I would pay a higher price if I try to generate
     * all primes numbers (could use Sieve of Eratosthenes for instance).
     */
    private int getNextPrimeFactor(int primeFactor) {
        return ++primeFactor;
    }
}
