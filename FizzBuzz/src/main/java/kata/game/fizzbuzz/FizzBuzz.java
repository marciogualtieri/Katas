package kata.game.fizzbuzz;

public class FizzBuzz {
    public String getResult(int number) {
        if (isFizzBuzz(number)) {
            return FizzBuzzConstants.FIZZBUZZ;
        }
        if (isFizz(number)) {
            return FizzBuzzConstants.FIZZ;
        }
        if (isBuzz(number)) {
            return FizzBuzzConstants.BUZZ;
        }
        return Integer.toString(number);
    }

    private boolean isFizz(int number) {
        return number % 3 == 0;
    }

    private boolean isBuzz(int number) {
        return number % 5 == 0;
    }

    private boolean isFizzBuzz(int number) {
        return isFizz(number) && isBuzz(number);
    }
}
