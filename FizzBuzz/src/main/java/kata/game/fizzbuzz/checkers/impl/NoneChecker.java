package kata.game.fizzbuzz.checkers.impl;

import kata.game.fizzbuzz.checkers.AbstractChecker;

public class NoneChecker extends AbstractChecker {

    public NoneChecker(StringBuffer resultBuffer) {
        this.resultBuffer = resultBuffer;
    }

    @Override
    public String getResult(int number) {
        if (resultBuffer.length() == 0) {
            resultBuffer.append(Integer.toString(number));
        }
        return resultBuffer.toString();
    }
}