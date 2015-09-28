package kata.game.fizzbuzz;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class FizzBuzzTest {

    private static final String TEST_NOT_IMPLEMENTED_MESSAGE = "<test not implemented>";
    private FizzBuzz testFizzBuzz;

    @Before
    public void before() throws Exception {
        testFizzBuzz = new FizzBuzz();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void whenNumberDivadableByThree_ThenFizz() throws Exception {
        String result = testFizzBuzz.getResult(6);
        assertThat(result, equalTo(FizzBuzzConstants.FIZZ));
    }

    @Test
    public void whenNumberDivadableByFive_ThenBuzz() throws Exception {
        String result = testFizzBuzz.getResult(10);
        assertThat(result, equalTo(FizzBuzzConstants.BUZZ));
    }

    @Test
    public void whenNumberDivadableByThreeAndFive_ThenFizzBuzz() throws Exception {
        String result = testFizzBuzz.getResult(15);
        assertThat(result, equalTo(FizzBuzzConstants.FIZZBUZZ));
    }

    @Test
    public void whenNumberNotDivadableByThreeOrFive_ThenGetNumberAsString() throws Exception {
        int testNumber = 11;
        String result = testFizzBuzz.getResult(testNumber);
        assertThat(result, equalTo(Integer.toString(testNumber)));
    }
} 
