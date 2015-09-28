package kata.game.fizzbuzz;

import kata.game.fizzbuzz.checkers.Checker;
import kata.game.fizzbuzz.checkers.impl.BuzzChecker;
import kata.game.fizzbuzz.checkers.impl.FizzChecker;
import kata.game.fizzbuzz.checkers.impl.NoneChecker;

public class FizzBuzz {
    public String getResult(int number) {
        StringBuffer resultBuffer = new StringBuffer();
        Checker checker = new FizzChecker(new BuzzChecker(new NoneChecker(resultBuffer), resultBuffer), resultBuffer);
        return checker.getResult(number);
    }
}
