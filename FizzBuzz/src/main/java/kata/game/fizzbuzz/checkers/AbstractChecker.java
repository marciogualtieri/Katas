package kata.game.fizzbuzz.checkers;

public abstract class AbstractChecker implements Checker {
    protected StringBuffer resultBuffer;
    protected Checker nextChecker = null;

    abstract public String getResult(int number);
}