package kata.game.fizzbuzz.checkers.impl;

import kata.game.fizzbuzz.checkers.AbstractChecker;
import kata.game.fizzbuzz.checkers.Checker;
import kata.game.fizzbuzz.constants.FizzBuzzConstants;

public class BuzzChecker extends AbstractChecker {

    public BuzzChecker(Checker nextChecker, StringBuffer resultBuffer) {
        this.nextChecker = nextChecker;
        this.resultBuffer = resultBuffer;
    }

    @Override
    public String getResult(int number) {
        if (isBuzz(number)) {
            resultBuffer.append(FizzBuzzConstants.BUZZ);
        }
        if (nextChecker != null) {
            return nextChecker.getResult(number);
        }
        return resultBuffer.toString();
    }

    private boolean isBuzz(int number) {
        return number % 5 == 0;
    }
}
