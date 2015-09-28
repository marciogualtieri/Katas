package test.kata.game.fizzbuzz.checkers.impl;

import kata.game.fizzbuzz.checkers.Checker;
import kata.game.fizzbuzz.checkers.impl.BuzzChecker;
import kata.game.fizzbuzz.constants.FizzBuzzConstants;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.isEmptyString;

public class BuzzCheckerTest {
    private Checker testBuzzChecker;

    @Before
    public void before() throws Exception {
        testBuzzChecker = new BuzzChecker(null, new StringBuffer());
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void whenNumberIsDivadableByFive_thenResultIsBuzz() throws Exception {
        String result = testBuzzChecker.getResult(5);
        assertThat(result, equalTo(FizzBuzzConstants.BUZZ));
    }

    @Test
    public void whenNumberIsNotDivadableByFive_thenResultIsEmpty() throws Exception {
        String result = testBuzzChecker.getResult(7);
        assertThat(result, isEmptyString());
    }


} 
