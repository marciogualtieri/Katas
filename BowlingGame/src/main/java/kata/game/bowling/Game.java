package kata.game.bowling;

public class Game {
    private final static int TOTAL_NUMBER_OF_FRAMES = 10;
    private final static int TOTAL_NUMBER_OF_PINS = 10;
    private int[] rolls = new int[20];
    private int numberOfRolls = 0;

    public void roll(int pins) {
        rolls[numberOfRolls++] = pins;
    }

    public int score() {
        int score = 0;
        int frameStartIndex = 0;
        for (int i = 0; i < TOTAL_NUMBER_OF_FRAMES; i++) {
            if (isSpareFrame(frameStartIndex)) {
                score += TOTAL_NUMBER_OF_PINS + spareBonus(frameStartIndex);
                frameStartIndex += 2;
            } else if (isStrikeFrame(frameStartIndex)){
                score += TOTAL_NUMBER_OF_PINS + strikeBonus(frameStartIndex);
                frameStartIndex++;
            } else {
                score += sumOfRollsInFrame(frameStartIndex);
                frameStartIndex += 2;
            }

        }
        return score;
    }

    private boolean isSpareFrame(int frameStartIndex) {
        return (rolls[frameStartIndex] + rolls[frameStartIndex + 1]) == TOTAL_NUMBER_OF_PINS;
    }

    private boolean isStrikeFrame(int frameStartIndex) {
        return rolls[frameStartIndex] == TOTAL_NUMBER_OF_PINS;
    }

    private int spareBonus(int frameStartIndex) {
        return rolls[frameStartIndex + 2];
    }

    private int strikeBonus(int frameStartIndex) {
        return rolls[frameStartIndex + 1] + rolls[frameStartIndex + 2];
    }

    private int sumOfRollsInFrame(int frameStartIndex) {
        return rolls[frameStartIndex] + rolls[frameStartIndex + 1];
    }
}