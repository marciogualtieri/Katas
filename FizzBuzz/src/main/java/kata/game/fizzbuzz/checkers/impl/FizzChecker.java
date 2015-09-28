package kata.game.fizzbuzz.checkers.impl;

import kata.game.fizzbuzz.checkers.AbstractChecker;
import kata.game.fizzbuzz.checkers.Checker;
import kata.game.fizzbuzz.constants.FizzBuzzConstants;

public class FizzChecker extends AbstractChecker {

    public FizzChecker(Checker nextChecker, StringBuffer resultBuffer) {
        this.nextChecker = nextChecker;
        this.resultBuffer = resultBuffer;
    }

    @Override
    public String getResult(int number) {
        if (isFizz(number)) {
            resultBuffer.append(FizzBuzzConstants.FIZZ);
        }
        if (nextChecker != null) {
            return nextChecker.getResult(number);
        }
        return resultBuffer.toString();
    }

    private boolean isFizz(int number) {
        return number % 3 == 0;
    }
}
