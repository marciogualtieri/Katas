package kata.game.fizzbuzz;

import kata.game.fizzbuzz.constants.FizzBuzzConstants;

public class FizzBuzz {
    public String getResult(int number) {
        StringBuffer resultBuffer = new StringBuffer();
        if(isFizz(number)) {
            resultBuffer.append(FizzBuzzConstants.FIZZ);
        }
        if(isBuzz(number)) {
            resultBuffer.append(FizzBuzzConstants.BUZZ);
        }
        if(!isFizz(number) && !isBuzz(number)){
            resultBuffer.append(Integer.toString(number));
        }
        return resultBuffer.toString();
    }

    private boolean isFizz(int number) {
        return number % 3 == 0;
    }

    private boolean isBuzz(int number) {
        return number % 5 == 0;
    }
}
