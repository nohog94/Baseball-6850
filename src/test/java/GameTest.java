import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    private static Game game;

    @BeforeAll
    static void beforeAll() {
        game = new Game();
    }

    @Test
    void createGame() {
        assertNotNull(game);
    }

    @Test
    void throwIllegalArgumentExceptionInvalidInput() {
        assertIllegalArgument(null);
        assertIllegalArgument("12");
        assertIllegalArgument("1234");
        assertIllegalArgument("12s");
        assertIllegalArgument("121");
    }

    private static void assertIllegalArgument(String guessNumber) {
        try {
            game.guess(guessNumber);
            fail();
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    void returnSolvedResultIfMatchedNumber() {
        generateQuestion("123");
        assertMatchedNumber(game.guess("123"), true, 3, 0);
    }

    @Test
    void returnSolvedResultIfunMatchedNumber() {
        generateQuestion("123");
        assertMatchedNumber(game.guess("456"), false, 0, 0);
    }

    @Test
    void returnSolvedResultIfunMatchedNumber1Ball() {
        generateQuestion("123");
        assertMatchedNumber(game.guess("451"), false, 0, 1);
    }

    @Test
    void returnSolvedResultIfunMatchedNumber2Ball() {
        generateQuestion("123");
        assertMatchedNumber(game.guess("431"), false, 0, 2);
    }

    @Test
    void returnSolvedResultIfunMatchedNumber3Ball() {
        generateQuestion("123");
        assertMatchedNumber(game.guess("231"), false, 0, 3);
    }

    @Test
    void returnSolvedResultIf2Strike0Ball() {
        generateQuestion("123");
        assertMatchedNumber(game.guess("124"), false, 2, 0);
    }

    @Test
    void returnSolvedResultIfMatched1Strike1Ball() {
        generateQuestion("123");
        assertMatchedNumber(game.guess("134"), false, 1, 1);
    }

    @Test
    void returnSolvedResultIfMatched1Strike2Ball() {
        generateQuestion("123");
        assertMatchedNumber(game.guess("132"), false, 1, 2);
    }



    private static void generateQuestion(String questionNumber) {
        game.question = questionNumber;
    }

    private static void assertMatchedNumber(GuessResult result, boolean solved, int strikes, int balls) {
        assertThat(result).isNotNull();
        assertThat(result.isSolved()).isEqualTo(solved);
        assertThat(result.getStrikes()).isEqualTo(strikes);
        assertThat(result.getBalls()).isEqualTo(balls);
    }
}
