import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    @BeforeEach
    void setUp() {
        game = new Game();
    }

    private Game game;

    @Test
    void createGame() {
        assertNotNull(game);
    }

    @Test
    private void assertillegalArgument(String guessNumber) {
        try {
            game.guess(guessNumber);
            fail();
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    public void throwIllegalArgumentExceptionWhenInputIsNull() {
        assertillegalArgument(null);
        assertillegalArgument("12");
        assertillegalArgument("1234");
        assertillegalArgument("12s");
    }


}