package test.kata.game.fizzbuzz.checkers.impl;

import kata.game.fizzbuzz.checkers.Checker;
import kata.game.fizzbuzz.checkers.impl.FizzChecker;
import kata.game.fizzbuzz.constants.FizzBuzzConstants;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.text.IsEmptyString.isEmptyString;

public class FizzCheckerTest {

    private Checker testFizzChecker;

    @Before
    public void before() throws Exception {
        testFizzChecker = new FizzChecker(null, new StringBuffer());
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void whenNumberIsDivadableByThree_thenResultIsFizz() throws Exception {
        String result = testFizzChecker.getResult(3);
        assertThat(result, equalTo(FizzBuzzConstants.FIZZ));
    }

    @Test
    public void whenNumberIsNotDivadableByTree_thenResultIsEmpty() throws Exception {
        String result = testFizzChecker.getResult(7);
        assertThat(result, isEmptyString());
    }

} 
