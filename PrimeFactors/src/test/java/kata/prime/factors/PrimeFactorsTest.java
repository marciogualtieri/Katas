package kata.prime.factors;

import com.google.common.collect.ImmutableList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasSize;

public class PrimeFactorsTest {

    private PrimeFactors testPrimeFactors;
    private static final List<Integer> PRIME_NUMBERS = ImmutableList.of(2, 3, 5, 7, 11, 13, 17, 19, 23);

    @Before
    public void before() throws Exception {
        testPrimeFactors = new PrimeFactors();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void whenGenerateForOne_thenGetOne() throws Exception {
        List<Integer> primes = testPrimeFactors.generate(1);
        List<Integer> expectedPrimes = Arrays.asList(1);
        assertThat(primes, hasSize(0));
    }

    @Test
    public void whenGenerateForTwo_thenGetTwo() throws Exception {
        List<Integer> primes = testPrimeFactors.generate(2);
        List<Integer> expectedPrimes = Arrays.asList(2);
        assertThat(primes, containsInAnyOrder(expectedPrimes.toArray()));
    }

    @Test
    public void whenGenerateForThree_thenGetThree() throws Exception {
        List<Integer> primes = testPrimeFactors.generate(3);
        List<Integer> expectedPrimes = Arrays.asList(3);
        assertThat(primes, containsInAnyOrder(expectedPrimes.toArray()));
    }

    @Test
    public void whenGenerateForFour_thenGetTwoAndTwo() throws Exception {
        List<Integer> primes = testPrimeFactors.generate(4);
        List<Integer> expectedPrimes = Arrays.asList(2, 2);
        assertThat(primes, containsInAnyOrder(expectedPrimes.toArray()));
    }

    @Test
    public void whenGenerateForFive_thenGetFive() throws Exception {
        List<Integer> primes = testPrimeFactors.generate(5);
        List<Integer> expectedPrimes = Arrays.asList(5);
        assertThat(primes, containsInAnyOrder(expectedPrimes.toArray()));
    }

    @Test
    public void whenGenerateForSix_thenGetTwoAndThree() throws Exception {
        List<Integer> primes = testPrimeFactors.generate(6);
        List<Integer> expectedPrimes = Arrays.asList(2, 3);
        assertThat(primes, containsInAnyOrder(expectedPrimes.toArray()));
    }

    @Test
    public void whenGenerateForNine_thenGetThreeAndThree() throws Exception {
        List<Integer> primes = testPrimeFactors.generate(9);
        List<Integer> expectedPrimes = Arrays.asList(3, 3);
        assertThat(primes, containsInAnyOrder(expectedPrimes.toArray()));
    }

    @Test
    public void whenGenerateForPrimeListProduct_thenGetPrimeList() throws Exception {
        int number = multiplyFactors(PRIME_NUMBERS);
        List<Integer> primes = testPrimeFactors.generate(number);
        assertThat(primes, containsInAnyOrder(PRIME_NUMBERS.toArray()));
    }

    private int multiplyFactors(List<Integer> factors) {
        int result = 1;
        for (int factor : factors) {
            result *= factor;
        }
        return result;
    }
} 
