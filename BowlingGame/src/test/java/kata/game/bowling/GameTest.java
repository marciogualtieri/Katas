package kata.game.bowling;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class GameTest {

    private Game testGame;

    @Before
    public void before() throws Exception {
        testGame = new Game();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void whenAllRollsAreGutterBalls_thenScoreZero() throws Exception {
        rollNumberOfTimes(20, 0);
        assertThat(testGame.score(), equalTo(0));
    }

    @Test
    public void whenNoStrikesOrSpares_thenScoreWithNoBonus() throws Exception {
        testGame.roll(3);
        testGame.roll(4);
        testGame.roll(5);
        rollNumberOfTimes(17, 0);
        assertThat(testGame.score(), equalTo(12));
    }

    @Test
    public void whenOneSpareAndRollSix_thenScore22() throws Exception {
        rollOneSpare();
        testGame.roll(6);
        rollNumberOfTimes(17, 0);
        assertThat(testGame.score(), equalTo(22));
    }

    @Test
    public void whenOneStrikeAndRollThreeAndRollFour_thenScore24() throws Exception {
        rollOneStrike();
        testGame.roll(3);
        testGame.roll(4);
        rollNumberOfTimes(17, 0);
        assertThat(testGame.score(), equalTo(24));
    }

    @Test
    public void whenPerfectGame_thenScore300() throws Exception {
        rollNumberOfTimes(12, 10);
        assertThat(testGame.score(), equalTo(300));
    }

    private void rollNumberOfTimes(int numberOfTimes, int rollValue) {
        for (int i = 0; i < numberOfTimes; i++) {
            testGame.roll(rollValue);
        }
    }

    private void rollOneSpare() {
        testGame.roll(5);
        testGame.roll(5);
    }

    private void rollOneStrike() {
        testGame.roll(10);
    }
} 
