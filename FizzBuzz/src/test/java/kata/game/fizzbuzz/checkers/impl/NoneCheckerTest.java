package test.kata.game.fizzbuzz.checkers.impl;

import kata.game.fizzbuzz.checkers.Checker;
import kata.game.fizzbuzz.checkers.impl.NoneChecker;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class NoneCheckerTest {

    private Checker testNoneChecker;

    @Before
    public void before() throws Exception {
        testNoneChecker = new NoneChecker(new StringBuffer());
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void whenAnyNumber_thenResultIsNumberAsString() throws Exception {
        int testNumber = 3;
        String result = testNoneChecker.getResult(testNumber);
        assertThat(result, equalTo(Integer.toString(testNumber)));
    }

} 
